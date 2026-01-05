package com.secondproj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Configuration con  = new Configuration()
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Biopic.class)
                .configure("secondproj.cfg.xml");


        SessionFactory sf = con.buildSessionFactory();

       Session ssn =  sf.openSession();

       Transaction tx = ssn.beginTransaction();

       Author a = new Author("Paavan");
       Book b = new Book("Diary");
       Biopic p = new Biopic("MyLife");

       ssn.persist(a);

       a.addBook(b);
       a.setBiopic(p);

       tx.commit();
       ssn.close();
        sf.close();
    }
}
