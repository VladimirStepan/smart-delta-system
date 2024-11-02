package com.smart.delta.system.repository;

import com.smart.delta.system.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с сущностью {@link StudentEntity}.
 * <p>
 * Предоставляет базовые операции CRUD (Create, Read, Update, Delete)
 * для объектов {@link StudentEntity},
 */
@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {
}
