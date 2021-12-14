package com.group11.util;

import sun.misc.BASE64Decoder;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.io.*;

public class FormatUtils {

    /**
     * Convert files to byte[] format data
     * @param file
     * @return byte[]
     */
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

    //  bytes[] transfer Image
    public static void byte2image(byte[] data,String path){
        File tempFile = new File(path);
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdirs();
        }
        if(data.length<3||path.equals("")) return;
        try{
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
//            System.out.println("Make Picture success,Please find image in " + path);
        } catch(Exception ex) {
//            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
    }

    // Image transfer bytes[]
    public static byte[] image2byte(String path){
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }

    // base64 to Image
    public static boolean base64StrToImage(String imgStr, String path) {
        if (imgStr == null)
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Decrypt
            byte[] b = decoder.decodeBuffer(imgStr);
            // Data processing
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            // If the folder does not exist, it will be created automatically
            File tempFile = new File(path);
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(tempFile);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
