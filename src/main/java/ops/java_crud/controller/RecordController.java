package ops.java_crud.controller;

import ops.java_crud.model.Record;
import ops.java_crud.service.RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }

    // Health check
    @GetMapping("/health")
    public String healthCheck() {
        return "Service is up";
    }

    // Create
    @PostMapping
    public ResponseEntity<Record> create(@RequestBody Record record) {
        return ResponseEntity.ok(service.save(record));
    }

    // Read all
    @GetMapping
    public List<Record> getAll() {
        return service.getAll();
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Record> update(@PathVariable Long id, @RequestBody Record record) {
        return service.update(id, record)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
