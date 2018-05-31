package library.dto;

public class PickBookData {
	int id;
	long isbm;
	String pickDate;
	
	public PickBookData() {
	}
	

	public PickBookData(int id, long isbm, String pickDate) {
		this.id = id;
		this.isbm = isbm;
		this.pickDate = pickDate;
	}


	public int getId() {
		return id;
	}

	public long getIsbm() {
		return isbm;
	}

	public String getPickDate() {
		return pickDate;
	}
	
	
}
