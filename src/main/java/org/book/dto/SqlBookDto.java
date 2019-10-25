package org.book.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"title", "author", "publishedDate", "isbn", "reviews"})
public class SqlBookDto {
	@JsonProperty
	private String title;

	@JsonProperty
	private String author;

	@JsonProperty
	private Date publishedDate;

	@JsonProperty
	private String isbn;

	@JsonProperty
	private List<BookReviewDto> reviews = null;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<BookReviewDto> getReviews() {
		return reviews;
	}

	public void setReviews(List<BookReviewDto> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "SqlBook [title=" + title + ", author=" + author
				+ ", publishedDate=" + publishedDate + ", isbn=" + isbn
				+ ", reviews=" + reviews + "]";
	}
}
