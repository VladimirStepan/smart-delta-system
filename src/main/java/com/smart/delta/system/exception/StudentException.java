package com.smart.delta.system.exception;

/**
 * Представляет собой исключение специфичное для системы антенн.
 *
 */
public class StudentException extends RuntimeException {

    /**
     * Создает новое исключение {@link StudentException} с заданным сообщением.
     *
     * @param message Сообщение об ошибке.
     */
    public StudentException(String message) {
        super(message);
    }
}
