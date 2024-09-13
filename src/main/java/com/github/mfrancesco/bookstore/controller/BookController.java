package com.github.mfrancesco.bookstore.controller;
import com.github.mfrancesco.bookstore.models.db.Book;
import com.github.mfrancesco.bookstore.models.dto.BookCreateDTO;
import com.github.mfrancesco.bookstore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping
  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  @GetMapping("/{id}")
  public Book getBookById(@PathVariable Long id) {
    return bookService.getBookById(id);
  }

  @PostMapping
  public Book createBook(@RequestBody @Valid BookCreateDTO book) {
    return bookService.createBook(book);
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
  }

  // More methods can be added as required
}