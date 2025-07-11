package br.com.neves.book_service.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UpdateBootDTO(
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
