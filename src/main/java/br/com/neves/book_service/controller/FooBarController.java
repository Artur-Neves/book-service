package br.com.neves.book_service.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Tag(name= "Foo Bar Endpoint")
@RequestMapping("/book-service")
public class FooBarController {

    private static final Logger log = LoggerFactory.getLogger(FooBarController.class);

    @GetMapping("/foo-bar")
//  @CircuitBreaker(name = "default", fallbackMethod = "foobarFallback")
    @RateLimiter(name = "foot-rate", fallbackMethod = "foobarFallback")
    public String fooBar(){
        log.info("Request passes here");
//        var teste = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
        return "foi";
    }

    public String foobarFallback(Exception e){
        return "laranjão";
    }
}
