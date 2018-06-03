package library.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import library.entities.Record;

public interface RecordRepository extends JpaRepository <Record,Integer> {

	Record findByBookIsbnAndReaderReaderIdAndReturnDateNull(long isbn, int readerId);

	List<Record> findByReturnDateNull();

}
