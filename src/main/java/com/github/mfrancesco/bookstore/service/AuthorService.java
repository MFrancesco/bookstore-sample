package com.github.mfrancesco.bookstore.service;

import com.github.mfrancesco.bookstore.models.db.Author;
import com.github.mfrancesco.bookstore.models.dto.AuthorCreateDTO;
import com.github.mfrancesco.bookstore.models.dto.RankedAuthorDTO;
import com.github.mfrancesco.bookstore.repository.AuthorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

  private final AuthorRepository authorRepository;

  @Autowired
  public AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author createAuthor(AuthorCreateDTO authorCreateDTO) {
    return authorRepository.save(new Author(authorCreateDTO.name, authorCreateDTO.biography.orElse("")));
  }

  public List<RankedAuthorDTO> getTopNRankedAuthor(Long n){
    return authorRepository.findTopNsellingAuthor(n).stream().map(
        RankedAuthorDTO::fromInterface).toList();
  }
}
