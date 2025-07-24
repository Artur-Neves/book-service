package br.com.neves.book_service.proxy;

import br.com.neves.book_service.domain.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "exchange-service", url = "${EXCHANGE_SERVICE_SERVICE_HOST:http://host.docker.internal}:8000")
public interface ExchangeProxy {
    @GetMapping("/exchange-service/{value}/{from}/{to}")
    public ResponseEntity<SimpleExchangeConvertedDTO> exchangeConvert(
            @PathVariable BigDecimal value,
            @PathVariable Currency from,
            @PathVariable Currency to
    );
}
