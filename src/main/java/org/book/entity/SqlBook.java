package org.book.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the sql_book database table.
 * 
 */
@Entity
@Table(name = "sql_book")
@NamedQuery(name = "SqlBook.findAll", query = "SELECT e FROM SqlBook e")
public class SqlBook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long bookId;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name = "published_date")
	private Date publishedDate;

	@Column(name = "isbn")
	private String isbn;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "sql_book_mapping", 
		joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "book_id")}, 
		inverseJoinColumns = {@JoinColumn(name = "review_id", referencedColumnName = "review_id")}
	)
	private List<BookReview> bookReview;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

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

	public List<BookReview> getBookReview() {
		return bookReview;
	}

	public void setBookReview(List<BookReview> bookReview) {
		this.bookReview = bookReview;
	}

	public void addTokenMeta(BookReview bookReview) {
		if (bookReview == null) {
			this.bookReview = new ArrayList<>();
		}
		this.bookReview.add(bookReview);
	}
}
