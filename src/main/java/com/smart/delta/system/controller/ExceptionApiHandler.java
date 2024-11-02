package com.smart.delta.system.controller;

import com.smart.delta.system.exception.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Обработчик исключений API, который перехватывает исключения
 * и возвращает ответ с кодом ошибки и сообщением об ошибке.
 */
@RestControllerAdvice
public class ExceptionApiHandler {

    /**
     * Обрабатывает исключения типа StudentException и возвращает ответ с ошибкой.
     *
     * @param e исключение, которое было выброшено
     * @return объект ResponseEntity, содержащий сообщение об ошибке и статус HTTP 400 (BAD REQUEST)
     */
    @ExceptionHandler(StudentException.class)
    private ResponseEntity<?> studentException(StudentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
