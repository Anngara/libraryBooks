package library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.dto.*;
import library.entities.*;
import library.repo.AuthorRepository;
import library.repo.BookRepository;

@Service
public class LibraryOrm implements ILibrary {
	@Autowired
	BookRepository books;
	@Autowired
	AuthorRepository authors;

	@Override
	@Transactional
	public boolean addAuthor(AuthorDto authorDto) {
		if (authors.existsById(authorDto.name)) {
			return false;
		}
		authors.save(authorDto.getAuthor());
		return true;
	}

	@Override
	@Transactional
	public boolean addBook(BookDto bookDto) {
		if (!checkAuthors (bookDto.authorsNames)) {
			return false;
		}
		if (books.existsById(bookDto.getIsbm())) {
			return false;
		}
		
		Book book = new Book(bookDto.isbm, bookDto.amount, bookDto.titel, bookDto.cover, bookDto.pickPeriod,
				authors.findAllById(bookDto.authorsNames));
		return books.save(book) != null;
	}

	private boolean checkAuthors(List <String> authorsNames) {
		for (String name: authorsNames) {
			if (!authors.existsById(name)) {
				return false;
			}
		}
		return true;
	}

}
