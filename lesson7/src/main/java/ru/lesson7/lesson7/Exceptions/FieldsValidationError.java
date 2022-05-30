package ru.lesson7.lesson7.Exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FieldsValidationError {
    private List<String> errorFieldsMessages;

    public FieldsValidationError(List<String> errorFieldsMessages) {

        this.errorFieldsMessages = errorFieldsMessages;
    }
}
