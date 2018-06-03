package library.entities;

import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.*;

import library.dto.BookDto;
import library.dto.Cover;

@Table(name = "books")
@Entity
public class Book {
	@Id
	long isbn;
	int amount;
	int amountActual;
	String titel;
	@Enumerated (EnumType.STRING)
	Cover cover;
	int pickPeriod;
	@ManyToMany 
	List <Author> authors;
	@OneToMany
	List <Record> records;
	
	
	public Book(long isbn, int amount, String titel, Cover cover, int pickPeriod, List<Author> authors) {
		this.isbn = isbn;
		this.amount = amount;
		this.amountActual = amount;
		this.titel = titel;
		this.cover = cover;
		this.pickPeriod = pickPeriod;
		this.authors = authors;
	}
	
	public Book (BookDto bookDto, List <Author> authors) {
		this.isbn = bookDto.isbn;
		this.amount = bookDto.amount;
		this.amountActual = bookDto.amount;
		this.titel = bookDto.titel;
		this.cover = bookDto.cover;
		this.pickPeriod = bookDto.pickPeriod;
		this.authors = authors;
	}

	public Book() {
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPickPeriod() {
		return pickPeriod;
	}

	public void setPickPeriod(int pickPeriod) {
		this.pickPeriod = pickPeriod;
	}

	public long getIsbn() {
		return isbn;
	}

	public String getTitel() {
		return titel;
	}

	public Cover getCover() {
		return cover;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	
	public boolean pickBook() {
		if (amountActual==0) {
			return false;
		}else {
			amountActual--;
			return true;
		}
	}
	
	public void returnBook () {
		amountActual++;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}
	
	public BookDto getBookDto () {
		return new BookDto(isbn, amount, titel, cover, pickPeriod, 
				authors.stream().map(Author::getName).collect(Collectors.toList()));
	}
	
}
