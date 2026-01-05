package com.secondproj;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    private String authorName;

    @OneToMany(
            mappedBy = "author",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    @OneToOne(
            mappedBy = "author",
            cascade = CascadeType.ALL
    )
    private Biopic biopic;

    protected Author() {}

    public Author(String name) {
         authorName = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Biopic getBiopic() {
        return biopic;
    }

    public void setBiopic(Biopic biopic) {
        this.biopic = biopic;
    }
}
