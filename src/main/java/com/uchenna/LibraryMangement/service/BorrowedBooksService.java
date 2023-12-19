package com.uchenna.LibraryMangement.service;

import com.uchenna.LibraryMangement.model.Books;
import com.uchenna.LibraryMangement.model.BorrowedBooks;
import com.uchenna.LibraryMangement.model.Users;
import com.uchenna.LibraryMangement.repository.BorrowedBooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBooksService {

    private BorrowedBooksRepository borrowedBooksRepository;

    public BorrowedBooksService(BorrowedBooksRepository borrowedBooksRepository){
        this.borrowedBooksRepository = borrowedBooksRepository;
    }

    /*public BorrowedBooks addBorrowedBooks(Long bookId, Long user ) {

        BorrowedBooks borrowedBook = new BorrowedBooks();
        borrowedBook.set
        return borrowedBooksRepository.save(borrowedBook);
    }*/
}
