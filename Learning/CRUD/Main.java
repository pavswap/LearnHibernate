package com.paavan;

public class Main {
    public static void main(String[] args) {

        CRUDApplication app = new CRUDApplication();

        app.createTable();

        app.insertRow("Revanth");

        System.out.println(app.readRow(3));

        app.updateRow(3, "Sumiran");

        System.out.println(app.readRow(1));

       app.deleteRow(5);

       CRUDUtility.closeSessionFactory();
    }
}
