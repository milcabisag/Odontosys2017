package OdontoSysControlador;

import OdontoSysModelo.Ciudad;
import OdontoSysModelo.Doctor;
import OdontoSysUtil.NewHibernateUtil;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class CiudadControlador {
 
     public static ArrayList<Ciudad> ListarCiudades(){
        Session sesion;
        Transaction tr = null;
        ArrayList<Ciudad> ciudades = null;
        Ciudad c ;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Ciudad ORDER BY nombre ASC";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                ciudades = new ArrayList();
                do{
                    c = (Ciudad) it.next();
                    ciudades.add(c);
                }while(it.hasNext());
            }
                        
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Ciudad Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        
        return ciudades;
    }
     
     
}
