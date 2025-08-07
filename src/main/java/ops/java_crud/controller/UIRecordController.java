package ops.java_crud.controller;

import ops.java_crud.model.Record;
import ops.java_crud.service.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/ui/records")
public class UIRecordController {

    private final RecordService recordService;

    public UIRecordController(RecordService recordService) {
        this.recordService = recordService;
    }
    
    // ✅ List all records
    @GetMapping
    public String listRecords(Model model) {
        model.addAttribute("records", recordService.getAll());
        return "ui/index"; // maps to index.html
    }

    // ✅ Show form to create new record
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("record", new Record());
        return "ui/form"; // maps to form.html
    }

    // ✅ Show form to edit an existing record
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Record> record = recordService.getById(id);
        if (record.isPresent()) {
            model.addAttribute("record", record.get());
            return "ui/form"; // maps to form.html
        } else {
            return "redirect:/ui/records";
        }
    }

    // ✅ Save new or updated record
    @PostMapping("/save")
    public String save(@ModelAttribute Record record) {
        if (record.getId() != null) {
            recordService.update(record.getId(), record);
        } else {
            recordService.save(record);
        }
        return "redirect:/ui/records";
    }

    // ✅ Delete a record
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        recordService.delete(id);
        return "redirect:/ui/records";
    }
}

