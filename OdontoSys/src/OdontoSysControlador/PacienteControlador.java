package OdontoSysControlador;

import OdontoSysModelo.Factura;
import OdontoSysModelo.Movimiento;
import OdontoSysModelo.Paciente;
import OdontoSysModelo.Recibo;
import OdontoSysUtil.NewHibernateUtil;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class PacienteControlador {
    public static Paciente BuscarCedula(int cedula){
        Session sesion;
        Transaction tr = null;
        Paciente p =null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Paciente P WHERE P.nroCi = "+String.valueOf(cedula)+" AND estado = 'Activo'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                p = new Paciente();
                p = (Paciente)it.next();
            }else{
                sesion.close();
               return null;
            }  
            sesion.close();
        }catch(HibernateException ex){
               //JOptionPane.showInputDialog ( null, "ocurrio HibernateException al construir session" , "PacienteControlador" , JOptionPane.INFORMATION_MESSAGE );
               JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Paciente Controlador", JOptionPane.INFORMATION_MESSAGE);
         }       
        return p;
    }   

    public static int insertarPaciente(Paciente nuevoPaciente) {
        int i = 0;
        Paciente aux;
        Session sesion;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();
            aux = BuscarCedula(nuevoPaciente.getNroCi());                    
            if(aux == null){                
                i = (int)sesion.save(nuevoPaciente);
            }else{                
                nuevoPaciente.setIdPaciente(aux.getIdPaciente());
                i = UpDatePaciente(nuevoPaciente);
            }           
            sesion.getTransaction().commit();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Paciente", WIDTH );
       }        
        return i;
    }

    public static int UpDatePaciente(Paciente pacienteActual) {
       int i = 0;
        try{ 
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();        
        session.merge(pacienteActual);
        tr.commit();      
        session.close();       
        i = pacienteActual.getIdPaciente();
       }catch(HibernateException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Paciente", WIDTH );
       }        
       return i; 
    }

    public static boolean Eliminar(Paciente pacienteActual) {
        boolean i = false;
        try{         
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            String hqlUpdate = "UPDATE Paciente SET estado = 'Inactivo' WHERE idPaciente = " + pacienteActual.getIdPaciente();
            Query updatedEntities = session.createQuery( hqlUpdate );
            updatedEntities.executeUpdate();
            tx.commit();
            session.close();
            i = true;
       }catch(HibernateException ex){
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Eliminar Paciente", WIDTH );
       }        
       return i; 
    }    
    
    public static ArrayList<Paciente> ConsultarPaciente(){
        Session sesion;
        Transaction tr = null;
        ArrayList<Paciente> datos = new ArrayList();
        Paciente pac = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Paciente WHERE estado = 'Activo'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    pac = (Paciente) it.next();
                    datos.add(pac);
                }while(it.hasNext());
            }else{
               return null;
            }
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Paciente Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        return datos;
    }
    
    public static Paciente BuscarID(int idPaciente){
        Session sesion;
        Transaction tr = null;
        Paciente p =null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Paciente P WHERE P.idPaciente = "+ idPaciente+" AND P.estado = 'Activo'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
             p = (Paciente)it.next();
            }else{
               return null;
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Paciente Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return p;
    }

    public static int calcularSaldo(Date date, int idPac) {
        int s = 0;
        Session sesion;
        Transaction tr = null;
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "SELECT SUM(m.debe)-SUM(m.haber) FROM Movimiento m WHERE m.paciente = "+idPac+" AND m.fecha < '"+fecha.format(date)+"'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
             s =Integer.parseInt(it.next().toString());
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Paciente Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return s;
    }

    public static ArrayList<Factura> HistoricoDeEstado(Paciente pac) {
        Session sesion;
        ArrayList<Factura> histFacturas = new ArrayList();
        Factura f = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().getCurrentSession();
            //Transaction tr = sesion.beginTransaction();
            String hql = "FROM Factura WHERE paciente = "+pac.getIdPaciente()+" AND estado = 'Pendiente'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    f = (Factura) it.next();
                    histFacturas.add(f);
                }while(it.hasNext());
            }else{
                histFacturas = null;
            }
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al Recuperar Estado de Cuenta", "Paciente Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        return histFacturas;
    }
    
    public static ArrayList<Recibo> HistoricoRecibo(Factura fact) {
        Session sesion;
        ArrayList<Recibo> histRec = new ArrayList();
        Recibo r = null;
        try{ 
            sesion = NewHibernateUtil.getSessionFactory().getCurrentSession();
            //Transaction tr = sesion.beginTransaction();
            String hql = "FROM Recibo WHERE factura = "+fact.getIdfactura();
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    r = (Recibo) it.next();
                    histRec.add(r);
                }while(it.hasNext());
            }else{
                histRec = null;
            }
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Paciente Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        return histRec;
    }
    
    
}
   

