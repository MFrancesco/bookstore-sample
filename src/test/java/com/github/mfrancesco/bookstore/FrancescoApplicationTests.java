package com.github.mfrancesco.bookstore;

import com.github.mfrancesco.bookstore.models.db.Book;
import com.github.mfrancesco.bookstore.models.dto.RankedAuthorDTO;
import com.github.mfrancesco.bookstore.repository.AuthorRepository;
import com.github.mfrancesco.bookstore.repository.BookRepository;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class FrancescoApplicationTests {


	@Autowired
	public BookRepository bookRepository;

	@Autowired
	public AuthorRepository authorRepository;

	@Test
	void testDataHasBeenLoaded() {
		Assertions.assertEquals(20,bookRepository.count(), "The test data has not been loaded correctly from flyway");
	}

	@Test
	public void testBookRepo(){
		var threshold = 5;
		bookRepository.findBookWithQuantitySoldLessThanThreshold(threshold)
				.forEach(book -> Assertions.assertTrue(book.getQuantityInStock() < threshold));
	}


	@Test
	public void testAuthorRepo(){
		final var allBooks = bookRepository.findAll();
		IntStream.range(1,10).forEach(topN -> {
			var topNsellingAuthor = authorRepository.findTopNsellingAuthor((long) topN).stream().map(
					RankedAuthorDTO::fromInterface).toList();
			Assertions.assertTrue(IntStream.range(0, topNsellingAuthor.size() - 1)
					.allMatch(i -> topNsellingAuthor.get(i).getBookSold() >= topNsellingAuthor.get(i + 1).getBookSold()), "The list is not ordered");
			topNsellingAuthor.forEach(rankedAuthorDTO -> checkAreOkCalculus(allBooks,rankedAuthorDTO));
		});
	}

	private void checkAreOkCalculus(List<Book> allBookInDb, RankedAuthorDTO rankedAuthorDTO){
			final var booksCountByAuthor = allBookInDb.stream().filter(book -> book.getAuthor().getId().equals(rankedAuthorDTO.getId())).mapToLong(Book::getQuantitySold).sum();
			Assertions.assertEquals(booksCountByAuthor, rankedAuthorDTO.getBookSold(), "The calculations are wrong");
	}

}
