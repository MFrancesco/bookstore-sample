package com.github.mfrancesco.bookstore.models.dto;

import com.github.mfrancesco.bookstore.models.db.Book;

public record BookDTO(Long id, String title, String isbn, Float price, int quantityInStock, int quantitySold) {

  public static BookDTO FromBook(Book b){
    return new BookDTO(b.getId(),b.getTitle(),b.getIsbn(),b.getPrice(),b.getQuantityInStock(),b.getQuantitySold());
  }
}
