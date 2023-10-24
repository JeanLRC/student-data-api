package br.com.jeanlrc.studentdataapi.model;

import br.com.jeanlrc.studentdataapi.model.dtos.StudentDTO;
import br.com.jeanlrc.studentdataapi.model.dtos.StudentUpdateDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private double firstSemesterGrade;
    private double secondSemesterGrade;
    private String teacher;
    private String classNumber;

    public Student (StudentDTO data) {
        this.name = data.name();
        this.age = data.age();
        this.firstSemesterGrade = data.firstSemesterGrade();
        this.secondSemesterGrade = data.secondSemesterGrade();
        this.teacher = data.teacher();
        this.classNumber = data.classNumber();
    }

    public void updateInfo(StudentUpdateDTO data) {
        if(data.name() != null) {
          this.name = data.name();
        }
        if(data.age() != 0) {
          this.age = data.age();
        }
        if(data.firstSemesterGrade() != 0) {
          this.firstSemesterGrade = data.firstSemesterGrade();
        }
        if(data.secondSemesterGrade() != 0) {
          this.secondSemesterGrade = data.secondSemesterGrade();
        }
        if(data.teacher() != null) {
          this.teacher = data.teacher();
        }
        if(data.classNumber() != null) {
          this.classNumber = data.classNumber();
        }
    }
}
