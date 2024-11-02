package com.smart.delta.system.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO для студента.
 */
@Getter
@Setter
public class StudentDTO {
    /**
     * Фамилия студента.
     */
    @NotEmpty(message = "Поле фамилия не должно быть пустым!")
    private String surname;

    /**
     * Имя студента.
     */
    @NotEmpty(message = "Поле имя не должно быть пустым!")
    private String name;

    /**
     * Отчество студента.
     */
    @NotEmpty(message = "Поле отчество студена не должно быть пустым!")
    private String patronymic;

    /**
     * Группа студента.
     */
    @NotEmpty(message = "Поле группа студента не должно быть пустым!")
    private String groupSt;

    /**
     * Средняя оценка.
     */
    @NotNull(message = "Поле средняя оценка ученика не должно быть пустым!")
    private double averageRating;
}
