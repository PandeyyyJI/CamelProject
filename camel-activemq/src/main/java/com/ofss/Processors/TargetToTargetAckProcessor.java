package com.ofss.Processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class TargetToTargetAckProcessor implements Processor {


    @Override
    public void process(Exchange exchange) throws Exception {

        //Setting CorrID as the body from target to targetAck.
        exchange.getIn().setBody(exchange.getIn().getHeader("JMSCorrelationID"));

        System.out.println("\nDATA SENT FROM TARGET TO TARGET ACK WITH:-");
        System.out.println("Body: " + exchange.getIn().getBody());
        System.out.println("__________________________________________________________________________________________________________");


    }
}
