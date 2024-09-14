package com.github.mfrancesco.bookstore.repository;

import com.github.mfrancesco.bookstore.models.db.Author;
import com.github.mfrancesco.bookstore.models.dto.RankedAuthorDTO.Interface;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Long> {
  @Query(value = """
      SELECT
          a.id AS id,
          a.name AS name,
          COALESCE(SUM(b.quantity_sold),0) AS book_sold
      FROM
          Author a
      LEFT JOIN
          Book b ON a.id = b.author_id
      GROUP BY
          a.id, a.name
      ORDER BY
          book_sold DESC
      LIMIT ?1
      """, nativeQuery = true)
  List<Interface> findTopNsellingAuthor(Long n);

}