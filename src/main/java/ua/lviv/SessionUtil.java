package ua.lviv;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {

    public static Session getSession(){
        Configuration configuration = new Configuration();
        // method use default configuration, path - src\main\resources\hibernate.cfg.xml
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory.openSession();
    }

}
