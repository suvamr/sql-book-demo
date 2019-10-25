package org.book.service.impl;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.book.dto.BookReviewDto;
import org.book.dto.SqlBookDto;
import org.book.entity.BookReview;
import org.book.entity.SqlBook;
import org.book.repository.SqlBookRepository;
import org.book.service.SqlBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SqlBookServiceImpl implements SqlBookService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SqlBookServiceImpl.class);

	@Value("${sql.fileName}")
	private String jsonFileName;

	@Autowired
	private SqlBookRepository sqlBookRepository;

	@PostConstruct
	private void parseJsonAndInsertDatabase() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			List<SqlBookDto> sqlDto = objectMapper.readValue(
					new FileInputStream(
							new ClassPathResource(jsonFileName).getFile()),
					new TypeReference<List<SqlBookDto>>() {
					});

			for (SqlBookDto book : sqlDto) {
				SqlBook sqlBook = new SqlBook();

				sqlBook.setTitle(book.getTitle());
				sqlBook.setAuthor(book.getAuthor());
				sqlBook.setPublishedDate(book.getPublishedDate());
				sqlBook.setIsbn(book.getIsbn());
				List<BookReview> bookReviews = new ArrayList<>();

				for (BookReviewDto review : book.getReviews()) {
					BookReview bookReview = new BookReview();

					bookReview.setReviewerName(review.getReviewerName());
					bookReview.setContent(review.getContent());
					bookReview.setRating(review.getRating());
					bookReview.setPublishedDate(review.getPublishedDate());

					bookReviews.add(bookReview);
				}
				sqlBook.setBookReview(bookReviews);
				sqlBookRepository.saveAndFlush(sqlBook);
			}
		} catch (Exception e) {
			LOGGER.error("Error occurred while parsing and inserting json details into database", e);
		}
	}

	@Override
	public SqlBookDto findByTitle(String title) {
		SqlBook book = sqlBookRepository.findByTitle(title);
		SqlBookDto sqlBook = new SqlBookDto();

		if (Objects.isNull(book)) {
			return sqlBook;
		}

		sqlBook.setTitle(book.getTitle());
		sqlBook.setAuthor(book.getAuthor());
		sqlBook.setPublishedDate(book.getPublishedDate());
		sqlBook.setIsbn(book.getIsbn());
		List<BookReviewDto> bookReviews = new ArrayList<>();

		for (BookReview review : book.getBookReview()) {
			BookReviewDto bookReview = new BookReviewDto();

			bookReview.setReviewerName(review.getReviewerName());
			bookReview.setContent(review.getContent());
			bookReview.setRating(review.getRating());
			bookReview.setPublishedDate(review.getPublishedDate());

			bookReviews.add(bookReview);
		}
		sqlBook.setReviews(bookReviews);

		return sqlBook;
	}
}
