package com.github.mfrancesco.bookstore.repository;

import com.github.mfrancesco.bookstore.models.db.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
  // Add custom query methods if needed
  Publisher findByName(String name);

}