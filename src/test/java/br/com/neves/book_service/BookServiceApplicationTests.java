package br.com.neves.book_service;

import br.com.neves.book_service.domain.Book;
import br.com.neves.book_service.repository.BookRepository;
import br.com.neves.book_service.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class BookServiceApplicationTests {
	@Mock
	protected Pageable pageable;
	@Mock
	protected BookRepository repository;
	@InjectMocks
	protected BookService bookService;

	@Test
	void contextLoads() {
		// Brincando com testes automatizados
		Page<Book> book = new PageImpl<>(List.of(new Book()));
		when(repository.findAll(any(Pageable.class))).thenReturn(book);
		assertEquals(book, bookService.findAll(pageable));
		then(repository).should().findAll(any(Pageable.class));
	}

}
