package library.dao;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.dto.*;
import library.entities.*;
import library.repo.*;

@Service
public class LibraryOrm implements ILibrary {
	@Autowired
	BookRepository books;
	@Autowired
	AuthorRepository authors;
	@Autowired
	ReaderRepository readers;
	@Autowired
	RecordRepository records;
	
	@Override
	@Transactional
	public LibraryReturnCode addAuthor(AuthorDto authorDto) {
		if (authors.existsById(authorDto.name)) {
			return LibraryReturnCode.AUTHOR_ALREADY_EXISTS;
		}
		authors.save(new Author(authorDto.name, authorDto.country));
		return LibraryReturnCode.OK;
	}

	@Override
	@Transactional
	public LibraryReturnCode addBook(BookDto bookDto) {
		if (books.existsById(bookDto.getIsbm())) {
			return LibraryReturnCode.BOOK_ALREADY_EXISTS;
		}
		
		if (!checkAuthors (bookDto.authorsNames)) {
			return LibraryReturnCode.NO_AUTHOR;
		}
		Book book = new Book(bookDto.isbm, bookDto.amount, bookDto.titel, bookDto.cover, bookDto.pickPeriod,
				authors.findAllById(bookDto.authorsNames));
		books.save(book);
		return LibraryReturnCode.OK;
	}

	private boolean checkAuthors(List <String> authorsNames) {
		for (String name: authorsNames) {
			if (!authors.existsById(name)) {
				return false;
			}
		}
		return true;
	}

	@Override
	@Transactional
	public LibraryReturnCode pickBook(PickBookData data) {
		Book book = books.findById(data.getIsbm()).orElse(null);
		if (book==null){
			return LibraryReturnCode.NO_BOOK;
		}
		if (!book.pickBook()) {
			return LibraryReturnCode.ALL_BOOKS_IN_USE;
		}
		Reader reader = readers.findById(data.getId()).orElse(null);
		if (reader==null) {
			return LibraryReturnCode.NO_READER;
		}
		try {
		LocalDate date = LocalDate.parse(data.getPickDate());
		records.save (new Record(date, book, reader));
		return LibraryReturnCode.OK;
		}catch (DateTimeParseException e) {
			return LibraryReturnCode.WRONG_DATE_FORMAT;
		}
	}

	@Override
	@Transactional
	public LibraryReturnCode addReader(ReaderDto reader) {
		if (readers.existsById(reader.getId())) {
			return LibraryReturnCode.READER_ALREADY_EXISTS;
		}
		readers.save(new Reader(reader.getId(), reader.getName(), reader.getYear(), reader.getNumber()));
		return LibraryReturnCode.OK;
	}

}
