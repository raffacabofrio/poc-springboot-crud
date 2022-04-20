package com.pocs.mycrud.student;

import com.pocs.mycrud.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getStudents() {
            return service.getStudents();
    }

    @PostMapping("add-student")
    public void insertStudent(@RequestBody Student s) throws Exception {
        service.addNewStudent(s);
    }

    @PostMapping("add-book")
    public String addBook(@RequestBody Book b) throws Exception {
        return b.getDescription();
    }
}
