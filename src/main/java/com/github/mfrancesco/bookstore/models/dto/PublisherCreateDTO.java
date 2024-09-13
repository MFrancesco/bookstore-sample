package com.github.mfrancesco.bookstore.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PublisherCreateDTO {

  @NotBlank(message = "Publisher name is mandatory")
  @Size(max = 255, message = "Publisher name must not exceed 255 characters")
  public String name;

  @Size(max = 1000, message = "Address must not exceed 1000 characters")
  public String address;

}