package br.com.neves.book_service.domain.dto;

import org.springframework.validation.FieldError;

import static br.com.neves.book_service.infra.utils.ValidationMessageFormatter.formatValidationMessage;

public record FieldErrorDTO(
        String field,
        String message
) {
    public FieldErrorDTO (FieldError fieldError){
        this(fieldError.getField(), formatValidationMessage(fieldError.getField(), fieldError.getDefaultMessage()));
    }
}
