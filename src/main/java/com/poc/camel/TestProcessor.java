package com.poc.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by intelligrape on 13/9/16.
 */
public class TestProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("hkfhdfdshfksdhjfkhjd");
        System.out.println(exchange.getIn().getBody());
        exchange.getOut().setBody(exchange.getIn().getBody());
    }
}
