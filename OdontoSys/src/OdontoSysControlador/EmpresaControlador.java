/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Empresa;
import OdontoSysModelo.FacturaEmpresa;
import OdontoSysModelo.MovimientoEmpresa;
import OdontoSysModelo.OrdenEmpresa;
import OdontoSysModelo.ReciboEmpresa;
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
public class EmpresaControlador {
    
    
    public static int insertarEmpresa(Empresa nuevaEmpresa) {
        int i = 0;
        Empresa aux;
        Session sesion = null;
        Transaction tr = null;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            aux = BuscarRUC(nuevaEmpresa.getRuc());          //Busca si ya existe la empresa          
            if(aux == null){                                // Si no existe, inserta nuevo
                i = (int)sesion.save(nuevaEmpresa);
            }else{
                JOptionPane.showMessageDialog(null,"El RUC ya existe, no se puede insertar", "Insertar Empresa", WIDTH );
            }         
            tr.commit();
            sesion.close();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en insertarEmpresa: "+ex);
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Empresa", WIDTH );
       }        
        return i;
    }
    
    public static int UpdateEmpresa(Empresa empresa, Session session) {
       int i = 0;
       Transaction tr = null;
        try{ 
            //session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tr = session.beginTransaction();
            session.merge(empresa);
            session.refresh(empresa);
            tr.commit();
            i = empresa.getIdempresa();
       }catch(HibernateException ex){
           tr.rollback();
           System.out.println("Error en UpdateEmpresa: "+ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Empresa", WIDTH );
       }        
       return i; 
    }
    
    public static boolean EliminarEmpresa(Empresa empActual) {
        boolean i = false;
        Session session = null;
        Transaction tx  = null;
        try{         
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            
            empActual.setEstado("Inactivo");
            session.update(empActual);
            
            tx.commit();
            session.close();
            i = true;
       }catch(HibernateException ex){
           tx.rollback();
            System.out.println("Error en EliminarEmpresa: "+ex);
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Eliminar Empresa", WIDTH );
       }        
       return i; 
    }
    
    public static ArrayList<Empresa> ConsultarEmpresa () {
        ArrayList<Empresa> lista = new ArrayList<>();
        Session session;
        Transaction tr = null;
        try {            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            String hql = "FROM Empresa WHERE estado = 'Activo'";
            Query query = session.createQuery(hql);
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    Empresa nuevo = (Empresa) it.next();
                    lista.add(nuevo);
                }while(it.hasNext());       
            }else{
                lista = null;
            }
            tr.commit();
        } catch (HibernateException ex) {
            tr.rollback();
            System.out.println("Error en ConsultarEmpresa: "+ex);
           JOptionPane.showMessageDialog(null,"No se pudo conectar a la Base de Datos", "Empresa Controlador", WIDTH );
       }        
        return lista;
    }    
    
    public static Empresa BuscarRUC(String ruc){
        Session sesion;
        Transaction tr = null;
        Empresa e =null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Empresa WHERE estado = 'Activo' AND ruc = '"+ruc+"'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                e = (Empresa)it.next();
            }else{
               return null;
            }
            tr.commit();
            sesion.close();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en BuscarRUC: "+ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Empresa Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return e;
    }
    
    public static Empresa BuscarId(int idEmp){
        Session sesion;
        Transaction tr = null;
        Empresa e =null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Empresa WHERE idEmpresa = "+idEmp;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                e = (Empresa)it.next();
            }else{
               return null;
            }
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en BuscarId: "+ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Empresa Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return e;
    }
 
    public static ArrayList<FacturaEmpresa> ObtenerEstadoCuenta(Empresa emp, Session session) {
        ArrayList<FacturaEmpresa> lista = null;
        //Session session;
        Transaction tr = null;
        try {            
            //session = NewHibernateUtil.getSessionFactory().openSession();
            //tr = session.beginTransaction();
            String hql = "FROM FacturaEmpresa WHERE empresa = "+emp.getIdempresa()+" AND estado = 'Pendiente'";
            Query query = session.createQuery(hql);
            Iterator it = query.iterate();
            if(it.hasNext()){
                lista = new ArrayList<>();
                do{
                    FacturaEmpresa nuevo = (FacturaEmpresa) it.next();
                    lista.add(nuevo);
                }while(it.hasNext());       
            }
            //tr.commit();
        } catch (HibernateException ex) {
            //tr.rollback();
            System.out.println("Error en ObtenerEstadoCuenta: "+ex);
           JOptionPane.showMessageDialog(null,"No se pudo conectar a la Base de Datos", "Empresa Controlador", WIDTH );
       }        
        return lista;
    }

    public static ArrayList<ReciboEmpresa> HistoricoRecibo(int idfacturaEmpresa, Session sesion) {
        Transaction tr = null;
        ArrayList<ReciboEmpresa> histRec = new ArrayList();
        ReciboEmpresa r = null;
        try{ 
            tr = sesion.beginTransaction();
            String hql = "FROM ReciboEmpresa r WHERE r.factura = "+idfacturaEmpresa;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    r = (ReciboEmpresa) it.next();
                    histRec.add(r);
                }while(it.hasNext());
            }else{
                histRec = null;
            }
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en HistóricoRecibo: "+ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Empresa Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return histRec;
    }

    public static ArrayList<OrdenEmpresa> ordenPendiente(int idempresa, Session sesion) {
        Transaction tr = null;
        ArrayList<OrdenEmpresa> orden = null;
        OrdenEmpresa o = null;
        try{ 
            tr = sesion.beginTransaction();
            String hql = "SELECT o.* FROM OrdenEmpresa o JOIN ConvPaciente c ON o.convpaciente = c.idconvpaciente "
                    + "JOIN Convenio a ON a.idconvenio = c.convenio WHERE o.estado = 'Pendiente' AND a.empresa = "+idempresa;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                orden = new ArrayList();
                do{
                    o = (OrdenEmpresa) it.next();
                    orden.add(o);
                }while(it.hasNext());
            }
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en ordenPendiente: "+ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Empresa Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return orden;
    }

    public static int montoOrden(int idordenEmpresa, Session sesion) {
        int monto = 0;
        Transaction tr = null;
        try{
            tr = sesion.beginTransaction();
            String hql = "SELECT SUM(monto) FROM DetalleOrdenEmpresa WHERE ordenEmpresa = "+idordenEmpresa;
            Query query = sesion.createQuery(hql); 
            if(query != null){
                monto = (int) query.uniqueResult();
            }
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en montoOrden: "+ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Empresa Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return monto;
    }
    
}
