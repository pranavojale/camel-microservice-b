package com.ojale.pranav.camelmicroserviceb.transformer;

import com.ojale.pranav.camelmicroserviceb.model.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MyCurrencyExchangeTransformer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyCurrencyExchangeTransformer.class);

    public CurrencyExchange processMessage(CurrencyExchange currencyExchange){

        currencyExchange.setConversionMultiple(currencyExchange.getConversionMultiple().multiply(BigDecimal.TEN));

        LOGGER.info("Do some transformation with currencyExchange.getConversionMultiple() value which is {}",
                currencyExchange.getConversionMultiple());

        return currencyExchange;
    }
}
