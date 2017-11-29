/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.ConvPaciente;
import OdontoSysModelo.Convenio;
import OdontoSysModelo.Empresa;
import OdontoSysModelo.Paciente;
import OdontoSysModelo.DetalleConvenio;
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
 * @author Tito
 */
public class ConvenioControlador {
 
    public static boolean insertarConvenio(Convenio conv, ArrayList<DetalleConvenio> det) {
        boolean val = false;
        Session sesion;
        Transaction tr = null;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            
            sesion.save(conv);                          //Guarda el convenio
            
            Iterator<DetalleConvenio> it = det.iterator();
            DetalleConvenio d = new DetalleConvenio();
            while(it.hasNext()){
                d = (DetalleConvenio) it.next();
                d.setConvenio(conv);
                sesion.save(d);                       //Guarda el detalle del convenio
            }
            tr.commit();
            sesion.close();
            val = true;
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en insertarConvenio: "+ex);
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Convenio", WIDTH );
       }        
        return val;
    }
    
    public static boolean insertarConvenioPaciente(ConvPaciente conv) {
        boolean val = false;
        Session sesion;
        Transaction tr = null;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            
            sesion.save(conv);                          //Guarda el convenio
            sesion.refresh(conv);
            
            tr.commit();
            sesion.close();
            val = true;
        }catch(HibernateException ex){
            tr.rollback();
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Convenio", WIDTH );
       }        
        return val;
    }
    
    public static ArrayList<Convenio> BuscarConvenioEmpresa(Empresa emp, Session sesion){
        //Transaction tr = null;
        ArrayList<Convenio> c = null;
        try{        
            if(sesion == null){
                sesion = NewHibernateUtil.getSessionFactory().openSession();
                //tr = sesion.beginTransaction();
            }
            String hql = "FROM Convenio WHERE empresa = "+ emp.getIdempresa()+" AND estado = 'Activo'";
            Query query = sesion.createQuery(hql); 
            if(query != null){
                Iterator<Convenio> it = query.iterate();
                c = new ArrayList();
                while(it.hasNext()){
                    c.add(it.next());
                }
            }else{
                c = null;
            }
            //tr.commit();
        }catch(HibernateException ex){
            //tr.rollback();
            System.out.println("Error en BuscarConvenioEmpresa: "+ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return c;
    }

    
    public static ArrayList<DetalleConvenio> BuscarDetalleConvenio(Convenio conv, Session sesion){
        //Session sesion;
        Transaction tr = null;
        ArrayList<DetalleConvenio> lis = null;
        String hql;
        try{        
            if(sesion == null){
                sesion = NewHibernateUtil.getSessionFactory().getCurrentSession();//.openSession();
            }
            //tr = sesion.beginTransaction();
            hql = "FROM DetalleConvenio WHERE estado = 'Activo' AND convenio = "+conv.getIdconvenio();
            
            Query query = sesion.createQuery(hql); 
            Iterator<DetalleConvenio> it = query.iterate();
            if(hql != null){
                lis = new ArrayList();
                while(it.hasNext()){
                    lis.add(it.next());
                }
            }
            
            //tr.commit();
        }catch(HibernateException ex){
            //tr.rollback();
            System.out.println("Error en BuscarDetalleConvenio: "+ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lis;
    }
    
    public static ArrayList<ConvPaciente> BuscarConvenioPaciente(int pac, Session sesion){
        Transaction tr = null;
        ArrayList<ConvPaciente> lis = null;
        String hql = null;
        try{     
            if(sesion == null){
                sesion = NewHibernateUtil.getSessionFactory().openSession();
            }
            tr = sesion.beginTransaction();
            if(pac > 0){
                hql = "FROM ConvPaciente WHERE estado = 'Activo' AND paciente = "+pac;
                Query query = sesion.createQuery(hql);
                Iterator<ConvPaciente> it = query.iterate();
                if(it.hasNext()){
                    lis = new ArrayList();
                    do{
                        ConvPaciente c = (ConvPaciente) it.next();
                        lis.add(c); 
                    }while(it.hasNext());
                }
            }
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en Buscar convenio paciente: "+ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lis;
    }
    
    public static boolean modificarConvenio(Convenio conv, ArrayList<DetalleConvenio> det, Session session) {
        boolean val = false;
        //Session session;
        Transaction tr = null;
        try{
            //session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            
            session.clear();
            
            session.merge(conv);
            session.refresh(conv);
            
            for(DetalleConvenio d : det){
                if(d.getConvenio() != null){  //Verificar si el detalle ya existe
                   session.merge(d);    
                   session.refresh(d); 
                }else{                       // El detalle no existe, hay que crearlo
                   d.setConvenio(conv);
                   session.save(d);
                   session.refresh(d);
                }
                System.out.println("Detalle: "+d.getIddetalleConvenio()+" Porcentaje: "+d.getPorcentaje()+" Estado: "+d.getEstado());
            }           
            tr.commit();      
            //session.close();  
       
            val = true;
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en modificarConvenio: "+ex);
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Convenio", WIDTH );
       }        
        return val;
    }

    public static boolean modificarConvenioPaciente(ConvPaciente conv) {
        boolean val = false;
        Session session;
        Transaction tr = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            
            session.update(conv);
            
            tr.commit();      
            session.close();  
       
            val = true;
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en modificarConvenioPaciente: "+ex);
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Convenio del Paciente", WIDTH );
       }        
        return val;
    }
    
    public static ArrayList<Paciente> BuscarConvenioPaciente() {
        Session sesion;
        Transaction tr = null;
        ArrayList<Paciente> lis = new ArrayList();
        String hql;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            hql = "SELECT DISTINCT c.paciente FROM Convenio c WHERE c.estado = 'Activo'";
            Query query = sesion.createQuery(hql); 
            Iterator<Paciente> it = query.iterate();
            while(it.hasNext()){
                lis.add(it.next());
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lis;
    }
    
    public static boolean eliminarConvenio(Convenio conv, ArrayList<DetalleConvenio> det) {
        boolean val = false;
        Session session = null;
        Transaction tr = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction(); 
            
            conv.setEstado("Inactivo");
            session.merge(conv);
            
            Iterator<DetalleConvenio> it = det.iterator();
            DetalleConvenio d = new DetalleConvenio();
            while(it.hasNext()){
                d = (DetalleConvenio) it.next();
                d.setEstado("Inactivo");
                session.merge(d);
            }
            tr.commit();           
            session.close();  
            
            val = true;
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en eliminarConvenio: "+ex);
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Eliminar Convenio", WIDTH );
       }        
        return val;
    }

    public static boolean eliminarConvenioPaciente(ConvPaciente conv) {
        boolean val = false;
        Session session;
        Transaction tr = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction(); 
            
            conv.setEstado("Inactivo");
            session.merge(conv);
            
            tr.commit();           
            session.close();  
            
            val = true;
        }catch(HibernateException ex){
            tr.rollback();
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Eliminar Convenio", WIDTH );
       }        
        return val;
    }
    
    public static int BuscarPorcentajeConvenio(int pac, int idempresa, int idservicio, Session sesion) {
        //Session sesion;
        //Transaction tr = null;
        String hql;
        int porc = 0;
        try{        
            //sesion = NewHibernateUtil.getSessionFactory().openSession();
            //tr = sesion.beginTransaction();
            hql = "SELECT porcentaje FROM Convenio WHERE estado = 'Activo' AND paciente = "+pac+" AND empresa = "+idempresa+" AND servicio = "+idservicio;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                porc = (int)it.next();
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return porc;
    }

    public static ArrayList<Paciente> BuscarPacientesConConvenios(Empresa emp) {
        //Retorna todos los pacientes asociados a una empresa
        Session sesion;
        Transaction tr = null;
        ArrayList<Paciente> lis = null;
        String hql;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            hql = "SELECT DISTINCT c.paciente FROM Convenio AS c WHERE c.estado = 'Activo' AND c.empresa = "+emp.getIdempresa();
            Query query = sesion.createQuery(hql); 
            Iterator<Paciente> it = query.iterate();
            if(it.hasNext()){
                lis = new ArrayList();
                while(it.hasNext()){
                lis.add(it.next());
                }
            }
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en BuscarPacientesConConvenios: "+ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lis;
    }

    public static ArrayList<DetalleConvenio> obtenerDetalleConvenio(ConvPaciente conv) {
         //Retorna todos la lista del detalle del convenio
        Session sesion;
        Transaction tr = null;
        ArrayList<DetalleConvenio> lis = null;
        String hql;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            hql = "FROM DetalleConvenio WHERE estado = 'Activo' AND convenio = "+conv.getConvenio().getIdconvenio();
            Query query = sesion.createQuery(hql); 
            Iterator<DetalleConvenio> it = query.iterate();
            if(it.hasNext()){
                lis = new ArrayList();
                while(it.hasNext()){
                lis.add(it.next());
                }
            }
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en obtenerDetalleConvenio: "+ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lis;
    }
    
}
