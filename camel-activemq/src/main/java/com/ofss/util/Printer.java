package com.ofss.util;

import com.ofss.model.DataPOJO;
import com.ofss.model.MappedOutputPOJO;
import com.ofss.model.OutputPOJO;

public class Printer {

    public static void inputPrinter(DataPOJO data) {

        //print values from data object
        System.out.println("--------------------");
        System.out.println("INPUT OBJECT");
        System.out.println("--------------------");
        System.out.println("CustomerId: " + data.getCustomerId());
        System.out.println("CustomerName: " + data.getCustomerName());
        System.out.println("Address -> address1: " + data.getAddress().getAddress1());
        System.out.println("Address -> address2: " + data.getAddress().getAddress2());

        System.out.println("--------------------");
    }

    public static void outputPrinter(OutputPOJO response) {

        //print values from response object
        System.out.println("--------------------");
        System.out.println("OUTPUT OBJECT");
        System.out.println("--------------------");
        System.out.println("CustomerId: " + response.getCustomerId());
        System.out.println("CustomerName: " + response.getCustomerName());
        System.out.println("Code: " + response.getCode());
        System.out.println("Address -> address1: " + response.getAddress().getAddress1());
        System.out.println("Address -> address2: " + response.getAddress().getAddress2());

        System.out.println("--------------------");

    }

    public static void mappedOutputPrinter(MappedOutputPOJO mappedOutput) {

        //print values from transformed object
        System.out.println("--------------------");
        System.out.println("TRANSFORMED OBJECT");
        System.out.println("--------------------");
        System.out.println("CustomerId: " + mappedOutput.getCustomerId());
        System.out.println("CustomerName: " + mappedOutput.getCustomerName());
        System.out.println("Code: " + mappedOutput.getCode());
        System.out.println("Customer Address1: " + mappedOutput.getCustomerAddress1());
        System.out.println("Customer Address2: " + mappedOutput.getCustomerAddress2());

        System.out.println("--------------------");

    }
}
