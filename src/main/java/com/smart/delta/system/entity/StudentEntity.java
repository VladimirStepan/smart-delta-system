package com.smart.delta.system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сущность студента.
 */

@Entity
@NoArgsConstructor
@Table(name = "student")
@Getter
@Setter
public class StudentEntity {

    /**
     * Идентификатор студента.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Фамилия студента.
     */
    @NotEmpty(message = "Поле фамилия не должно быть пустым!")
    @Column(name = "surname")
    private String surname;

    /**
     * Имя студента.
     */
    @NotEmpty(message = "Поле имя не должно быть пустым!")
    @Column(name = "name")
    private String name;

    /**
     * Отчество студента.
     */
    @NotEmpty(message = "Поле отчество студена не должно быть пустым!")
    @Column(name = "patronymic")
    private String patronymic;

    /**
     * Группа студента.
     */
    @NotEmpty(message = "Поле группа студента не должно быть пустым!")
    @Column(name = "group_st")
    private String groupSt;

    /**
     * Средняя оценка.
     */
    @NotNull(message = "Поле средняя оценка ученика не должно быть пустым!")
    @Column(name = "average_rating")
    private double averageRating;
}
