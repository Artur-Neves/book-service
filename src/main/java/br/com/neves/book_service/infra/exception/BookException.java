package br.com.neves.book_service.infra.exception;

public class BookException extends RuntimeException {
    public BookException(String message) {
        super(message);
    }
}
