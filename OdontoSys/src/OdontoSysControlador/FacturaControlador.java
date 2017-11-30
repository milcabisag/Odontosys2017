/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Caja;
import OdontoSysModelo.DetalleOrdenEmpresa;
import OdontoSysUtil.TipoPago;
import OdontoSysModelo.Factura;
import OdontoSysModelo.FacturaEmpresa;
import OdontoSysModelo.Movimiento;
import OdontoSysModelo.MovimientoEmpresa;
import OdontoSysModelo.OrdenEmpresa;
import OdontoSysModelo.Talonario;
import OdontoSysModelo.Usuario;
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
    
    public static Factura insertarFactura(Factura nuevo, Talonario tal, Usuario user, ArrayList<TipoPago> tipo, OrdenEmpresa ordenEmp, ArrayList<DetalleOrdenEmpresa> detOrdEmp){
        Session sesion;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();
            
            
            Movimiento mov  = FacturaControlador.agregarMovimientoFactura(nuevo, sesion);
            
            nuevo.setMovimiento(mov);
            sesion.save(nuevo);
            sesion.refresh(nuevo);
            
            modificarOrden(nuevo, sesion);
            TalonarioControlador.UsarFactura(sesion, tal);
            if(nuevo.getTipoFactura().compareTo("Contado") == 0){
                agregarCaja(sesion, nuevo, mov, user, tipo);      //Agregar entrada en caja
            }
            if(ordenEmp != null){
                insertarOrdenEmpresa(ordenEmp, detOrdEmp, sesion);
            }
            
            sesion.getTransaction().commit();
            sesion.close();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Factura Controlador", WIDTH );
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
    
    public static void ModificarSaldoFactura(Factura fact) {
       
        try{  
        Session sesion = NewHibernateUtil.getSessionFactory().getCurrentSession();
        
        //Si se canceló la factura crédito
        if(fact.getSaldo() == 0){
            fact.setEstado("Cancelado");            
        }
        
        sesion.merge(fact);
        sesion.refresh(fact);
        
       }catch(HibernateException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Saldo Factura", WIDTH );
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
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en ConsultarFacturaEmpresa: "+ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Factura Controlador", JOptionPane.INFORMATION_MESSAGE);
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
    
    public static FacturaEmpresa insertarFacturaEmpresa(FacturaEmpresa nuevo, Talonario tal, Usuario user, ArrayList<OrdenEmpresa> ordenEmp, ArrayList<TipoPago> tipo){
        Session sesion;
        Transaction tr = null;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            
            MovimientoEmpresa mov  = FacturaControlador.insertarMovimientoEmpresa(nuevo, sesion);
            
            nuevo.setMovimientoEmpresa(mov);
            sesion.save(nuevo);
            sesion.refresh(nuevo);
            
            TalonarioControlador.UsarFactura(sesion, tal);
            if(nuevo.getTipo().compareTo("Contado") == 0){
                agregarCajaEmpresa(sesion, mov, user, tipo);      //Agregar entrada en caja
            }
            
            cancelarOrdenEmpresa(ordenEmp, nuevo, sesion);
            
            tr.commit();
            sesion.close();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en insertarFacturaEmpresa: "+ex);
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Factura Controlador", WIDTH );
        }    
        return nuevo;
    }
    
    public static Movimiento agregarMovimientoFactura(Factura nuevo, Session sesion) {
        Movimiento m = null;
        try{
            m = new Movimiento();
            
            if(nuevo.getTipoFactura().compareTo("Crédito") == 0){
                m.setMovimiento("Factura Crédito Nro 001-001-000"+nuevo.getTalonario().getNroFactura());
                m.setDebe(nuevo.getMontoTotal());
            }else{      //Factura Contado
                m.setMovimiento("Factura Contado Nro 001-001-000"+nuevo.getTalonario().getNroFactura());
                m.setDebe(0);
            }
            
            m.setHaber(0);
            m.setPaciente(nuevo.getPaciente());
            m.setFecha(nuevo.getFecha());
            
            sesion.save(m);
            sesion.refresh(m);   
            
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Movimiento", WIDTH );
        }
        return m;
    }

    private static MovimientoEmpresa insertarMovimientoEmpresa(FacturaEmpresa nuevo, Session sesion) {
        MovimientoEmpresa m = null;
        try{
            m = new MovimientoEmpresa();
            m.setEmpresa(nuevo.getEmpresa());
            m.setFecha(nuevo.getFecha());
            m.setMovimiento("Factura Nro 000"+nuevo.getTalonario().getNroFactura());
            m.setDebe(nuevo.getMontoTotal());
            if(nuevo.getTipo().compareTo("Contado") == 0){
                m.setHaber(nuevo.getMontoTotal());
            }else{
                m.setHaber(0);
            }            
            sesion.save(m);
            sesion.refresh(m);
            
        }catch(HibernateException ex){
            System.out.println("Error en insertarMovimientoEmpresa: "+ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Movimiento Empresa", WIDTH );
        } 
        return m;
    }
    
    private static void cancelarOrdenEmpresa(ArrayList<OrdenEmpresa> orden, FacturaEmpresa fact, Session session) {
        try{                 
            for(OrdenEmpresa o : orden){
                o.setFacturaEmpresa(fact);
                o.setEstado("Facturado");
                session.merge(o);
            }
            
       }catch(HibernateException ex){
           System.out.println("Error en cancelarOrdenEmpresa: "+ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Estado Orden Empresa", WIDTH );
       }
    }
    
    private static void agregarCaja(Session sesion, Factura fac, Movimiento mov, Usuario user, ArrayList<TipoPago> rec) {
        
        Caja c = new Caja();
        try{
            for(TipoPago p : rec){
                c.setDescripcion(mov.getMovimiento());
                c.setMovimiento(mov);
                c.setSalida(0);
                c.setTipo(p.getTipo());         //Tipo de Pago
                c.setEntrada(p.getMonto());     //Monto pagado con el tipo de pago elegido
                c.setMovimientoEmpresa(null);
                c.setUsuario(user);
                c.setDescripcion("Entrada");
                
                sesion.save(c);
                sesion.refresh(c);
            }
                        
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Movimiento Caja", WIDTH );
        }
        
    }

    private static void insertarOrdenEmpresa(OrdenEmpresa ordenEmp, ArrayList<DetalleOrdenEmpresa> detOrdEmp, Session sesion) {
        try{
            sesion.save(ordenEmp);
            sesion.refresh(ordenEmp);
            System.out.println("Orden Empresa Nro "+ordenEmp.getIdordenEmpresa());
                    
            for(DetalleOrdenEmpresa d : detOrdEmp){
                d.setOrdenEmpresa(ordenEmp);
                sesion.save(d);
                sesion.refresh(d);
                System.out.println("Detalle Orden Nro "+d.getIddetalleOrdenEmpresa());
            }
                        
        }catch(HibernateException ex){
            System.out.println("Error en isertarOrdenEmpresa: "+ex.getMessage());
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Orden Empresa", WIDTH );
        }
    }

private static void agregarCajaEmpresa(Session sesion, MovimientoEmpresa mov, Usuario user, ArrayList<TipoPago> rec) {
        
        Caja c = new Caja();
        try{
            for(TipoPago p : rec){
                c.setMovimientoEmpresa(mov);
                c.setMovimiento(null);
                c.setDescripcion("Entrada");
                c.setTipo(p.getTipo());         //Tipo de Pago
                c.setEntrada(p.getMonto());     //Monto pagado con el tipo de pago elegido
                c.setSalida(0);
                c.setUsuario(user);
                
                sesion.save(c);
                sesion.refresh(c);
            }
                        
        }catch(HibernateException ex){
            System.out.println("Error en agregarCajaEmpresa"+ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Movimiento Caja", WIDTH );
        }
        
    }    
    
}
