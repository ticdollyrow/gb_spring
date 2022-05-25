package ru.lesson7.lesson7.Exceptions;

public class ExistEntityException extends RuntimeException{
    public ExistEntityException(String message) {
        super(message);
    }
}
