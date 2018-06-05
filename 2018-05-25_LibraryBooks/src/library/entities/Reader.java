package library.entities;

import java.util.List;

import javax.persistence.*;

import library.dto.ReaderDto;
@Table(name = "readers")
@Entity
public class Reader {
	@Id
	int readerId;
	String name;
	int year;
	int number;
	@OneToMany 
	List <Record> records;


	public Reader(ReaderDto reader) {
		readerId = reader.getReaderId();
		name = reader.getName();
		year = reader.getYear();
		number = reader.getNumber();
	}

	public Reader(int readerId, String name, int year, int number) {
		this.readerId = readerId;
		this.name = name;
		this.year = year;
		this.number = number;
	}
	
	public Reader() {
	
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public int getReaderId() {
		return readerId;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public int getNumber() {
		return number;
	}
	
	public ReaderDto getReaderDto () {
		return new ReaderDto(readerId, name, year,number);
	}

}
