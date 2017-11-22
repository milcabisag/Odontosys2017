/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.DetalleOrden;
import OdontoSysModelo.OrdenServicio;
import OdontoSysModelo.Servicio;
import OdontoSysUtil.NewHibernateUtil;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tito
 */
public class DetalleOrdenControlador {
    public static ArrayList<DetalleOrden> insertDetalle(ArrayList<DetalleOrden> list){
        Session session;
        Transaction tr = null;
        DetalleOrden elDetalle;
        try {
            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            Iterator<DetalleOrden> it = list.iterator();
            while(it.hasNext()){
                elDetalle = it.next();
                session.save(elDetalle);
                session.refresh(elDetalle);
            }
            tr.commit();
            session.close();
            } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Orden de Servicio Controlador", JOptionPane.INFORMATION_MESSAGE);
         }        
        
      return list;  
    }
    
    public static boolean actualizarOrden(ArrayList<DetalleOrden> list, OrdenServicio ord) {
        boolean i = false;
        try{ 
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();  
        for(DetalleOrden d : list){
            d.setOrdenServicio(ord);
            session.merge(d);
        }
            tr.commit();      
            session.close();       
            i = true;
       }catch(HibernateException ex){
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Paciente", WIDTH );
       }        
       return i; 
    }
    
    public static Servicio precioConsulta(){
        Servicio consulta = null;
        Session session = null;
        Transaction tr = null;
        try{ 
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();  
            
            String hql = "FROM Servicio WHERE descripcion LIKE '%Consulta%' AND estado = 'Activo'";
            Object query = session.createQuery(hql).uniqueResult();
            
            if(query != null){
                consulta = (Servicio) query;
            }            
            
            tr.commit();      
            session.close();    
       }catch(HibernateException ex){
           tr.rollback();;
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Paciente", WIDTH );
       } 
        return consulta;
    }
}
