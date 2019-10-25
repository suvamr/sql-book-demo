package org.book.service;

import org.book.dto.SqlBookDto;

public interface SqlBookService {
	SqlBookDto findByTitle(String title);
}
