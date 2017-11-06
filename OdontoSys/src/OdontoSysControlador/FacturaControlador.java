/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Caja;
import OdontoSysModelo.Factura;
import OdontoSysModelo.FacturaConvenio;
import OdontoSysModelo.FacturaEmpresa;
import OdontoSysModelo.Movimiento;
import OdontoSysModelo.MovimientoEmpresa;
import OdontoSysModelo.Talonario;
import OdontoSysUtil.NewHibernateUtil;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class FacturaControlador {
    
    public static ArrayList<Factura> ConsultarFactura(int idPaciente){
        Session sesion;
        Transaction tr = null;
        ArrayList<Factura> datos = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Factura WHERE paciente = " + idPaciente + " AND estado = 'Pendiente'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            int x;
            datos = new ArrayList();
            Factura fac = new Factura();
            for(;it.hasNext();){
                fac = (Factura) it.next();
                datos.add(fac);
            }
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Factura Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        return datos;
    }
    
    public static Factura insertarFactura(Factura nuevo, Talonario tal){
        Session sesion;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();
            
            sesion.save(nuevo);
            sesion.refresh(nuevo);
            
            modificarOrden(nuevo, sesion);
            TalonarioControlador.UsarFactura(sesion, tal);
            
            if(nuevo.getTipoFactura().compareTo("Crédito") == 0){
                FacturaControlador.agregarMovimientoFacturaCredito(nuevo, sesion);
            }
            
            sesion.getTransaction().commit();
            sesion.close();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Factura", WIDTH );
        }    
        return nuevo;
    }
    
    private static void modificarOrden(Factura nuevo, Session session) {
        int i = 0;
        try{                 
            String hqlUpdate = "UPDATE OrdenServicio SET estado = 'Facturado' WHERE idordenServicio = " + nuevo.getOrdenServicio().getIdordenServicio();
            Query updatedEntities = session.createQuery( hqlUpdate );
            updatedEntities.executeUpdate();
        
       }catch(HibernateException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Estado Orden Servicio", WIDTH );
       }
    }
    
    public static void ModificarSaldoFactura(Session sesion, Factura fact) {
       
        try{  
        
        sesion.merge(fact);
        
        //Si se canceló la factura crédito
        if(fact.getSaldo() == 0){
            fact.setEstado("Cancelado");
            sesion.merge(fact);
        }
        
        sesion.refresh(fact);
        
       }catch(HibernateException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Saldo Factura", WIDTH );
       }
        
    }
    
    public static void insertarFacturaConvenio(FacturaConvenio nuevo, Session sesion){
        int idFactura = 0;
        //Session sesion;
        try{
            //sesion = NewHibernateUtil.getSessionFactory().openSession();
            //sesion.getTransaction().begin();

            idFactura = (int)sesion.save(nuevo);
            sesion.refresh(nuevo);

            //sesion.getTransaction().commit(); 
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Factura Convenio", WIDTH );
        }    
    }
    
    public static boolean upDateFactura(Factura laFactura){
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.getTransaction();
        boolean act = false;
        
        if(laFactura.getSaldo() == 0){
            laFactura.setEstado("Cancelado");
        }        
        try{    
            tx.begin();
            laFactura = (Factura)sesion.merge(laFactura);
            tx.commit();
            act = true;
        }catch(HibernateException ex){
                tx.rollback();
                JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos Update Factura", "Factura Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return act;
    }
    
    public static ArrayList<FacturaEmpresa> ConsultarFacturaEmpresa(int idEmpresa){
        Session sesion;
        Transaction tr = null;
        ArrayList<FacturaEmpresa> datos = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM FacturaEmpresa WHERE empresa = " + idEmpresa + " AND estado = 'Pendiente'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            int x;
            datos = new ArrayList();
            FacturaEmpresa fac = new FacturaEmpresa();
            for(;it.hasNext();){
                fac = (FacturaEmpresa) it.next();
                datos.add(fac);
            }
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Factura Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        return datos;
    }
    
    public static int ModificarSaldoEmpresa(FacturaEmpresa facturaActual, Session session) {
       
        int i = 0;
        try{ 
        
        //Session session = NewHibernateUtil.getSessionFactory().openSession();
        //Transaction tx = session.beginTransaction();
        
        String hqlUpdate = "UPDATE FacturaEmpresa SET saldo = " + facturaActual.getSaldo() + " WHERE idfacturaEmpresa = " + facturaActual.getIdfacturaEmpresa();
        Query updatedEntities = session.createQuery( hqlUpdate );
        updatedEntities.executeUpdate();
        //tx.commit();
        
        if(facturaActual.getSaldo() == 0){
            //tx = session.beginTransaction();
            String modSaldo = "UPDATE FacturaEmpresa SET estado = 'Cancelado' WHERE idfacturaEmpresa = " + facturaActual.getIdfacturaEmpresa();
            updatedEntities = session.createQuery( modSaldo );
            updatedEntities.executeUpdate();
            //tx.commit();
        }
        
       }catch(HibernateException ex){
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Saldo Factura", WIDTH );
       }
        
       return i; 
    }
    
    public static ArrayList<Factura> ConsultarFacturasPaciente(int idPaciente){
        Session sesion;
        Transaction tr = null;
        ArrayList<Factura> datos = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Factura WHERE paciente = " + idPaciente;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            datos = new ArrayList();
            Factura fac = new Factura();
            for(;it.hasNext();){
                fac = (Factura) it.next();
                datos.add(fac);
            }
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Factura Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        return datos;
    }
    
    public static ArrayList<FacturaEmpresa> ConsultarTodasFacturasEmpresa(int idEmpresa){
        Session sesion;
        Transaction tr = null;
        ArrayList<FacturaEmpresa> datos = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM FacturaEmpresa WHERE empresa = " + idEmpresa;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            int x;
            datos = new ArrayList();
            FacturaEmpresa fac = new FacturaEmpresa();
            for(;it.hasNext();){
                fac = (FacturaEmpresa) it.next();
                datos.add(fac);
            }
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Factura Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        return datos;
    }
    
    public static FacturaEmpresa insertarFacturaEmpresa(FacturaEmpresa nuevo){
        int idFactura = 0;
        Session sesion;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();

            idFactura = (int)sesion.save(nuevo);
            sesion.refresh(nuevo);
            insertarMovimientoEmpresa(nuevo);
            sesion.getTransaction().commit();    
            
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Factura Empresa", WIDTH );
        }    
        return nuevo;
    }
    
    public static void modificarFacturaConvenio(FacturaConvenio fc) {
        int i = 0;
        try{         
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        String hqlUpdate = "UPDATE FacturaConvenio f SET f.estado = 'Facturado' WHERE idfacturaConvenio = " + fc.getIdfacturaConvenio();
        Query updatedEntities = session.createQuery( hqlUpdate );
        updatedEntities.executeUpdate();
        tx.commit();
        
       }catch(HibernateException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Estado Factura Convenio", WIDTH );
       }
    }

    public static void agregarMovimientoFacturaCredito(Factura nuevo, Session sesion) {
        Movimiento m = new Movimiento();
        try{

            m.setPaciente(nuevo.getPaciente());
            m.setMovimiento("Factura Crédito Nro 001-001-000"+nuevo.getTalonario().getNroFactura());
            m.setFecha(nuevo.getFecha());
            m.setDebe(nuevo.getMontoTotal());
            m.setHaber(0);
            sesion.save(m);
            sesion.refresh(m);   
            
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Movimiento", WIDTH );
        }    
    }

    private static void insertarMovimientoEmpresa(FacturaEmpresa nuevo) {
        MovimientoEmpresa m = new MovimientoEmpresa();
        Session sesion;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();

            m.setEmpresa(nuevo.getEmpresa());
            m.setMovimiento("Factura Nro "+nuevo.getNroFactura());
            m.setFecha(nuevo.getFecha());
            m.setDebe(nuevo.getMontoTotal());
            m.setFacturaEmpresa(nuevo);
            m.setNotaCreditoEmpresa(null);
            m.setReciboEmpresa(null);
            if(nuevo.getTipo().compareTo("Contado") == 0){
                m.setHaber(nuevo.getMontoTotal());
            }else{
                m.setHaber(0);
            }            
            sesion.save(m);
            sesion.refresh(m);

            sesion.getTransaction().commit();            
            sesion.close();
            
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Movimiento", WIDTH );
        } 
    }

    
    
}
