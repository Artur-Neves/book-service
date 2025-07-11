package br.com.neves.book_service.domain.dto;

import jakarta.validation.ValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static br.com.neves.book_service.infra.utils.ValidationMessageFormatter.formatValidationMessage;

public record ErrorValidationResponseDTO (
        int status,
        String type,
        String message,
        List<FieldErrorDTO> errors,
        LocalDateTime timestamp
) {
    public ErrorValidationResponseDTO (MethodArgumentNotValidException exception){
        this(400,
                exception.getClass().getSimpleName(),
                formatValidationMessage(Objects.requireNonNull(exception.getFieldError()).getField(), Objects.requireNonNull(exception.getFieldError()).getDefaultMessage()),
                exception.getFieldErrors().stream().map(FieldErrorDTO::new).toList(),
                LocalDateTime.now());
    }
}
