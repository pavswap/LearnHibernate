package com.secondproj;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;

    private String book_name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shelf_number")
    private Shelf shelf;

    Book() {}

    public Book(String name) { this.book_name  = name;}

    // Getters
    int getBookId() {return book_id;}

    String getBookName(){return book_name;}

    Author getAuthor() {return author;}

    Shelf getShelf() {return shelf;}

    // Setters
    void setBookId(int id) {book_id = id;}

    void setBookName(String name) {book_name = name;}

    void setAuthor(Author author) {this.author = author;}

    void setShelf(Shelf shelf) {this.shelf = shelf;}
}

