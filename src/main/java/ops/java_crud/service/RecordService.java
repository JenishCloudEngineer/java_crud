package ops.java_crud.service;

import ops.java_crud.model.Record;
import ops.java_crud.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    private final RecordRepository repository;

    public RecordService(RecordRepository repository) {
        this.repository = repository;
    }

    public Record save(Record record) {
        return repository.save(record);
    }

    public Optional<Record> update(Long id, Record newRecord) {
        return repository.findById(id).map(record -> {
            record.setData(newRecord.getData());
            return repository.save(record);
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Record> getAll() {
        return repository.findAll();
    }

    public Optional<Record> getById(Long id) {
    return repository.findById(id);
    }

}
