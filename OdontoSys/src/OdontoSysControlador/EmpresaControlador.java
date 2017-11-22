/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Empresa;
import OdontoSysModelo.FacturaConvenio;
import OdontoSysModelo.MovimientoEmpresa;
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
    
    public static int UpdateEmpresa(Empresa empresa) {
       int i = 0;
       Transaction tr = null;
       Session session = null;
        try{ 
        session = NewHibernateUtil.getSessionFactory().openSession();
        tr = session.beginTransaction();  
        
        session.update(empresa);
        session.refresh(empresa);
        
        tr.commit();      
        session.close();       
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
    
    public static Empresa BuscarRUC(int ruc){
        Session sesion;
        Transaction tr = null;
        Empresa e =null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Empresa WHERE estado = 'Activo' AND ruc = "+ruc;
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
    
    public static ArrayList<FacturaConvenio> FacturaPendiente(int idEmpresa) {
        ArrayList<FacturaConvenio> lista = null;
        Session session;
        Transaction tr = null;
        try {            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            String hql = "FROM FacturaConvenio WHERE empresa = "+idEmpresa+" AND estado = 'Pendiente'";
            Query query = session.createQuery(hql);
            Iterator it = query.iterate();
            if(it.hasNext()){
                lista = new ArrayList<>();
                do{
                    FacturaConvenio nuevo = (FacturaConvenio) it.next();
                    lista.add(nuevo);
                }while(it.hasNext());       
            }else{
                lista = null;
            }
            tr.commit();
        } catch (HibernateException ex) {
            tr.rollback();
            System.out.println("Error en FacturaPendiente: "+ex);
           JOptionPane.showMessageDialog(null,"No se pudo conectar a la Base de Datos", "Empresa Controlador", WIDTH );
       }        
        return lista;
    }    

    public static ArrayList<MovimientoEmpresa> ObtenerEstadoCuenta(Empresa emp) {
        ArrayList<MovimientoEmpresa> lista = null;
        Session session;
        Transaction tr = null;
        try {            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            String hql = "FROM MovimientoEmpresa WHERE empresa = "+emp.getIdempresa();
            Query query = session.createQuery(hql);
            Iterator it = query.iterate();
            if(it.hasNext()){
                lista = new ArrayList<>();
                do{
                    MovimientoEmpresa nuevo = (MovimientoEmpresa) it.next();
                    lista.add(nuevo);
                }while(it.hasNext());       
            }
            tr.commit();
        } catch (HibernateException ex) {
            tr.rollback();
            System.out.println("Error en ObtenerEstadoCuenta: "+ex);
           JOptionPane.showMessageDialog(null,"No se pudo conectar a la Base de Datos", "Empresa Controlador", WIDTH );
       }        
        return lista;
    }
    
}
