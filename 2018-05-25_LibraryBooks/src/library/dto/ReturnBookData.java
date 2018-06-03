package library.dto;

import java.time.LocalDate;

public class ReturnBookData {
	int readerId;
	long isbn;
	LocalDate  returnDate;
	
	public ReturnBookData() {
	}

	public ReturnBookData(int readerId, long isbn, LocalDate returnDate) {
		this.readerId = readerId;
		this.isbn = isbn;
		this.returnDate = returnDate;
	}

	public int getReaderId() {
		return readerId;
	}

	public long getIsbn() {
		return isbn;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}
	
}
