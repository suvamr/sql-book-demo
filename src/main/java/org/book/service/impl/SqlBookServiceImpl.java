package org.book.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.book.dto.BookReviewDto;
import org.book.dto.SqlBookDto;
import org.book.entity.BookReview;
import org.book.entity.SqlBook;
import org.book.repository.SqlBookRepository;
import org.book.service.SqlBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SqlBookServiceImpl implements SqlBookService {
	@Autowired
	private SqlBookRepository sqlBookRepository;

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
