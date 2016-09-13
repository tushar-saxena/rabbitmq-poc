package com.poc.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Send {

    public static void main(String args[]) throws Exception {

        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            public void configure() {
                System.out.println("putting message.............");
                from("timer://simple?period=1000").setBody().simple("Test message: ${id}")
                        .process(new TestProcessor())
                    .to("rabbitmq://localhost:5672/abc?queue=hello&username=guest&password=guest&vhost=/&exchangeType=direct&autoDelete=false");
            }
        });
        context.start();
    }

}
