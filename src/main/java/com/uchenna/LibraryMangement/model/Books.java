package com.uchenna.LibraryMangement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
public  class  Books {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Please enter a title")
    private String title;
    @NotNull(message = "please enter author name")
    @Length(min = 6, message = "please enter your author name")
    private String author;
    @NotNull(message = "please enter an ISBN number")
    //@ISBN()
    //@UniqueElements
    private String isbn;
    private String year;
    private boolean isBorrowed;
    @OneToOne(mappedBy = "books")
    private BorrowedBooks borrowedBook;



    public Books(){

    }

    public Books(String title, String author, String isbn, String year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.isBorrowed = false;
    }


    /*@PreRemove
    private void removeBookAssociation(){




        borrowedBook.getBooks().setTitle(null);
        borrowedBook.getBooks().setId(null);
        borrowedBook.getBooks().setYear(null);
        borrowedBook.getBooks().setIsbn(null);
        borrowedBook.getBooks().setAuthor(null);

        this.setId(null);
        this.setIsbn(null);
        this.setAuthor(null);
        this.setTitle(null);
        this.setYear(null);
        BorrowedBooks bb = null;
        Books book = null;
        if(bb != null){
           bb.setBooks(null);
        }
        if(book != null){
            book.setId(null);
            book.setAuthor(null);
            book.setIsbn(null);
            book.setYear(null);
            book.setTitle(null);
        }
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", year='" + year + '\'' +
                '}';
    }



}
