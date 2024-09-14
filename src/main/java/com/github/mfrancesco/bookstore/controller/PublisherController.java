package com.github.mfrancesco.bookstore.controller;

import com.github.mfrancesco.bookstore.models.db.Publisher;
import com.github.mfrancesco.bookstore.models.dto.PublisherCreateDTO;
import com.github.mfrancesco.bookstore.service.PublisherService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController {

  private final PublisherService publisherService;

  @Autowired
  public PublisherController(PublisherService publisherService) {
    this.publisherService = publisherService;
  }

  @PostMapping
  public ResponseEntity<Publisher> createPublisher(@Valid @RequestBody PublisherCreateDTO publisherCreateDTO) {
    Publisher createdPublisher = publisherService.createPublisher(publisherCreateDTO);
    return new ResponseEntity<>(createdPublisher, HttpStatus.CREATED);
  }
}