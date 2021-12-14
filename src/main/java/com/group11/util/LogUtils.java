package com.group11.util;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogUtils {

    public static String root = System.getProperty("user.dir") + File.separatorChar + "src" + File.separatorChar +
            "main" + File.separatorChar;

    /**
     * Add logs to log file according to info
     * @param info
     */
    public static void logToFile(String info) {
        info = "[" + TimeUtils.getCurrentTimeStr() + "] " + info;
        FileWriter fw = null;
        try {
            // If the file exists, append the content; if the file does not exist, create the file
            File f = new File(root + "log.log");
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(info);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
