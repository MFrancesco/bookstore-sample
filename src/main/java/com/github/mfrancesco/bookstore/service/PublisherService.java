package com.github.mfrancesco.bookstore.service;

import com.github.mfrancesco.bookstore.models.db.Publisher;
import com.github.mfrancesco.bookstore.models.dto.PublisherCreateDTO;
import com.github.mfrancesco.bookstore.models.dto.PublisherDTO;
import com.github.mfrancesco.bookstore.models.dto.RankedAuthorDTO;
import com.github.mfrancesco.bookstore.repository.PublisherRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

  private final PublisherRepository publisherRepository;

  @Autowired
  public PublisherService(PublisherRepository publisherRepository) {
    this.publisherRepository = publisherRepository;
  }

  public Publisher createPublisher(PublisherCreateDTO publisherCreateDTO) {
    return this.publisherRepository.save(new Publisher(publisherCreateDTO.name,publisherCreateDTO.address.orElse("")));
  }

  public List<PublisherDTO> getAllPublishers() {
    return this.publisherRepository.findAll().stream().map(PublisherDTO::FromPublisher).toList();
  }
}
