package com.ofss.Processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class FileToSrcQueueProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("\nDATA SENT FROM INPUT FOLDER TOWARDS SOURCE QUEUE");
        System.out.println("__________________________________________________________________________________________________________");



    }
}
