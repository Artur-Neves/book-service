package br.com.neves.book_service.domain.dto;

import br.com.neves.book_service.domain.Book;
import br.com.neves.book_service.environment.InstanceInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BookDetailsDTO(
        Long id,
        String author,
        LocalDateTime launchDate,
        String price,
        String title,
        String environment
) {
    public BookDetailsDTO (Book book, String port){
        this(book.getId(),
                book.getAuthor(),
                book.getLaunchDate(),
                book.getPrice().toString(),
                book.getTitle(),
                "PORT "+port);
    }

    public BookDetailsDTO (Book book, String price, String port){
        this(book.getId(),
                book.getAuthor(),
                book.getLaunchDate(),
                price,
                book.getTitle(),
                "PORT "+port);
    }
}
