package com.paavan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // 1. Create entity object
        Data d = new Data(1, "Paavan");

        // 2. Load Hibernate config
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml"); // loads hibernate.hibernate.cfg.xml
        config.addAnnotatedClass(Data.class);

        // 3. Build SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();

        // 4. Open Session
        Session session = sessionFactory.openSession();

        // 5. Begin transaction
        Transaction tx = session.beginTransaction();

        // 6. Save object
        session.persist(d);

        // 7. Commit transaction
        tx.commit();

        // 8. Close resources
        session.close();
        sessionFactory.close();

        System.out.println("Data saved successfully!");
    }
}
