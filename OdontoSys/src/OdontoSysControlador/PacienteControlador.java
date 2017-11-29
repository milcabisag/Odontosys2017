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
            String hql = "FROM Paciente P WHERE P.nroCi = "+cedula+" AND P.estado = 'Activo'";
            p = new Paciente();
            p = (Paciente) sesion.createQuery(hql).uniqueResult(); 
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en Buscar Cedula: "+ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Paciente Controlador", JOptionPane.INFORMATION_MESSAGE);
         }       
        return p;
    }   

    public static int insertarPaciente(Paciente nuevoPaciente) {
        int i = 0;
        Session sesion;
        Transaction tx = null;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
            sesion.save(nuevoPaciente);
            sesion.refresh(nuevoPaciente);
            tx.commit();
            i = nuevoPaciente.getIdPaciente();
        }catch(HibernateException ex){
            tx.rollback();
            System.out.println("Error en insertar paciente: "+ex);
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Paciente", WIDTH );
       }        
        return i;
    }

    public static int UpDatePaciente(Paciente pacienteActual) {
       int i = 0;
       Session session = null;
       Transaction tr = null;        
        try{ 
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
 
            session.clear();        
            session.merge(pacienteActual);
            session.refresh(pacienteActual);
            
            tr.commit();      
            i = pacienteActual.getIdPaciente();
       }catch(HibernateException ex){
           tr.rollback();
           System.out.println("Error en update paciente: "+ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Paciente", WIDTH );
       }finally{                 
            session.close();
        }        
       return i; 
    }

    public static boolean Eliminar(Paciente pacienteActual) {
        boolean i = false;
       Session session;
       Transaction tx = null; 
        try{         
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            pacienteActual.setEstado("Inactivo");
            session.merge(pacienteActual);
            tx.commit();
            i = true;
       }catch(HibernateException ex){
           tx.rollback();
           System.out.println("Error en Eliminar Paciente: "+ex);
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Eliminar Paciente", WIDTH );
       }        
       return i; 
    }    
    
    public static ArrayList<Paciente> ConsultarPaciente(Session sesion){
        //Session sesion;
        Transaction tr = null;
        ArrayList<Paciente> datos = null;
        Paciente pac = new Paciente();
        try{ 
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Paciente WHERE estado = 'Activo'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                datos = new ArrayList();
                do{
                    pac = (Paciente) it.next();
                    datos.add(pac);
                }while(it.hasNext());
            }
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en Consultar Paciente : "+ex);
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
            p = (Paciente) sesion.createQuery(hql).uniqueResult(); 
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en Buscar id: "+ex);
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
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en calcular saldo: "+ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Paciente Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return s;
    }

    public static ArrayList<Factura> HistoricoDeEstado(int pac, Session sesion) {
        Transaction tr = null;
        ArrayList<Factura> histFacturas = null;
        Factura f = null;
        try{        
            tr = sesion.beginTransaction();
            String hql = "FROM Factura WHERE paciente = "+pac+" AND estado = 'Pendiente'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                histFacturas = new ArrayList();
                do{
                    f = (Factura) it.next();
                    histFacturas.add(f);
                }while(it.hasNext());
            }
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en Histórico de Estado: "+ex);
            JOptionPane.showMessageDialog(null, "Error al Recuperar Estado de Cuenta", "Paciente Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return histFacturas;
    }
    
    public static ArrayList<Recibo> HistoricoRecibo(int fact, Session sesion) {
        Transaction tr = null;
        ArrayList<Recibo> histRec = new ArrayList();
        Recibo r = null;
        try{ 
            tr = sesion.beginTransaction();
            String hql = "FROM Recibo r WHERE r.factura = "+fact;
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
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            System.out.println("Error en Histórico de recibo: "+ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Paciente Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return histRec;
    }
    
    
}
   

