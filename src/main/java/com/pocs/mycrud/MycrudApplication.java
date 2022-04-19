package com.pocs.mycrud;

import java.time.LocalDate;
import java.util.List;

import com.pocs.mycrud.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MycrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycrudApplication.class, args);
	}

}
