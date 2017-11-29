/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Caja;
import OdontoSysModelo.DetalleRecibo;
import OdontoSysModelo.DetalleReciboemp;
import OdontoSysModelo.Factura;
import OdontoSysModelo.Movimiento;
import OdontoSysModelo.MovimientoEmpresa;
import OdontoSysModelo.Recibo;
import OdontoSysModelo.ReciboEmpresa;
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
public class RecibosControlador {
    
    public static ArrayList<Recibo> ConsultarRecibo(int idFactura){
        Session sesion;
        Transaction tr = null;
        ArrayList<Recibo> datos = new ArrayList();
        Recibo rec = new Recibo();
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Recibo WHERE factura = " + idFactura;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    rec = (Recibo) it.next();
                    datos.add(rec);
                }while(it.hasNext());
            }else{
               return null;
            }
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Recibo Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        return datos;
    }
    
    public static Recibo InsertarRecibo(Recibo nuevo, ArrayList<DetalleRecibo> detalle, Usuario us, Factura fact) {       
        Session sesion;
        Recibo rec = null;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = sesion.beginTransaction();
            
            Movimiento m = new Movimiento();
            m = insertarMovimientoRecibo(sesion, nuevo);
            System.out.println("movim "+m.getIdmovimiento());
            
            nuevo.setMovimiento(m);
            sesion.save(nuevo);
            System.out.println("recibo "+nuevo.getIdrecibo());
            for(DetalleRecibo d : detalle){
                d.setRecibo(nuevo);
                sesion.save(d);
                agregarMovimientoCaja(sesion, m, d, null, null, us);
            }
                        
            fact.setSaldo(fact.getSaldo() - nuevo.getMonto());
            //Si se canceló la factura crédito
            if(fact.getSaldo() == 0){
                fact.setEstado("Cancelado");            
            }
        
            sesion.merge(fact);
            System.out.println("Fact modif "+fact.getIdfactura());
            rec = nuevo;
            //FacturaControlador.ModificarSaldoFactura(fact);
            sesion.refresh(nuevo);
            
            tr.commit();
            //sesion.close();
        }catch(HibernateException ex){
             JOptionPane.showMessageDialog(null, "Error al ingresar nuevo recibo", "Recibo Controlador", JOptionPane.INFORMATION_MESSAGE);   
        }        
        return rec;
    }

    public static Movimiento insertarMovimientoRecibo(Session sesion, Recibo r) {
        Movimiento m = null;
        try{
            m = new Movimiento();
            m.setPaciente(r.getPaciente());
            m.setMovimiento("Recibo por Factura Crédito Nro 001-001-000"+r.getFactura().getTalonario().getNroFactura());
            m.setFecha(r.getFecha());
            m.setDebe(0);
            m.setHaber(r.getMonto());
            
            sesion.save(m);
            sesion.refresh(m);      
            
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Movimiento Recibo", WIDTH );
        }  
        
            return m;
    }
    
    public static ArrayList<ReciboEmpresa> ConsultarReciboEmpresa(int idFactura){
        Session sesion;
        Transaction tr = null;
        ArrayList<ReciboEmpresa> datos = new ArrayList();
        ReciboEmpresa rec = new ReciboEmpresa();
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM ReciboEmpresa WHERE facturaEmpresa = " + idFactura;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    rec = (ReciboEmpresa) it.next();
                    datos.add(rec);
                }while(it.hasNext());
            }else{
               return null;
            }
            
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Recibo Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        return datos;
    }
    
    public static ReciboEmpresa InsertarReciboEmpresa(ReciboEmpresa nuevo, Session sesion) {       
       // Session sesion;
        try{
        //    sesion = NewHibernateUtil.getSessionFactory().openSession();
        //    sesion.getTransaction().begin();            
            sesion.save(nuevo);
            sesion.refresh(nuevo);            
       //     sesion.getTransaction().commit();
            
        }catch(HibernateException ex){
             JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Recibo Controlador", JOptionPane.INFORMATION_MESSAGE);   
        }        
        return nuevo;
    }
    
    public static void InsertarDetalleEmpresa(DetalleReciboemp d, MovimientoEmpresa m, Usuario u, Session sesion) {
        //Session sesion;
        try{
            //sesion = NewHibernateUtil.getSessionFactory().openSession();
            //sesion.getTransaction().begin();            
            sesion.save(d);
            sesion.refresh(d);
            //sesion.getTransaction().commit();
            agregarMovimientoCaja(sesion, null, null, m, d, u);
        }catch(HibernateException ex){
             JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Recibo Controlador", JOptionPane.INFORMATION_MESSAGE);   
        }
    }

    public static MovimientoEmpresa insertarMovimientoEmpresa(ReciboEmpresa nuevo, Session sesion) {
        MovimientoEmpresa m = null;
        //Session sesion;
        try{
         //   sesion = NewHibernateUtil.getSessionFactory().openSession();
         //   sesion.getTransaction().begin();
            
            m = new MovimientoEmpresa();
            m.setEmpresa(nuevo.getEmpresa());
            m.setMovimiento("Recibo por Factura Nro "+nuevo.getFacturaEmpresa().getTalonario().getNroFactura());
            m.setFecha(nuevo.getFecha());
            m.setDebe(0);
            m.setHaber(nuevo.getMonto());
            m.setFacturaEmpresa(nuevo.getFacturaEmpresa());
            
            sesion.save(m);
            sesion.refresh(m);

         //   sesion.getTransaction().commit();            
            
        }
        catch(HibernateException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Movimiento Empresa", WIDTH );
        } 
        return m;
    }

    private static void agregarMovimientoCaja(Session sesion, Movimiento m, DetalleRecibo det, MovimientoEmpresa e, DetalleReciboemp detemp, Usuario u) {
        Caja c = new Caja();
        try{
            
            if(m != null && det != null){
                c.setDescripcion(m.getMovimiento());
                c.setEntrada(det.getMonto());
                c.setMovimiento(m);
                c.setSalida(0);
                c.setTipo(det.getFormaPago());
                c.setMovimientoEmpresa(null);
                c.setUsuario(u);
                c.setDescripcion("Entrada");
            }else if(e != null && detemp != null){      //Recibo de una factura de empresa
                c.setDescripcion(e.getMovimiento());
                c.setEntrada(detemp.getMonto());
                c.setMovimientoEmpresa(e);
                c.setSalida(0);
                c.setTipo(detemp.getFormaPago());
                c.setMovimiento(null);
                c.setUsuario(u);
                c.setDescripcion("Entrada");
            }
            
            sesion.save(c);
            sesion.refresh(c);
            
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Movimiento Caja", WIDTH );
        }  
    }
    
}
