package ops.java_crud.repository;

import ops.java_crud.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {}
