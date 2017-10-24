/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

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
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();
            
            sesion.save(conv);                          //Guarda el convenio
            
            Iterator<DetalleConvenio> it = det.iterator();
            DetalleConvenio d = new DetalleConvenio();
            while(it.hasNext()){
                d = (DetalleConvenio) it.next();
                d.setConvenio(conv);
                sesion.save(d);                       //Guarda el detalle del convenio
            }
            sesion.getTransaction().commit();
            val = true;
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Convenio", WIDTH );
       }        
        return val;
    }
    
    /*public static boolean BuscarConvenio(Convenio conv){
        Session sesion;
        Transaction tr = null;
        boolean c = false;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Convenio WHERE paciente = "+ conv.getPaciente().getIdPaciente()+" AND empresa = "+ conv.getEmpresa().getIdempresa();
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                c = true;
            }else{
                c = false;
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return c;
    }
   */
    
    public static ArrayList<DetalleConvenio> BuscarDetalleConvenio(Convenio conv){
        Session sesion;
        Transaction tr = null;
        ArrayList<DetalleConvenio> lis = null;
        String hql;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            hql = "FROM detalle_convenio WHERE estado = 'Activo' AND convenio = "+conv.getIdconvenio();
            
            Query query = sesion.createQuery(hql); 
            Iterator<DetalleConvenio> it = query.iterate();
            if(hql != null){
                lis = new ArrayList();
                while(it.hasNext()){
                    lis.add(it.next());
                }
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lis;
    }
    
    public static ArrayList<Empresa> BuscarConvenioEmpresa(Paciente pac){
        Session sesion;
        Transaction tr = null;
        ArrayList<Empresa> lis = new ArrayList();
        String hql = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            if(pac != null){
                hql = "SELECT DISTINCT empresa FROM Convenio WHERE estado = 'Activo' AND paciente = "+pac.getIdPaciente();
                
                if(hql != null){
                    Query query = sesion.createQuery(hql); 
                    Iterator<Empresa> it = query.iterate();
                
                    while(it.hasNext()){
                        lis.add(it.next());
                    }
                }
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lis;
    }
    
    public static boolean modificarConvenio(Convenio conv, ArrayList<DetalleConvenio> det) {
        boolean val = false;
        Session session;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = session.beginTransaction();
            
            session.merge(conv);
            
            Iterator<DetalleConvenio> it = det.iterator();
            DetalleConvenio d;
            while(it.hasNext()){
                d = (DetalleConvenio) it.next();
                session.merge(d);                       
            }           
                 
            tr.commit();      
            session.close();  
       
            val = true;
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Convenio", WIDTH );
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
        Session session;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = session.beginTransaction(); 
            
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
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Convenio", WIDTH );
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
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lis;
    }
    
}
