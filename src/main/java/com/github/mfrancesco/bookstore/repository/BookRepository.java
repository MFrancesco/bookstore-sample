package com.github.mfrancesco.bookstore.repository;

import com.github.mfrancesco.bookstore.models.db.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
  // Custom query methods can be added here, for example:

  List<Book> findByTitle(String title);

  List<Book> findByAuthor_Name(String authorName); // Search by author's name

  List<Book> findByPublisher_Name(String publisherName); // Search by publisher's name

  @Query("select b from Book b where b.quantityInStock < ?1")
  List<Book> findBookWithQuantitySoldLessThanThreshold(int threshold);

}