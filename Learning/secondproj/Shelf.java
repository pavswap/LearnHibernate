package com.secondproj;

import jakarta.persistence.*;

@Entity
@Table(name = "shelf")
public class Shelf {

    @Id
    private int shelf_number;

    @OneToOne(mappedBy = "shelf", cascade = CascadeType.ALL)
    private Book book;

    Shelf() {}

    Shelf(int number) {shelf_number = number;}

    //Getters and Setters

    public int getShelfNumber() {return shelf_number;}

    public void setShelfNumber(int shelf_number) {this.shelf_number = shelf_number;}

    public Book getBook() {return book;}

    public void setBook(Book book) {
        this.book = book;
        book.setShelf(this);
    }
}
