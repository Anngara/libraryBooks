package library.dao;

import java.util.List;

import library.dto.*;

public interface ILibrary {
	LibraryReturnCode addAuthor(AuthorDto author);

	LibraryReturnCode addBook(BookDto book);

	LibraryReturnCode pickBook(PickBookData data);

	LibraryReturnCode addReader(ReaderDto reader);
	
	AuthorDto getAuthor (String name);
	
	List <AuthorDto> getAllAuthors ();
	
	LibraryReturnCode  returnBook (ReturnBookData data);
	
	List <ReaderDto>  getReadersDelayingBooks();
	
	List <AuthorDto>  getBookAuthors(long isbn);
	
	List <BookDto>  getAuthorBooks (String  authorName);  
	
}
