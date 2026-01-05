package com.secondproj;

import jakarta.persistence.*;

@Entity
@Table(name = "biopic")
public class Biopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int biopicNumber;

    private String biopicName;

    @OneToOne
    @JoinColumn(name = "bookId")
    private Author author;

    protected Biopic() {}

    public Biopic(String name) {
        biopicName = name;
    }

    public int getBiopicNumber() {
        return biopicNumber;
    }

    public void setBiopicNumber(int biopicNumber) {
        this.biopicNumber = biopicNumber;
    }

    public String getBiopicName() {
        return biopicName;
    }

    public void setBiopicName(String biopicName) {
        this.biopicName = biopicName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
