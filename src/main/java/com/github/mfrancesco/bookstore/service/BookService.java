package com.github.mfrancesco.bookstore.service;

import com.github.mfrancesco.bookstore.models.db.Author;
import com.github.mfrancesco.bookstore.models.db.Book;
import com.github.mfrancesco.bookstore.models.db.Publisher;
import com.github.mfrancesco.bookstore.models.dto.BookCreateDTO;
import com.github.mfrancesco.bookstore.repository.AuthorRepository;
import com.github.mfrancesco.bookstore.repository.BookRepository;
import com.github.mfrancesco.bookstore.repository.PublisherRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookService {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  private final PublisherRepository publisherRepository;

  @Autowired
  public BookService(BookRepository bookRepository, AuthorRepository authorRepository,
      PublisherRepository publisherRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
    this.publisherRepository = publisherRepository;
  }
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public Book getBookById(Long id) {
    return bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
  }

  public Book createBook(BookCreateDTO dto) {
    // Check if the author exists
    Author author = authorRepository.findById(dto.authorId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author not found"));

    // Check if the publisher exists
    Publisher publisher = publisherRepository.findById(dto.publisherId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Publisher not found"));

    // Create the book entity
    Book book = new Book();
    book.setTitle(dto.title);
    book.setIsbn(dto.isbn);
    book.setPrice(dto.price);
    book.setQuantityInStock(dto.quantityInStock);
    book.setQuantitySold(dto.quantitySold);
    book.setAuthor(author);
    book.setPublisher(publisher);

    // Save the book and return
    return bookRepository.save(book);
  }

  public List<Book> findBookWithQuantityStockLessThanThreshold(int threshold){
    return bookRepository.findBookWithQuantityStockLessThanThreshold(threshold);
  }

  public void deleteBook(Long id) {
    bookRepository.deleteById(id);
  }
}
