package com.uchenna.LibraryMangement.service;

import com.uchenna.LibraryMangement.globalExceptionHandler.BookNotFoundException;
import com.uchenna.LibraryMangement.globalExceptionHandler.UserNotFoundException;
import com.uchenna.LibraryMangement.model.Books;
import com.uchenna.LibraryMangement.model.BorrowedBooks;
import com.uchenna.LibraryMangement.model.Users;
import com.uchenna.LibraryMangement.repository.BooksRepository;
import com.uchenna.LibraryMangement.repository.BorrowedBooksRepository;
import com.uchenna.LibraryMangement.repository.UsersRepository;
import jakarta.persistence.PreRemove;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BooksService {

    private BooksRepository booksRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private  BorrowedBooksService borrowedBooksService;
    @Autowired
    private BorrowedBooksRepository borrowedBooksRepository;



    public BooksService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public List<Books> getAllBooks(){
        List<Books> books = booksRepository.findAll();
        return  books;
    }

    public String addBook( Books books){
        booksRepository.save(books);
        return "Book Created";
    }




    public void deleteBook(Long id){
        booksRepository.deleteById(id);
    }

    public Books getById(Long id) throws BookNotFoundException {
        return booksRepository.findById(id).orElseThrow(() -> new BookNotFoundException("book not found"));
    }


    public BorrowedBooks borrowBook(Long userId, Long bookId) throws BookNotFoundException, UserNotFoundException {
        Books bookToBeBorrowed = booksRepository.findById(bookId).orElseThrow(()-> new BookNotFoundException("book not found"));
        Users userToBeBorrowed = usersRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("user not found"));
        BorrowedBooks borrowed = new BorrowedBooks(bookToBeBorrowed, userToBeBorrowed);

        borrowed.setAuthor(borrowed.getAuthor());
        borrowed.setTitle(borrowed.getTitle());
        borrowed.setBooks(borrowed.getBooks());
        borrowed.setUsers(borrowed.getUsers());
        BorrowedBooks saveBorrowed = borrowedBooksRepository.save(borrowed);






        return saveBorrowed;



    }

    public List<Books> searchByKeyword(String string){
        if(string != null){
            return  booksRepository.search(string);
        }
        else {
            return booksRepository.findAll();
        }

    }

    public String deleteByIsbn(String bookIsbn){
        Books bookIsbnToDelete = booksRepository.findByIsbn(bookIsbn);
        booksRepository.deleteById(bookIsbnToDelete.getId());
        return "Deleted";

    }



}
