package com.ojale.pranav.camelmicroserviceb.routes;

import com.ojale.pranav.camelmicroserviceb.model.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class RabbitMqXmlReceiverRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("rabbitmq://localhost:5672/pranavoj-xml?queue=my-rabbitmq-xml-queue&autoDelete=false")
                .unmarshal()
                .jacksonxml(CurrencyExchange.class)
                .to("log:received-message-xml-from-rabbitmq");
    }
}
