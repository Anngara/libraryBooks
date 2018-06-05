package library.dto;


public class ReturnBookData {
	int readerId;
	long isbn;
	String  returnDate;
	
	public ReturnBookData() {
	}

	public ReturnBookData(int readerId, long isbn, String returnDate) {
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

	public String getReturnDate() {
		return returnDate;
	}
	
}
