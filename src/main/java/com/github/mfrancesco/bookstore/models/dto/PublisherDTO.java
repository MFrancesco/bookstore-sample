package com.github.mfrancesco.bookstore.models.dto;

import com.github.mfrancesco.bookstore.models.db.Publisher;
import java.util.Optional;

public record PublisherDTO(Long id, String name, String address) {

  public static PublisherDTO FromPublisher(Publisher publisher) {
    return new PublisherDTO(publisher.getId(),publisher.getName(),publisher.getAddress());
  }
}
