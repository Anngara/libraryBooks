package library.entities;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;

@Entity
@Table(name = "records")
public class Record {
	@Id
	@GeneratedValue
	int id;
	LocalDate pickDate;
	LocalDate returnDate;
	int delayDays;
	@ManyToOne
	Book book;
	@ManyToOne
	Reader reader;

	public Record(LocalDate pickDate, Book book, Reader reader) {
		this.pickDate = pickDate;
		this.book = book;
		this.reader = reader;
	}

	public Record() {
	}

	public int getDelayDays() {
		return delayDays;
	}

	public void setDelayDays(int delayDays) {
		this.delayDays = delayDays;
	}

	public LocalDate getPickDate() {
		return pickDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public Book getBook() {
		return book;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
		int rentalDays = Period.between(pickDate, returnDate).getDays();
		delayDays = rentalDays - book.getPickPeriod();
		if (delayDays < 0) {
			delayDays = 0;
		}
	}
	
	public boolean checkDelay () {
		if (returnDate!=null)
			return false;
		int rentalDays = Period.between(pickDate, LocalDate.now()).getDays();
		if (book.pickPeriod<rentalDays)
			return true;
		return false;
	}

}
