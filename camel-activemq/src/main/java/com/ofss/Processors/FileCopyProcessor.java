package com.ofss.Processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileCopyProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("\nCOPYING FILE FROM C:\\camel\\input TO C:\\camel\\output");
    }
}
