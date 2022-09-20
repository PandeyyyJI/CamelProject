package com.ofss.Processors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ofss.Mapper.IDataMapperImpl;
import com.ofss.jdbc.jdbcUtils;
import com.ofss.model.DataPOJO;
import com.ofss.model.MappedOutputPOJO;
import com.ofss.model.OutputPOJO;
import com.ofss.util.CorrId;
import com.ofss.util.Printer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.UUID;

public class SrcToTargetProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        // Setting JMSCorrelationID
        exchange.getIn().setHeader("JMSCorrelationID", CorrId.getCorrId());
        exchange.getIn().setHeader("JMSReplyTo", "TargetQueueAck");

        System.out.println("\nDATA FROM SOURCE QUEUE SENT TOWARDS TARGET QUEUE WITH :- ");

        System.out.println("CorrelationID: " + exchange.getIn().getHeader("JMSCorrelationID"));
        System.out.println("JMSReplyTo: " + exchange.getIn().getHeader("JMSReplyTo") + "\n");

        UUID HermesId = UUID.randomUUID();
        UUID TrackingId = UUID.randomUUID();

        //Inserting Data into Summary table
        jdbcUtils.insertIntoSummary(exchange, HermesId);

        //Inserting Data into AuditTracking table
        jdbcUtils.insertIntoAudit(exchange, TrackingId, HermesId);

        //Mapping the data from source
        ObjectMapper mapper = new ObjectMapper();

        //converting the json into DataPOJO object
        DataPOJO data = mapper.readValue(exchange.getIn().getBody(String.class), DataPOJO.class);

        //Printing the Input Object
        Printer.inputPrinter(data);

        //adding values from dataPOJO to outputPOJO
        OutputPOJO response = new OutputPOJO();
        response.setCustomerId(data.getCustomerId());
        response.setCustomerName(data.getCustomerName());
        response.setCode(jdbcUtils.getCodeFromSequence());
        response.setAddress(data.getAddress());

        //Printing the Output Object
        Printer.outputPrinter(response);

        //adding values to MappedOutputPOJO using MAPSTRUCT
        IDataMapperImpl mapstructObject = new IDataMapperImpl();

        //Converting DataPOJO object to MappedOutputPOJO object using Mapstruct Generated Class
        MappedOutputPOJO mappedOutput = mapstructObject.OutputToMappedOutputDto(response);

        //Printing the MappedOutputPrinter
        Printer.mappedOutputPrinter(mappedOutput);

        // Mapper to transform MappedOutputPOJO object to Json
        ObjectMapper TransformMapper = new ObjectMapper();

        //to print string in JSON format
        TransformMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String outputJson = TransformMapper.writeValueAsString(mappedOutput);

        // setting the transformed body as the body of exchange object
        exchange.getIn().setBody(outputJson);

        //Updating the Payload in the DB
        jdbcUtils.updatePayload(exchange, TrackingId );

        System.out.println("--------------------");
        System.out.println("TRANSFORMED JSON OBJECT");
        System.out.println("--------------------");
        System.out.println(outputJson);
        System.out.println("-------------------------------");

    }
}
