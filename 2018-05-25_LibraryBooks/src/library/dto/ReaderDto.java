package library.dto;
public class ReaderDto {
	int id;
	String name;
	int year;
	int number;
	
	public ReaderDto() {
	}

	public ReaderDto(int id, String name, int year, int number) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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
	
	
}
