package com.ojale.pranav.camelmicroserviceb.processor;

import com.ojale.pranav.camelmicroserviceb.model.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyCurrencyExchangeProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyCurrencyExchangeProcessor.class);

    public void processMessage(CurrencyExchange currencyExchange){
        LOGGER.info("Do some processing with currencyExchange.getConversionMultiple() value which is {}",
            currencyExchange.getConversionMultiple());
    }
}
