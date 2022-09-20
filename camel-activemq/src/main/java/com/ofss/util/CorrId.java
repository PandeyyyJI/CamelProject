package com.ofss.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CorrId {

    public static String getCorrId(){

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyhhmmss");

        String strDate = dateFormat.format(date);
        System.out.println("Date Time String " + strDate);

        return strDate;

    }



}
