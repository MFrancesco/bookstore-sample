package com.github.mfrancesco.bookstore.models.dto;

public class RankedAuthorDTO {

  private Long id;

  private String name;

  private Long bookSold;

  public RankedAuthorDTO() {
  }

  public RankedAuthorDTO(Long id, String name, Long bookSold) {
    this.id = id;
    this.name = name;
    this.bookSold = bookSold;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getBookSold() {
    return bookSold;
  }

  public void setBookSold(Long bookSold) {
    this.bookSold = bookSold;
  }

  public static RankedAuthorDTO fromInterface(Interface i){
    return new RankedAuthorDTO(i.getId(),i.getName(),i.getBookSold());
  }

  /**
   * Interface used to perform the tuple in the custom DTO using native query
   * Not the most efficient, but the fastest to code, use other methods for production code
   */
  public interface Interface{
    Long getId();
    String getName();
    Long getBookSold();
  }

}
