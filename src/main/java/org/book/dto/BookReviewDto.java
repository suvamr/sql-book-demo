package org.book.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"reviewerName", "content", "rating", "publishedDate"})
public class BookReviewDto {
	@JsonProperty
	private String reviewerName;

	@JsonProperty
	private String content;

	@JsonProperty
	private String rating;

	@JsonProperty
	private Date publishedDate;

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		return "BookReviewDto [reviewerName=" + reviewerName + ", content="
				+ content + ", rating=" + rating + ", publishedDate="
				+ publishedDate + "]";
	}
}
