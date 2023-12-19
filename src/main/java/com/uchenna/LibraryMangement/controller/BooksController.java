package com.uchenna.LibraryMangement.controller;

import com.uchenna.LibraryMangement.globalExceptionHandler.BookNotFoundException;
import com.uchenna.LibraryMangement.globalExceptionHandler.UserNotFoundException;
import com.uchenna.LibraryMangement.model.Books;
import com.uchenna.LibraryMangement.model.BorrowedBooks;
import com.uchenna.LibraryMangement.repository.BooksRepository;
import com.uchenna.LibraryMangement.service.BooksService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class BooksController {

    private BooksService booksService;

    public BooksController(BooksService bookService){
        this.booksService = bookService;
    }
    @PostMapping("/book")
    public ResponseEntity<String> addMyBook(@RequestBody Books books){
        return new ResponseEntity<>(booksService.addBook(books), HttpStatus.CREATED);
    }

    @PostMapping("/{userId}/borrow/{bookId}")
    public ResponseEntity<BorrowedBooks> borrowBooks(@PathVariable Long userId, @PathVariable Long bookId) throws BookNotFoundException, UserNotFoundException {
        return new ResponseEntity<>(booksService.borrowBook(userId, bookId), HttpStatus.OK);

    }

    @DeleteMapping("/book/{id}")
    public String deleteBookById(@PathVariable Long id){
        booksService.deleteBook(id);
        return "Book Deleted";
    }

    @GetMapping("/")
    public ResponseEntity<List<Books>> searchBook(@Param("word") String word){
        return new ResponseEntity<>(booksService.searchByKeyword(word),HttpStatus.OK);
    }

    @DeleteMapping("/book/{isbn}")
    public ResponseEntity<String>  deleteByIsbn(String isbn){

        return new ResponseEntity<>(booksService.deleteByIsbn(isbn),HttpStatus.OK);
    }
}
