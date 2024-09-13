package com.github.mfrancesco.bookstore.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthorCreateDTO {

  @NotBlank(message = "Author name is mandatory")
  @Size(max = 255, message = "Author name must not exceed 255 characters")
  public String name;

  @Size(max = 5000, message = "Biography must not exceed 5000 characters")
  public String biography;

  // Getters and Setters
}