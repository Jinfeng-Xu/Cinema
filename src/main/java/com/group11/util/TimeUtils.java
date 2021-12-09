package com.group11.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    private static SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getCurrentTimeStr(){
        long starttime  = System.currentTimeMillis();
        String datetime = df.format(new Date(starttime));
        return datetime;
    }
}
