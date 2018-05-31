package library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import library.dao.ILibrary;
import library.dto.*;
@SpringBootApplication
	@ComponentScan(basePackages="library.dao")
	@EnableJpaRepositories("library.repo")
	@EntityScan("library.entities")
	@RestController
public class LibraryRestController {
	@Autowired
	ILibrary library;
	
	@PostMapping(value=LibraryApiConstant.ADD_BOOK)
	LibraryReturnCode addBook(@RequestBody BookDto book) {
		return library.addBook(book);
	}
		
	@PostMapping(value = LibraryApiConstant.ADD_AUTHOR)
	LibraryReturnCode addAuthor (@RequestBody AuthorDto author) {
		return library.addAuthor(author);
	}
	
	@PostMapping(value = LibraryApiConstant.ADD_READER)
	LibraryReturnCode addReader(@RequestBody ReaderDto reader) {
		return library.addReader(reader);
	}
	@PostMapping(value = LibraryApiConstant.PICK_BOOK)
	LibraryReturnCode pickBook(@RequestBody PickBookData data) {
		return library.pickBook(data);
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryRestController.class, args);
	}
}
