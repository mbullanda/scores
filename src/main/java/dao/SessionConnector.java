package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionConnector {

    public static SessionFactory createFactory (Class<?>... classes){

        Configuration configure = new Configuration()
                .configure();
        for (Class<?> aClass : classes){
            configure.addAnnotatedClass(aClass);
        }
        return configure.buildSessionFactory();
    }
}
