package com.pocs.mycrud.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository repo;

    @Autowired
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getStudents() {

        return repo.findAll();
//        return List.of(
//            new Student(
//                    1L,
//                    "Camila",
//                    "camila@gmail.com",
//                    LocalDate.of(1987, 5, 12),
//                    35
//            ),
//            new Student(
//                    2L,
//                    "Raffa",
//                    "raffa@gmail.com",
//                    LocalDate.of(1978, 10, 19),
//                    43
//            )
//
//        );
    }

    public void addNewStudent(Student s) throws Exception {

        /* então esse é o nullable no java! */
        Optional<Student> existing = repo.findStudentByEmail(s.getEmail());

        if(existing.isPresent())
            throw new IllegalStateException("O email já existe.");

        repo.save(s);
    }

    public void remove(Long id) throws Exception {
        if(repo.existsById(id))
            repo.deleteById(id);
        else
            throw new NoSuchElementException(String.format("Nenhum registro encontrado com id = %d.", id));

    }

    public void update(Student s) {
        Long id = s.getId();

        if(repo.existsById(id))
            repo.save(s);
        else
            throw new NoSuchElementException(String.format("Nenhum registro encontrado com id = %d.", id));
    }
}
