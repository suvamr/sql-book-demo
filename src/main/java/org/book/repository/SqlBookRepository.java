package org.book.repository;

import org.book.entity.SqlBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlBookRepository extends JpaRepository<SqlBook, Long> {
	public SqlBook findByTitle(String title);
}
