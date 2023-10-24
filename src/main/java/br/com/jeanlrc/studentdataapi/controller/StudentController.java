package br.com.jeanlrc.studentdataapi.controller;

import br.com.jeanlrc.studentdataapi.model.Student;
import br.com.jeanlrc.studentdataapi.model.dtos.StudentDTO;
import br.com.jeanlrc.studentdataapi.model.dtos.StudentUpdateDTO;
import br.com.jeanlrc.studentdataapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Student>> listStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> detailStudent(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.detailStudent(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO studentData) {
        Student student = service.create(new Student(studentData));
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody StudentUpdateDTO studentData) {
        Student student = service.update(studentData);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
