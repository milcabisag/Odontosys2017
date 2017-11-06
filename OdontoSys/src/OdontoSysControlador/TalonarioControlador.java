/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Datos;
import OdontoSysModelo.Talonario;
import OdontoSysUtil.NewHibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author user
 */
public class TalonarioControlador {
    
    public static boolean Guardar(ArrayList<Talonario> tal) {
        Session sesion;
        boolean v = false;
        Talonario t = new Talonario();
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();  
            
            for(int x=0; x<tal.size(); x++){
                t = tal.get(x);
                sesion.save(t);
                sesion.refresh(t);
                System.out.println("id f "+t.getIdtalonario());
            }
            
            v = true;
            sesion.getTransaction().commit();
            sesion.close();
        }catch(HibernateException ex){
            System.out.println("Mensaje "+ex.getMessage());
             JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Talonario Controlador", JOptionPane.INFORMATION_MESSAGE);   
        }        
        return v;
    }
    
    public static Talonario BuscarFacturaLibre(){
    
        Talonario tal = null;
        Session sesion;
        
        try{
             sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();  
            
            tal = new Talonario();
            String hql1 = "SELECT min(idtalonario) FROM Talonario WHERE estado = 'Libre'";
            Query query = sesion.createQuery(hql1); 
            int t = (int) query.uniqueResult();
            
            String hql2 = "FROM Talonario WHERE idtalonario = "+t;
            Query query2 = sesion.createQuery(hql2); 
            tal = (Talonario) query2.uniqueResult();
            
            sesion.close();
        }catch(HibernateException ex){
             System.out.println("Mensaje "+ex.getMessage());
             JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Talonario Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return tal;
    }

    public static Datos DatosdeFactura(){
        
        Datos dat = null;
        Session sesion;
        try{
             sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();  
            
            dat = new Datos();
            String hql = "FROM Datos WHERE idDatos = 1";
            Query query = sesion.createQuery(hql); 
            dat = (Datos) query.uniqueResult();
            
            sesion.close();
        }catch(HibernateException ex){
             System.out.println("Mensaje "+ex.getMessage());
             JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Talonario Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return dat;
    }

    public static void UsarFactura(Session sesion, Talonario tal) {
       
        try{
            
            tal.setEstado("Usado");
            sesion.merge(tal);
            sesion.refresh(tal);
            
        }catch(HibernateException ex){
             System.out.println("Mensaje "+ex.getMessage());
             JOptionPane.showMessageDialog(null, "Error al usar número de factura", "Talonario Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}