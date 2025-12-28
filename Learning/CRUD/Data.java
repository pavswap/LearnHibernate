package com.paavan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student_Data")
public class Data {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name", length = 50)
    private String name;

    Data(String name) {

        this.name = name;
    }

    Data() {
        // Default Constructor
    }

    // Getters and Setters
    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    void setId(int id) {
        this.id = id;
    }

    // In Case Object is printed
    @Override
    public String toString() {
        return this.name;
    }
}
