package com.paavan;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CRUDApplication {

    void createTable() {

        Session ssn = CRUDUtility.getSessionFactory().openSession();
        Transaction tx = ssn.beginTransaction();

        Data d = new Data();

        ssn.persist(d);

        tx.commit();
        ssn.close();
    }

    void insertRow(String name) {

        Session ssn = CRUDUtility.getSessionFactory().openSession();
        Transaction tx = ssn.beginTransaction();

        Data d = new Data(name);

        ssn.persist(d);

        tx.commit();
        ssn.close();
    }

    Data readRow(int id) {

        Session ssn = CRUDUtility.getSessionFactory().openSession();
        Transaction tx = ssn.beginTransaction();

        Data d = ssn.get(Data.class, id);

        tx.commit();
        ssn.close();

        return d;
    }

    void updateRow(int id, String name) {

        Session ssn = CRUDUtility.getSessionFactory().openSession();
        Transaction tx = ssn.beginTransaction();

        Data d = ssn.get(Data.class, id);
        d.setName(name);

        tx.commit();
        ssn.close();
    }

    void deleteRow(int id) {

        Session ssn = CRUDUtility.getSessionFactory().openSession();
        Transaction tx = ssn.beginTransaction();

        Data d = ssn.get(Data.class, id);

        ssn.remove(d);

        tx.commit();
        ssn.close();
    }
}
