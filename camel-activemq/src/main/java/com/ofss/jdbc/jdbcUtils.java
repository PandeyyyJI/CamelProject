package com.ofss.jdbc;

import org.apache.camel.Exchange;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

public class jdbcUtils {
    public static Connection getConnection() throws Exception{


        String url = "jdbc:sqlserver://ARYPANDE-X40-J\\SQLEXPRESS;databaseName=CamelDB;encrypt=true;trustServerCertificate=true";
        String user = "admin";
        String password = "admin";

        return DriverManager.getConnection(url, user, password);
    }

    public static void insertIntoSummary(Exchange exchange, UUID HermesId) {

        //Creating a parameterized query with '?'
        String sqlQuery = "INSERT INTO Summary VALUES(?,?)";

        //specifying primary key
        String[] pkColumns = {"HermesId"};

        try(
                //Load the driver and establish a connection
                Connection conn = jdbcUtils.getConnection();

                //Obtain the statement
                PreparedStatement pstmt=conn.prepareStatement(sqlQuery,pkColumns)
        ){

            // Extracting data from Exchange object
            String CorrId = exchange.getIn().getHeader("JMSCorrelationID", String.class);

            // Substituting the values in sqlQuery
            pstmt.setObject(1,HermesId);
            pstmt.setString(2,CorrId);

            // Executing the Query
            int updateCount = pstmt.executeUpdate();

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void insertIntoAudit(Exchange exchange, UUID TrackingId, UUID HermesId) {

        //Creating a parameterized query with '?'
        String sqlQuery = "INSERT INTO AuditTracking VALUES(?,?,?,?,?)";

        //specifying primary key
        String[] pkColumns = {"TrackingId"};

        try(
                //Load the driver and establish a connection
                Connection conn = jdbcUtils.getConnection();

                //Obtain the statement
                PreparedStatement pstmt=conn.prepareStatement(sqlQuery,pkColumns)
        ){

            // Extracting data from Exchange object
            String Payload = exchange.getIn().getBody(String.class);
            String Headers = exchange.getIn().getHeaders().toString();
            int StageId = 1;

            // Substituting the values in sqlQuery
            pstmt.setObject(1,TrackingId);
            pstmt.setObject(2,HermesId);
            pstmt.setString(3, Payload);
            pstmt.setString(4,Headers);
            pstmt.setInt(5,StageId);

            // Executing the Query
            int updateCount = pstmt.executeUpdate();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    // Add String id = TrackingId with regex that removes special characters
    public static void updatePayload(Exchange exchange, UUID TrackingId) {
        String sqlQuery = "UPDATE AuditTracking SET Payload=?, StageId=? WHERE TrackingId=?";

        //specifying primary key
        String[] pkColumns = {"TrackingId"};

        try(
                //Load the driver and establish a connection
                Connection conn = jdbcUtils.getConnection();

                //Obtain the statement
                PreparedStatement pstmt=conn.prepareStatement(sqlQuery,pkColumns)
        ){

            String Payload = exchange.getIn().getBody(String.class);
            int StageId = 2;

            pstmt.setString(1, Payload);
            pstmt.setInt(2, StageId);
            pstmt.setObject(3,TrackingId);

            // Executing the Query
            int updateCount = pstmt.executeUpdate();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCodeFromSequence() {
        String sqlQuery = "SELECT next value for codeSequence";
        String code = null;

        try(
                Connection conn = jdbcUtils.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sqlQuery)
        ) {

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                code = rs.getString(1);
            }

        } catch( Exception e) {
            e.printStackTrace();
        }

        return code;
    }

}





