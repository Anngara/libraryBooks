package library.dao;
import library.dto.*;

public interface ILibrary {
	boolean addAuthor(AuthorDto author);
	boolean addBook(BookDto book);
}
