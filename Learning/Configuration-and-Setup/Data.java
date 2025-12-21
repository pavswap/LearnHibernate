package com.paavan;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Data {

    @Id
    private int id;
    private String name;

    Data(int id, String name) {

        this.id = id;
        this.name = name;
    }

    Data() {
        this.name = "Default Name";
    }

    String getData() {return name;}
    void setData(String name) {this.name = name;}
}
