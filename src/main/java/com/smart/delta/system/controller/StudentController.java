package com.smart.delta.system.controller;

import com.smart.delta.system.dto.StudentDTO;
import com.smart.delta.system.dto.StudentResponse;
import com.smart.delta.system.entity.StudentEntity;
import com.smart.delta.system.service.StudentService;
import com.smart.delta.system.util.StudentConvertor;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.smart.delta.system.exception.ErrorUtil.returnsClientErrorMessage;

@RestController
@RequestMapping("/smart/delta/system/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentConvertor studentConvertor;

    /**
     * Возвращает список всех студентов.
     *
     * @return Список дто студентов.
     */
    @GetMapping()
    public StudentResponse getAllStudent() {
        return new StudentResponse(studentService.findAll().stream().map(studentConvertor::convertToStudentDTO).toList());
    }

    /**
     * Добавляет нового студента.
     * @param studentDTO Дто студента для добавления.
     * @param bindingResult Отлавливает ошибки.
     * @return Ответ сервера на запрос.
     */
    @PostMapping("/registration")
    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentDTO studentDTO, BindingResult bindingResult) {
        StudentEntity studentEntity = studentConvertor.convertToStudentEntity(studentDTO);

        if (bindingResult.hasErrors()) {
            returnsClientErrorMessage(bindingResult);
        }

        studentService.save(studentEntity);

        return new ResponseEntity<>(studentEntity, HttpStatus.CREATED);
    }

    /**
     * Обновляет сущность студента.
     * @param id Id студента для изменения.
     * @param studentDTO Новая сущность студента.
     * @param bindingResult Отлавливает ошибки.
     * @return Ответ сервера на запрос.
     */
    @PatchMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestParam int id, @Valid @RequestBody StudentDTO studentDTO, BindingResult bindingResult) {
        Optional<StudentEntity> studentEntityOptional = studentService.findById(id);

        if(studentEntityOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            if(bindingResult.hasErrors()) {
                returnsClientErrorMessage(bindingResult);
            }

            studentService.updateStudent(id, studentDTO);

            return new ResponseEntity<>(studentDTO, HttpStatus.OK);
        }
    }

    /**
     * Удаляет студента.
     * @param studentId Id студента для удаления.
     * @return Ответ сервера.
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStudent(@RequestParam int studentId) {
        Optional<StudentEntity> studentEntity = studentService.findById(studentId);

        if (studentEntity.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            studentService.delete(studentId);
            return new ResponseEntity<>(studentEntity, HttpStatus.OK);
        }
    }

}
