package library.entities;

import java.util.*;
import javax.persistence.*;
import library.dto.Cover;

@Table(name = "books")
@Entity
public class Book {
	@Id
	long isbm;
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
	
	
	public Book(long isbm, int amount, String titel, Cover cover, int pickPeriod, List<Author> authors) {
		this.isbm = isbm;
		this.amount = amount;
		this.amountActual = amount;
		this.titel = titel;
		this.cover = cover;
		this.pickPeriod = pickPeriod;
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

	public long getIsbm() {
		return isbm;
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
	
	
}
