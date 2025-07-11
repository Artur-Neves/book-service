package br.com.neves.book_service.repository;

import br.com.neves.book_service.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
}
