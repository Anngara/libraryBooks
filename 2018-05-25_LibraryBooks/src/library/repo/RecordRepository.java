package library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import library.entities.Record;

public interface RecordRepository extends JpaRepository <Record,Integer> {

}
