package library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import library.entities.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Integer>  {

}
