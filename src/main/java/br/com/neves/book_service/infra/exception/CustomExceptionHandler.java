package br.com.neves.book_service.infra.exception;

import br.com.neves.book_service.domain.dto.ErrorResponseDTO;
import br.com.neves.book_service.domain.dto.ErrorValidationResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> exception (Exception e){
        return  ResponseEntity.internalServerError().body(new ErrorResponseDTO(500, e));
    }
    @ExceptionHandler(BookException.class)
    public ResponseEntity<ErrorResponseDTO> exception (BookException e){
        return  ResponseEntity.badRequest().body(new ErrorResponseDTO(400, e));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorValidationResponseDTO> exception (MethodArgumentNotValidException e){
        return  ResponseEntity.badRequest().body(new ErrorValidationResponseDTO(e));
    }
}
