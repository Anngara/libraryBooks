package library.dto;

public class PickBookData {
	int readeId;
	long isbn;
	String pickDate;
	
	public PickBookData() {
	}
	

	public PickBookData(int readeId, long isbn, String pickDate) {
		this.readeId = readeId;
		this.isbn = isbn;
		this.pickDate = pickDate;
	}


	

	public String getPickDate() {
		return pickDate;
	}


	public int getReadeId() {
		return readeId;
	}


	public long getIsbn() {
		return isbn;
	}
	
	
}
