package com.paavan;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUDUtility {

    static SessionFactory fac;

    static {
        try {
            Configuration config = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Data.class);

            fac = config.buildSessionFactory();
        } catch (Exception e) {

            e.printStackTrace();
            throw e;
        }
    }

    static SessionFactory getSessionFactory() {
        return fac;
    }

    static void closeSessionFactory() {
        fac.close();
    }
}
