package library.entities;

import java.util.*;

import javax.persistence.*;

import library.dto.AuthorDto;

@Table(name = "authors")
@Entity
public class Author {
	@Id
	String name;
	String country;
	@ManyToMany (mappedBy="authors")
	List <Book> books;
	
	public Author(String name, String country, List<Book> books) {
		this.name = name;
		this.country = country;
		this.books = books;
	}
	public Author() {
	}
	
	public Author(String name, String country) {
		this.name = name;
		this.country = country;
	}

	public Author(AuthorDto authorDto) {
		name = authorDto.name;
		country = authorDto.country;
	}
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}
	public AuthorDto getAuthor() {
		return new AuthorDto(name, country);
	}



}
