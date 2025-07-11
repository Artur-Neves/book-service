package br.com.neves.book_service.domain.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateBookDTO(
        @NotBlank
        @Size(min = 3, max= 255)
        String author,
        @NotNull
        @PastOrPresent
        LocalDateTime launchDate,
        @NotNull
        BigDecimal price,
        @NotBlank
        @Size(min = 3, max= 255)
        String title
) {
}
