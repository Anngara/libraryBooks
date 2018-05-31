package library.entities;

import java.util.List;

import javax.persistence.*;
@Table(name = "readers")
@Entity
public class Reader {
	@Id
	int id;
	String name;
	int year;
	int number;
	@OneToMany (mappedBy = "reader")
	List<Record> records;


	public Reader() {
	}

	public Reader(int id, String name, int year, int number) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.number = number;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public int getId() {
		return id;
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

}
