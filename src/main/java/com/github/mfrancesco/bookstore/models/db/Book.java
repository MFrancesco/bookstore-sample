package com.github.mfrancesco.bookstore.models.db;

import jakarta.persistence.*;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false, unique = true)
  private String isbn;

  @Column(nullable = false)
  private Float price;

  @Column(nullable = false)
  private int quantityInStock;

  @Column(nullable = false)
  private int quantitySold;

  @ManyToOne(optional = false)
  @JoinColumn(name = "author_id", nullable = false)
  private Author author;

  @ManyToOne(optional = false)
  @JoinColumn(name = "publisher_id", nullable = false)
  private Publisher publisher;

  public Book() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public int getQuantityInStock() {
    return quantityInStock;
  }

  public void setQuantityInStock(int quantityInStock) {
    this.quantityInStock = quantityInStock;
  }

  public int getQuantitySold() {
    return quantitySold;
  }

  public void setQuantitySold(int quantitySold) {
    this.quantitySold = quantitySold;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }
}