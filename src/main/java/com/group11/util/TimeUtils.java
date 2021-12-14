package com.group11.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TimeUtils {

    private static SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getCurrentTimeStr(){
        long starttime  = System.currentTimeMillis();
        String datetime = df.format(new Date(starttime));
        return datetime;
    }

    // java.time.LocalDate --> java.util.Date
    public static Date LocalDateToUpdate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
        return date;
    }

}
