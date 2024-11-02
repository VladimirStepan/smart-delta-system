package com.smart.delta.system.service;

import com.smart.delta.system.dto.StudentDTO;
import com.smart.delta.system.entity.StudentEntity;
import com.smart.delta.system.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

    /**
     * Возвращает список всех студентов.
     *
     * @return Список студентов.
     */
    public List<StudentEntity> findAll() {
        return studentRepo.findAll();
    }

    /**
     * Сохраняет студента.
     *
     * @param studentEntity Студент, которого надо сохранить.
     */
    @Transactional
    public void save(StudentEntity studentEntity) {
        studentRepo.save(studentEntity);
    }

    /**
     *
     * @param id Идентификатор антенны для изме
     * @param studentDTO
     * @return
     */
    @Transactional
    public Optional<StudentEntity> updateStudent(int id, StudentDTO studentDTO) {
        Optional<StudentEntity> studentEntity = studentRepo.findById(id);
        if (studentEntity.isEmpty()) {
            return Optional.empty();
        }

        StudentEntity student = studentEntity.get();

        if (studentDTO.getName() != null) {
            student.setName(studentDTO.getName());
        }
        if (studentDTO.getSurname() != null) {
            student.setSurname(studentDTO.getSurname());
        }
        if (studentDTO.getPatronymic() != null) {
            student.setPatronymic(studentDTO.getPatronymic());
        }
        if (studentDTO.getAverageRating() > 0) {
            student.setAverageRating(studentDTO.getAverageRating());
        }
        if (studentDTO.getGroupSt() != null) {
            student.setGroupSt(studentDTO.getGroupSt());
        }

        return Optional.of(studentRepo.save(student));
    }

    @Transactional
    public void delete(int studentId) {
        studentRepo.deleteById(studentId);
    }

    public Optional<StudentEntity> findById(int studentId) {
        return studentRepo.findById(studentId);
    }
}
