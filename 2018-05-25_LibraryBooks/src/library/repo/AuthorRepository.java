package library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import library.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, String> {

}
