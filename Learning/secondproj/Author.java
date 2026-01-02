package com.secondproj;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int author_id;

    private String author_name;

    @OneToMany(mappedBy = "author",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    Author(){}

    Author(String name){
        author_name = name;
    }

    // Getters and Setters
    public int getAuthorId() {return author_id;}

    public void setAuthorId(int author_id) {this.author_id = author_id;}

    public String getAuthorName() {return author_name;}

    public void setAuthorName(String author_name) {this.author_name = author_name;}

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {books.remove(book);}
}
