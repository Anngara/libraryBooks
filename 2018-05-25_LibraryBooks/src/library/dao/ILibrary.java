package library.dao;

import library.dto.*;

public interface ILibrary {
	LibraryReturnCode addAuthor(AuthorDto author);

	LibraryReturnCode addBook(BookDto book);

	LibraryReturnCode pickBook(PickBookData data);

	LibraryReturnCode addReader(ReaderDto reader);
	
	AuthorDto getAuthor (String name);
}
