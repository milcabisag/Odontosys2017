/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.context.ThreadLocalSessionContext;
import org.hibernate.service.ServiceRegistryBuilder;
 
/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author user
 */
public class NewHibernateUtil {

   /* private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            
            sessionFactory = new Configuration().configure().buildSessionFactory();
            
            //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            //sessionFactory = new Configuration().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            //sessionFactory = null;
            System.err.println("SessionFactory inicial ha fallado - " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }7+
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }*/

        private static SessionFactory sessionFactory;
        
        public static synchronized void buildSessionFactory() {
            
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();
                configuration.configure();
                configuration.setProperty("hibernate.current_session_context_class", "thread");
                ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings
                                    (configuration.getProperties()).buildServiceRegistry();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
               /* StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
                serviceRegistryBuilder.applySettings(configuration.getProperties());	
                ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);*/
            }
            
        }

        public static void openSession() {
            sessionFactory.openSession();
        }
        
        public static SessionFactory getSessionFactory() {
            if (sessionFactory==null)  {
                buildSessionFactory();
            }
            return sessionFactory;
        }
        
        public static void closeSessionFactory() {
            if ((sessionFactory!=null) && (sessionFactory.isClosed()==false)) {
                sessionFactory.close();
            }
        }
    
    
}
