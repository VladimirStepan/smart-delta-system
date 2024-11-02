package com.smart.delta.system.util;

import com.smart.delta.system.dto.StudentDTO;
import com.smart.delta.system.entity.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Конвертер для преобразования объектов {@link StudentEntity}, {@link StudentDTO}.
 * <p>
 * Использует {@link ModelMapper} для автоматического сопоставления полей между объектами.
 *
 */
@Component
@RequiredArgsConstructor
public class StudentConvertor {
    private final ModelMapper modelMapper;

    public StudentDTO convertToStudentDTO(StudentEntity studentEntity) {
        return modelMapper.map(studentEntity, StudentDTO.class);
    }

    public StudentEntity convertToStudentEntity(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, StudentEntity.class);
    }
}
