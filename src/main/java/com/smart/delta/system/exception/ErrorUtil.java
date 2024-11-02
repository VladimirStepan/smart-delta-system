package com.smart.delta.system.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * Утилита для обработки ошибок валидации.
 * <p>
 * Предоставляет метод для преобразования ошибок валидации в строку
 * сообщения и генерации исключения {@link StudentException}.
 */
public class ErrorUtil {

    /**
     * Преобразует ошибки валидации из {@link BindingResult} в строку сообщения
     * и генерирует исключение {@link StudentException}.
     *
     * @param bindingResult Объект {@link BindingResult}, содержащий ошибки валидации.
     */
    public static void returnsClientErrorMessage(BindingResult bindingResult) {
        StringBuilder errorMessage = new StringBuilder();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        for (FieldError fieldError : fieldErrors) {
            errorMessage.append(fieldError.getField())
                    .append(" - ")
                    .append(fieldError.getDefaultMessage() == null ? fieldError.getCode() : fieldError.getDefaultMessage())
                    .append(";");
            throw new StudentException(errorMessage.toString());
        }
    }
}
