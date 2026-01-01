package com.paavan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration cfg = new Configuration()
                            .addAnnotatedClass(Question.class)
                            .configure("hibernate.cfg.xml");

        SessionFactory fac = cfg.buildSessionFactory();

        Session ssn = fac.openSession();

        Transaction tx = ssn.beginTransaction();

        Question q = new Question("What is Air?");
        Answer a = new Answer("Air is a mixture of gasses");

        q.setAnswer(a);

        ssn.persist(q);

        tx.commit();
        ssn.close();
        fac.close();
    }
}
