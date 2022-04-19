package com.pocs.mycrud.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
            new Student(
                    1L,
                    "Camila",
                    "camila@gmail.com",
                    LocalDate.of(1987, 5, 12),
                    35
            ),
            new Student(
                    2L,
                    "Raffa",
                    "raffa@gmail.com",
                    LocalDate.of(1978, 10, 19),
                    43
            )

        );
    }
}
