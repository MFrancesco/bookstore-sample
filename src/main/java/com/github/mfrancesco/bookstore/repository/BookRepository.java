package com.github.mfrancesco.bookstore.repository;

import com.github.mfrancesco.bookstore.models.db.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

  @Query("select b from Book b where b.quantityInStock < ?1 order by b.quantityInStock DESC")
  List<Book> findBookWithQuantityStockLessThanThreshold(int threshold);

}