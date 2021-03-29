package com.ojale.pranav.camelmicroserviceb.routes;

import com.ojale.pranav.camelmicroserviceb.model.CurrencyExchange;
import com.ojale.pranav.camelmicroserviceb.processor.MyCurrencyExchangeProcessor;
import com.ojale.pranav.camelmicroserviceb.transformer.MyCurrencyExchangeTransformer;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMqReceiverRouter extends RouteBuilder {

    @Autowired
    private MyCurrencyExchangeProcessor myCurrencyExchangeProcessor;

    @Autowired
    private MyCurrencyExchangeTransformer myCurrencyExchangeTransformer;

    @Override
    public void configure() throws Exception {

        // JSON
        // CurrencyExchange
        // { "id": 1000, "from": "USD", "to": "INR", "conversionMultiple": 70 }

        from("rabbitmq://localhost:5672/pranavoj?queue=my-rabbitmq-queue&autoDelete=false")
                .unmarshal()
                .json(JsonLibrary.Jackson, CurrencyExchange.class)
                .bean(myCurrencyExchangeProcessor)
                .bean(myCurrencyExchangeTransformer)
                .log("${body}")
                .to("log:received-message-from-activemq");
    }
}
