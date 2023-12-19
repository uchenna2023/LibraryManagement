package com.uchenna.LibraryMangement.repository;

import com.uchenna.LibraryMangement.model.BorrowedBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BorrowedBooksRepository extends JpaRepository<BorrowedBooks, Long> {

    public List<BorrowedBooks> findByTitle(String books);
    public BorrowedBooks findByAuthor(String author);
}
