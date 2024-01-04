package com.uchenna.LibraryMangement.model;

import jakarta.persistence.*;

@Entity
public class BorrowedBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToOne()
    @JoinColumn(name = "book_id")
    private Books books;

    public BorrowedBooks(){

    }

    public BorrowedBooks(Books book, Users user) {
        this.users = user;
        this.books = book;
        this.title = book.getTitle();
        this.author = book.getAuthor();

    }



    public Long getId() {
        return id;
    }

    public Users setId(Long id) {
        this.id = id;
        return null;
    }

    public Books hasBeenBorrow( Books books){
        if(books.isBorrowed()){
            books.setBorrowed(true);
        }
        return books;

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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BorrowedBooks{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", users=" + users +
                ", books=" + books +
                '}';
    }
}
