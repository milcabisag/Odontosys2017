/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Datos;
import OdontoSysModelo.Talonario;
import OdontoSysUtil.NewHibernateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    public static Talonario BuscarFacturaLibre(Session sesion){
    
        Talonario tal = null;
        try{
            tal = new Talonario();
            String hql1 = "SELECT min(idtalonario) FROM Talonario WHERE estado = 'Libre'";
            Query query = sesion.createQuery(hql1); 
            
            if(query.uniqueResult() != null){
                int t = (int) query.uniqueResult();
                String hql2 = "FROM Talonario WHERE idtalonario = "+t;
                Query query2 = sesion.createQuery(hql2); 
                tal = (Talonario) query2.uniqueResult();
            }else{
                JOptionPane.showMessageDialog(null, "Sin factura libre, favor ingrese nuevo talonario", "Talonario Usado", JOptionPane.INFORMATION_MESSAGE);
                tal = null;
            }
            
        }catch(HibernateException ex){
             System.out.println("Mensaje "+ex.getMessage());
             JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Talonario Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return tal;
    }

    public static Datos DatosdeFactura(Session sesion){
        
        Datos dat = null;
        try{            
            dat = new Datos();
            String hql = "FROM Datos WHERE idDatos = 1";
            Query query = sesion.createQuery(hql); 
            dat = (Datos) query.uniqueResult();
        }catch(HibernateException ex){
             System.out.println("Mensaje "+ex.getMessage());
             JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Talonario Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return dat;
    }

    public static void UsarFactura(Session sesion, Talonario tal) {
      
        try{
            String hql = "UPDATE Talonario SET estado = 'Usado' WHERE idtalonario = "+tal.getIdtalonario();
            Query q = sesion.createQuery(hql);
            q.executeUpdate();
            
        }catch(HibernateException ex){
             System.out.println("Mensaje "+ex.getMessage());
             JOptionPane.showMessageDialog(null, "Error al usar número de factura", "Talonario Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static boolean FacturaVencida(){
        
        Session sesion = null;
        Transaction tx = null;
        Boolean v = false;
        
                     //Recupera y setea fecha dde hoy
        Date fecha = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        String fec = f.format(fecha);
        
        ArrayList<String> notif =null;
        
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
            
                    //Recupera las facturas que están vencidas y no se hayan usado
            String hql = "FROM Talonario WHERE finVigencia < '" + fec + "' AND estado = 'Libre'";
            ArrayList<Talonario> venc = (ArrayList<Talonario>) sesion.createQuery(hql).list(); 
            if(venc != null){
                notif = new ArrayList();
                for(Talonario tal : venc){
                    tal.setEstado("Vencido");
                    sesion.update(tal);
                    notif.add("001-001-000"+tal.getNroFactura());
                }
            }
            if(notif.size() > 0){
                System.out.println("Facturas Vencidas: ");
                for(String n : notif){
                    System.out.println(n);
                }
                JOptionPane.showMessageDialog(null, "Se han encontrado "+notif.size()+" facturas vencidas.", "Facturas Vencidas", JOptionPane.INFORMATION_MESSAGE);
            }
            
                    //Busca si queda factura libre
            hql = "FROM Talonario WHERE estado = 'Libre' AND finVigencia >= '"+fec+"'";
            Query query = sesion.createQuery(hql);
            Iterator it = query.iterate();
            if(it.hasNext()){
                v = false;
            }else{
                v = true;
            }
            
            tx.commit();
            sesion.close();
        }catch(HibernateException ex){
            tx.rollback();
            System.out.println("Error en Factura Vencida "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al ver factura vencida", "Talonario Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return v;
    }
    
}