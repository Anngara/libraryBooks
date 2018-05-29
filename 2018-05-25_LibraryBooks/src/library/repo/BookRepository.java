package library.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
