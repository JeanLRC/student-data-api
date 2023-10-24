package br.com.jeanlrc.studentdataapi.model.dtos;

import jakarta.validation.constraints.NotNull;

public record StudentUpdateDTO(
        @NotNull
        Long id,
        String name,
        int age,
        double firstSemesterGrade,
        double secondSemesterGrade,
        String teacher,
        String classNumber
) {
}
