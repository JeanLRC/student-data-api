package br.com.jeanlrc.studentdataapi.model.dtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record StudentDTO(
        @NotBlank String name,
        @Positive int age,
        @Positive double firstSemesterGrade,
        @Positive double secondSemesterGrade,
        @NotBlank String teacher,
        @NotBlank String classNumber
) {
}