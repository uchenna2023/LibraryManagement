package com.uchenna.LibraryMangement.repository;

import com.uchenna.LibraryMangement.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    public List<Books> findByTitle(String title);
    public Books findByAuthor(String author);
    public Books findByIsbn(String isbn);
    public List<Books> findByYear(String year);
    @Query("SELECT b from Books b WHERE CONCAT(b.title, b.author, b.isbn) LIKE %?1%")
    public List<Books> search(String searchWord);
}
