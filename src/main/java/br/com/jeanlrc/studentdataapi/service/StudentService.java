package br.com.jeanlrc.studentdataapi.service;


import br.com.jeanlrc.studentdataapi.model.Student;
import br.com.jeanlrc.studentdataapi.model.dtos.StudentUpdateDTO;
import br.com.jeanlrc.studentdataapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> list() {
        return repository.findAll();
    }

    public Student detailStudent(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Student create(Student student) {
        repository.save(student);
        return student;
    }

    public Student update(StudentUpdateDTO data) {
        Student student = repository.getReferenceById(data.id());
        student.updateInfo(data);
        repository.save(student);
        return student;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
