package ua.lviv;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    private static Configuration getConfiguration(){
        if (configuration == null){
            configuration = new Configuration();
            // method use default configuration, path - src\main\resources\hibernate.cfg.xml
            configuration.configure();
        }
        return configuration;
    }

    private static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            sessionFactory = SessionUtil.getConfiguration().buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession(){
        return SessionUtil.getSessionFactory().openSession();
    }

}
