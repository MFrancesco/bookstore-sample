package com.github.mfrancesco.bookstore.models.dto;

import com.github.mfrancesco.bookstore.models.db.Author;

public record AuthorDTO(Long id, String name, String biography) {

  public static AuthorDTO FromAuthor(Author a){
    return new AuthorDTO(a.getId(),a.getName(),a.getBiography());
  }

}
