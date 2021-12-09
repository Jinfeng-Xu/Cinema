package com.group11.util;

import java.io.*;

public class FormatUtils {

    public static byte[] transferFileToByte(File file){
        FileInputStream fis;
        byte[] buffer = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int count;
            while( (count = fis.read(b)) != -1){
                bos.write(b, 0, count);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

}
