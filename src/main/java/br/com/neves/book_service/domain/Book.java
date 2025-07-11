package br.com.neves.book_service.domain;

import br.com.neves.book_service.domain.dto.CreateBookDTO;
import br.com.neves.book_service.domain.dto.UpdateBootDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private LocalDateTime launchDate;
    private BigDecimal price;
    private String title;

    public Book() {
    }

    public Book(String author, Long id, LocalDateTime launchDate, BigDecimal price, String title) {
        this.author = author;
        this.id = id;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
    }

    public Book (CreateBookDTO dto){
        this.author = dto.author();
        this.launchDate = dto.launchDate();
        this.price = dto.price();
        this.title = dto.title();
    }

    public Book (UpdateBootDTO dto){
        this.author = dto.author();
        this.launchDate = dto.launchDate();
        this.price = dto.price();
        this.title = dto.title();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDateTime launchDate) {
        this.launchDate = launchDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book merge(Book book){
        this.author = book.getAuthor();
        this.launchDate = book.getLaunchDate();
        this.price = book.getPrice();
        this.title = book.getTitle();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
