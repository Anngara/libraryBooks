package library.dto;
public class ReaderDto {
	int readerId;
	String name;
	int year;
	int number;
	
	public ReaderDto() {
	}

	public ReaderDto(int readerId, String name, int year, int number) {
		this.readerId = readerId;
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

	public int getReaderId() {
		return readerId;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}
	
	
}
