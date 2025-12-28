package com.paavan;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUDUtility {

    static SessionFactory fac;

    SessionFactory getFactory() {

        try {
            Configuration config = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Data.class);

            fac = config.buildSessionFactory();

            return fac;
        } catch (Exception e) {

            e.printStackTrace();
            throw e;
        }
    }

    void closeSessionFactory() {
        fac.close();
    }
}
