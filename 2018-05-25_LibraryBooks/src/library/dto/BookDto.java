package library.dto;

import java.util.List;

public class BookDto {
	public long isbm;
	public int amount;
	public String titel;
	public Cover cover;
	public int pickPeriod;
	public List<String> authorsNames;
	
	public BookDto() {
	}
	@Override
	public String toString() {
		return "BookDto [isbm=" + isbm + ", amount=" + amount + ", titel=" + titel + ", cover=" + cover
				+ ", pickPeriod=" + pickPeriod + ", authors=" + authorsNames + "]";
	}
	public long getIsbm() {
		return isbm;
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
