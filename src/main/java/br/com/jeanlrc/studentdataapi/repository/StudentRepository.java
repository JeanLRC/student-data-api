package br.com.jeanlrc.studentdataapi.repository;

import br.com.jeanlrc.studentdataapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
