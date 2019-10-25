package org.book.controller;

import org.book.dto.SqlBookDto;
import org.book.service.SqlBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/sqlbook")
public class SqlController {
	@Autowired
	private SqlBookService sqlBookService;

	@GetMapping(path = "/findByTitle")
	public @ResponseBody SqlBookDto findByTitle(@RequestParam String title) {
		return sqlBookService.findByTitle(title);
	}
}
