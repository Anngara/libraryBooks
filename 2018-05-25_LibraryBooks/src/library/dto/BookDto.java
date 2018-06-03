package library.dto;

import java.util.List;

public class BookDto {
	public long isbn;
	public int amount;
	public String titel;
	public Cover cover;
	public int pickPeriod;
	public List<String> authorsNames;
	
	public BookDto() {
	}
	
	public BookDto(long isbn, int amount, String titel, Cover cover, int pickPeriod, List<String> authorsNames) {
		this.isbn = isbn;
		this.amount = amount;
		this.titel = titel;
		this.cover = cover;
		this.pickPeriod = pickPeriod;
		this.authorsNames = authorsNames;
	}

	@Override
	public String toString() {
		return "BookDto [isbn=" + isbn + ", amount=" + amount + ", titel=" + titel + ", cover=" + cover
				+ ", pickPeriod=" + pickPeriod + ", authors=" + authorsNames + "]";
	}
	public long getIsbn() {
		return isbn;
	}
	public int getAmount() {
		return amount;
	}
	public String getTitel() {
		return titel;
	}
	public Cover getCover() {
		return cover;
	}
	public int getPickPeriod() {
		return pickPeriod;
	}
	public List<String> getAuthors() {
		return authorsNames;
	}
	
	
}
