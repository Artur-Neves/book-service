package br.com.neves.book_service.proxy;

import br.com.neves.book_service.domain.Currency;

import java.math.BigDecimal;

public record SimpleExchangeConvertedDTO(
        BigDecimal value,
        Currency from,
        Currency to,
        BigDecimal factorConversation,
        String valueConverted,
        String environment
) {
}
