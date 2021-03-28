package com.ojale.pranav.camelmicroserviceb.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("rabbitmq://localhost:5672/pranavoj?queue=my-rabbitmq-queue&autoDelete=false")
                .log("${body}")
                .to("log:received-message-from-activemq");
    }
}
