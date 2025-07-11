package br.com.neves.book_service.domain.dto;

import java.time.LocalDateTime;

public record ErrorResponseDTO(
        int status,
        String type,
        String message,
        LocalDateTime timestamp
) {
    public <T extends Exception> ErrorResponseDTO (int status, T exception){
        this(status, exception.getClass().getSimpleName(), exception.getMessage(), LocalDateTime.now());
    }
}
