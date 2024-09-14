package com.github.mfrancesco.bookstore.controller;
import com.github.mfrancesco.bookstore.models.db.Book;
import com.github.mfrancesco.bookstore.models.dto.BookCreateDTO;
import com.github.mfrancesco.bookstore.models.dto.BookDTO;
import com.github.mfrancesco.bookstore.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public ResponseEntity<List<BookDTO>> getAllBooks() {
    return ResponseEntity.ok(bookService.getAllBooks());
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
    return ResponseEntity.ok(bookService.getBookById(id));
  }

  @PostMapping
  public ResponseEntity<Book> createBook(@RequestBody @Valid BookCreateDTO book) {
    return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
    return ResponseEntity.ok().build();
  }

  @Valid
  @GetMapping("/low-stocked")
  public ResponseEntity<List<BookDTO>> getBooksWithLowStock(@RequestParam("threshold")
  @Min(value = 1, message = "Threshold must be greater than 0")
  @Max(value = Integer.MAX_VALUE, message = "Threshold must be less or equal than "+Integer.MAX_VALUE) int stock) {
    return ResponseEntity.ok(bookService.findBookWithQuantityStockLessThanThreshold(stock));
  }

}