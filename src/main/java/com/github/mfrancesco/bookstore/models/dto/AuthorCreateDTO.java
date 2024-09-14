package com.github.mfrancesco.bookstore.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Optional;

public class AuthorCreateDTO {

  @NotBlank(message = "Author name is mandatory")
  @Size(max = 255, message = "Author name must not exceed 255 characters")
  public String name;

  public Optional<@NotBlank @Size(min=1, max = 5000, message = "Biography cannot exceed 5000 characters") String> biography;

  // Getters and Setters
}