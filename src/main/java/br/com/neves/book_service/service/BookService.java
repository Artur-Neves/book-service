package br.com.neves.book_service.service;

import br.com.neves.book_service.domain.Book;
import br.com.neves.book_service.domain.Currency;
import br.com.neves.book_service.infra.exception.BookException;
import br.com.neves.book_service.proxy.ExchangeProxy;
import br.com.neves.book_service.proxy.SimpleExchangeConvertedDTO;
import br.com.neves.book_service.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public Page<Book> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Book findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BookException("Nenhum livro encontrado para este id fornecido"));
    }

    public Book save(Book book) {
        return  repository.save(book);
    }

    @Transactional
    public Book update(Book bookDto, Long id) {
        Book book = this.findById(id);
        book.merge(bookDto);
        return book;
    }

    public void delete(Long id) {
        repository.delete(this.findById(id));
    }
}
