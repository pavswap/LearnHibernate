package com.secondproj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        Configuration config = new Configuration()
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Shelf.class)
                .configure("secondproj.cfg.xml");

        SessionFactory fac = config.buildSessionFactory();

        Session ssn1 = fac.openSession();

        Transaction tx = ssn1.beginTransaction();

        Book book = new Book("PavSwap's Diary");
        Author author = new Author("Paavan");
        Shelf shelf = new Shelf(13);

        author.addBook(book);
        shelf.setBook(book);

        ssn1.persist(book);
        ssn1.persist(author);
        ssn1.persist(shelf);

        tx.commit();
        ssn1.close();
        fac.close();
    }
}
