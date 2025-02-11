package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    static {
        Configuration configuration = new Configuration().configure();

        if (sessionFactory == null) {
            sessionFactory = configuration.buildSessionFactory();
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
