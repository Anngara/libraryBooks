package library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import library.dao.ILibrary;
import library.dto.*;
import library.dto.LibraryApiConstant;
@SpringBootApplication
	@ComponentScan(basePackages="library.dao")
	@EnableJpaRepositories("library.repo")
	@EntityScan("library.entities")
	@RestController
public class LibraryRestController {
	@Autowired
	ILibrary library;
	
	@PostMapping(value=LibraryApiConstant.ADD_BOOK)
	boolean addBook(@RequestBody BookDto book) {
		return library.addBook(book);
	}
		
	@PostMapping(value = LibraryApiConstant.ADD_AUTHOR)
	boolean addAuthor (@RequestBody AuthorDto author) {
		return library.addAuthor(author);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryRestController.class, args);
	}
}
