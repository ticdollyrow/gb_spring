package ru.lesson7.lesson7.Exceptions;

public class ResourceNotFoundExeption extends RuntimeException{
    public ResourceNotFoundExeption(String message) {
        super(message);
    }
}
