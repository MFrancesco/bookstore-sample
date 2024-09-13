package com.github.mfrancesco.bookstore.models.dto;

import jakarta.validation.constraints.*;

public class BookCreateDTO {


  @NotBlank(message = "Title is mandatory")
  @Size(max = 255, message = "Title length must not exceed 255 characters")
  public String title;

  @NotBlank(message = "ISBN is mandatory")
  public String isbn;

  @NotNull(message = "Price is mandatory")
  @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
  public float price;

  @NotNull(message = "Quantity in stock is mandatory")
  @Min(value = 0, message = "Quantity in stock must be 0 or greater")
  public Integer quantityInStock;

  @NotNull(message = "Quantity sold is mandatory")
  @Min(value = 0, message = "Quantity sold must be 0 or greater")
  public Integer quantitySold;

  @NotNull(message = "Author ID is mandatory")
  @Positive(message = "Author ID must be a positive number")
  public Long authorId;

  @NotNull(message = "Publisher ID is mandatory")
  @Positive(message = "Publisher ID must be a positive number")
  public Long publisherId;
}