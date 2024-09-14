package com.github.mfrancesco.bookstore;

import com.github.mfrancesco.bookstore.models.db.Book;
import com.github.mfrancesco.bookstore.models.dto.RankedAuthorDTO;
import com.github.mfrancesco.bookstore.repository.AuthorRepository;
import com.github.mfrancesco.bookstore.repository.BookRepository;
import com.github.mfrancesco.bookstore.service.AuthorService;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Testing only the bits of the business logic that are worth to be tested
 * Consider adding complete E2E tests on the endpoint covering different usecases
 */
@SpringBootTest
@ActiveProfiles("test")
class FrancescoApplicationTests {


	@Autowired
	public BookRepository bookRepository;

	@Autowired
	public AuthorRepository authorRepository;

	@Autowired
	public AuthorService authorService;
	@Test
	void testDataHasBeenLoaded() {
		Assertions.assertEquals(20,bookRepository.count(), "The test data has not been loaded correctly from flyway");
	}

	@Test
	public void testBookRepo(){
		var threshold = 5;
		//No book has in stock 0 copy here
		Assertions.assertEquals(0,bookRepository.findBookWithQuantityStockLessThanThreshold(1).size());
		var lessThanFive = bookRepository.findBookWithQuantityStockLessThanThreshold(threshold);
		Assertions.assertEquals(4, lessThanFive.size());
		lessThanFive.forEach(book -> Assertions.assertTrue(book.getQuantityInStock() < threshold));
	}


	@Test
	public void testAuthorService(){
		final var allBooks = bookRepository.findAll();
		IntStream.range(1,10).forEach(topN -> {
			var topNsellingAuthor = authorService.getTopNRankedAuthor((long) topN);
			Assertions.assertTrue(IntStream.range(0, topNsellingAuthor.size() - 1)
					.allMatch(i -> topNsellingAuthor.get(i).getBookSold() >= topNsellingAuthor.get(i + 1).getBookSold()), "The list is not ordered");
			topNsellingAuthor.forEach(rankedAuthorDTO -> checkAreOkCalculus(allBooks,rankedAuthorDTO));
		});
		//Test that even the authors with 0 books are added
		var authorCount = authorRepository.count();
		Assertions.assertEquals(authorCount,authorService.getTopNRankedAuthor(authorCount).size());
	}

	private void checkAreOkCalculus(List<Book> allBookInDb, RankedAuthorDTO rankedAuthorDTO){
			final var booksCountByAuthor = allBookInDb.stream().filter(book -> book.getAuthor().getId().equals(rankedAuthorDTO.getId())).mapToLong(Book::getQuantitySold).sum();
			Assertions.assertEquals(booksCountByAuthor, rankedAuthorDTO.getBookSold(), "The calculations are wrong");
	}

}
