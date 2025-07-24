package br.com.neves.book_service.controller;

import br.com.neves.book_service.domain.Book;
import br.com.neves.book_service.domain.dto.BookDetailsDTO;
import br.com.neves.book_service.domain.dto.CreateBookDTO;
import br.com.neves.book_service.domain.dto.UpdateBootDTO;
import br.com.neves.book_service.environment.InstanceInformationService;
import br.com.neves.book_service.domain.Currency;
import br.com.neves.book_service.proxy.ExchangeProxy;
import br.com.neves.book_service.proxy.SimpleExchangeConvertedDTO;
import br.com.neves.book_service.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@Tag(name= "Book Endpoint")
@RequestMapping("/book-service")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService service;

    @Autowired
    private InstanceInformationService informationService;

    @Autowired
    private ExchangeProxy exchangeProxy;



    @GetMapping()
    public ResponseEntity<Page<BookDetailsDTO>> findAll (@PageableDefault Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable).map(book -> new BookDetailsDTO(book, informationService.getPort())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailsDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(new BookDetailsDTO(service.findById(id), informationService.getPort()));
    }

    @GetMapping("/{id}/{from}")
    public ResponseEntity<BookDetailsDTO> findById(@PathVariable Long id,
                                                   @PathVariable Currency from){
        Book book = service.findById(id);
        log.info("Calculando o teste papa");
        SimpleExchangeConvertedDTO convertedDTO= exchangeProxy.exchangeConvert(book.getPrice(),Currency.USD, from).getBody();

        return ResponseEntity.ok(new BookDetailsDTO(book, convertedDTO.valueConverted(), convertedDTO.environment()));
    }

    @PostMapping("")
    public ResponseEntity<BookDetailsDTO> save (@RequestBody @Valid CreateBookDTO createBookDTO, UriComponentsBuilder builder){
        Book book = service.save(new Book(createBookDTO));
        URI uri = builder.path("/book-service/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(new BookDetailsDTO(book, informationService.getPort()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDetailsDTO> update (@RequestBody @Valid UpdateBootDTO updateBootDTO,@PathVariable Long id){
        return ResponseEntity.ok(new BookDetailsDTO(service.update(new Book(updateBootDTO), id), informationService.getPort()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDetailsDTO> delete (@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
