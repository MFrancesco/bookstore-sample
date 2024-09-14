package com.github.mfrancesco.bookstore.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Optional;

public class PublisherCreateDTO {

  @NotBlank(message = "Publisher name is mandatory")
  @Size(max = 255, message = "Publisher name must not exceed 255 characters")
  public String name;

  public Optional<@NotBlank @Size(min=1, max = 1000, message = "Address must not exceed 1000 characters")String> address;

}