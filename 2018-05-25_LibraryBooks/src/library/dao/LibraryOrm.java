package library.dao;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

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
		authors.save(new Author(authorDto));
		return LibraryReturnCode.OK;
	}

	@Override
	@Transactional
	public LibraryReturnCode addBook(BookDto bookDto) {
		if (books.existsById(bookDto.getIsbn())) {
			return LibraryReturnCode.BOOK_ALREADY_EXISTS;
		}

		if (!checkAuthors(bookDto.authorsNames)) {
			return LibraryReturnCode.NO_AUTHOR;
		}
		Book book = new Book(bookDto, authors.findAllById(bookDto.authorsNames));
		books.save(book);
		return LibraryReturnCode.OK;
	}

	private boolean checkAuthors(List<String> authorsNames) {
		for (String name : authorsNames) {
			if (!authors.existsById(name)) {
				return false;
			}
		}
		return true;
	}

	@Override
	@Transactional
	public LibraryReturnCode pickBook(PickBookData data) {
		Book book = books.findById(data.getIsbn()).get();
		if (book == null) {
			return LibraryReturnCode.NO_BOOK;
		}

		Reader reader = readers.findById(data.getReadeId()).get();
		if (reader == null) {
			return LibraryReturnCode.NO_READER;
		}

		try {
			LocalDate date = LocalDate.parse(data.getPickDate());
			
			if (!book.pickBook()) {
				return LibraryReturnCode.ALL_BOOKS_IN_USE;
			}
			
			records.save(new Record(date, book, reader));
			return LibraryReturnCode.OK;
		} catch (DateTimeParseException e) {
			return LibraryReturnCode.WRONG_DATE_FORMAT;
		}
	}

	@Override
	@Transactional
	public LibraryReturnCode addReader(ReaderDto reader) {
		if (readers.existsById(reader.getReaderId())) {
			return LibraryReturnCode.READER_ALREADY_EXISTS;
		}
		readers.save(new Reader(reader));
		return LibraryReturnCode.OK;
	}

	@Override
	@Transactional
	public AuthorDto getAuthor(String name) {
		return authors.findById(name).orElse(null).getAuthorDto();
	}

	@Override
	@Transactional
	public List<AuthorDto> getAllAuthors() {
		return authors.findAll().stream().map(x->x.getAuthorDto()).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public LibraryReturnCode returnBook(ReturnBookData data) {
		Record record = records.findByBookIsbnAndReaderReaderIdAndReturnDateNull(data.getIsbn(), data.getReaderId());
		if (record == null)
			return LibraryReturnCode.NO_RECORD_FOR_RETURN;
		try {
			LocalDate date = LocalDate.parse(data.getReturnDate());
			record.setReturnDate(date);
			} catch (DateTimeParseException e) {
				return LibraryReturnCode.WRONG_DATE_FORMAT;
			}
		record.getBook().returnBook();
		return LibraryReturnCode.OK;
	}

	@Override
	@Transactional
	public List<ReaderDto> getReadersDelayingBooks() {
		return records.findByReturnDateNull()
				.filter(Record::checkDelay).map(x->x.getReader().getReaderDto()).distinct().collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<AuthorDto> getBookAuthors(long isbn) {
		return books.findById(isbn).get().getAuthors().stream().map(Author::getAuthorDto).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<BookDto> getAuthorBooks(String authorName) {
		return authors.findById(authorName).get().getBooks().stream()
				.map(Book::getBookDto).collect(Collectors.toList());
	}

}
