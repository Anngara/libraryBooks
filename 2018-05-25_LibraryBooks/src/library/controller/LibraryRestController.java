package library.controller;

import java.util.List;

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
	
	@GetMapping(value = LibraryApiConstant.GET_AUTHOR)
	AuthorDto getAuthor (String name) {
		return library.getAuthor(name);
	}
	
	@GetMapping (value = LibraryApiConstant.GET_ALL_AUTHORS)
	List <AuthorDto> getAllAuthors (){
		return library.getAllAuthors();
	}
	
	@PostMapping (value = LibraryApiConstant.RETURN_BOOK)
	LibraryReturnCode  returnBook (@RequestBody ReturnBookData data) {
		return library.returnBook(data);
	}
	
	@GetMapping (value = LibraryApiConstant.GET_READERS_DELAYING_BOOK)
	List <ReaderDto>  getReadersDelayingBooks(){
		return library.getReadersDelayingBooks();
	}
	
	@GetMapping (value = LibraryApiConstant.GET_BOOK_AUTHORS)
	List <AuthorDto>  getBookAuthors(long isbn){
		return library.getBookAuthors(isbn);
	}
	
	@GetMapping (value = LibraryApiConstant.GET_AUTHOR_BOOKS)
	List <BookDto>  getAuthorBooks (String  authorName){ 
		return library.getAuthorBooks(authorName);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(LibraryRestController.class, args);
	}
}
