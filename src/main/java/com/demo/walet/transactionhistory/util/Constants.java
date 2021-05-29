package com.demo.walet.transactionhistory.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class Constants {
    public static Date getCurrentDate(){
        return Calendar.getInstance().getTime();
    }
    public Timestamp getCurrentTimeStamp(){
        return new Timestamp(getCurrentDate().getTime());
    }
}
