package com.github.mfrancesco.bookstore.controller;

import com.github.mfrancesco.bookstore.models.db.Author;
import com.github.mfrancesco.bookstore.models.dto.AuthorCreateDTO;
import com.github.mfrancesco.bookstore.models.dto.AuthorDTO;
import com.github.mfrancesco.bookstore.models.dto.RankedAuthorDTO;
import com.github.mfrancesco.bookstore.service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

  private final AuthorService authorService;

  @Autowired
  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @PostMapping
  public ResponseEntity<AuthorDTO> createAuthor(@Validated @RequestBody AuthorCreateDTO authorCreateDTO) {
    return new ResponseEntity<>(authorService.createAuthor(authorCreateDTO), HttpStatus.CREATED);
  }

  @Valid
  @GetMapping("/top")
  public ResponseEntity<List<RankedAuthorDTO>> getTopNAuthors(@RequestParam("limit")
  @Min(value = 1, message = "Limit must be greater than 0")
  @Max(value = 1000, message = "Limit must be less or equal than 1000")  long limit) {
    return ResponseEntity.ok(authorService.getTopNRankedAuthor(limit));
  }
}