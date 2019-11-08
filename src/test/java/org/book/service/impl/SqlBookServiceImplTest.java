package org.book.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.book.entity.BookReview;
import org.book.entity.SqlBook;
import org.book.repository.SqlBookRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.management.*"})
@PrepareForTest({SqlBookServiceImpl.class})
public class SqlBookServiceImplTest {
	@Mock
	private SqlBookRepository sqlBookRepository;

	@InjectMocks
	private SqlBookServiceImpl sqlBookService;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testFindByTitle() {
		String title = "xyz";
		SqlBook book = new SqlBook();
		List<BookReview> bookReview = new ArrayList<>();

		book.setBookReview(bookReview);

		Mockito.when(sqlBookRepository.findByTitle(title)).thenReturn(book);
		sqlBookService.findByTitle(title);
	}
}
