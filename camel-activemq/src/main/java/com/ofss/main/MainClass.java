package com.ofss.main;

import javax.jms.ConnectionFactory;

import com.ofss.jdbc.jdbcUtils;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.ofss.route.SimpleRouteBuilder;


import java.sql.*;

public class MainClass {

    public static void main(String[] args) {

        try{
            Connection conn = jdbcUtils.getConnection();
            System.out.println("Connected to MSSQL!!");
        } catch (Exception e) {
            System.out.println("Oops!! Can't to msssql");
            e.printStackTrace();
        }

        SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();

        //configure jms component
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");

        try(CamelContext ctx = new DefaultCamelContext();){

        // adding the JMS component to the CamelContext.
        ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        
            try {
                ctx.addRoutes(routeBuilder);
                ctx.start();
                Thread.sleep(5 * 60 * 1000);
                ctx.stop();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
