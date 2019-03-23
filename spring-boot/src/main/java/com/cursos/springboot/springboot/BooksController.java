package com.cursos.springboot.springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	@GetMapping("/Books")
	public List<Book> getAllBooks(){
		return Arrays.asList(new Book[] {new Book(2l, "La vida de Fernando Alonso", "Antonio Lobato")});
	}
}
