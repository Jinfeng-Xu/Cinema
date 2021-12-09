package com.group11.util;

import com.group11.pojo.TimeTable;

import java.io.*;

public class PersistentUtils {

    public static String root = System.getProperty("user.dir") + File.separatorChar + "src" + File.separatorChar +
            "main" + File.separatorChar + "persistent" +  File.separatorChar;

    /*
     * 将对象保存到文件中
     */
    public static void saveObjToFile(Object p, String fileName){
        try {
            //写对象流的对象
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(p);                 //将Person对象p写入到oos中
            oos.close();                        //关闭文件流
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * 从文件中读出对象，并且返回对象
     */
    public static Object getObjFromFile(String fileName){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            Object object = ois.readObject();              //读出对象
            return object;                                       //返回对象
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 通过screen id get Persistent Screen
     */
    public static TimeTable getTimeTableById(String timeTableId){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(root + "TimeTable" + timeTableId + ".txt"));
            Object object = ois.readObject();              //读出对象
            return (TimeTable) object;                                       //返回对象
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            return null;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            return null;
        }
    }

    /*
     * 将Screen保存到文件中
     */
    public static void saveTimeTableToFile(TimeTable timeTable, String timeTableId){
        try {
            //写对象流的对象
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(root + "TimeTable" + timeTableId + ".txt"));
            oos.writeObject(timeTable);                 //将Person对象p写入到oos中
            oos.close();                        //关闭文件流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
