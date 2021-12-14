package com.group11.util;

import com.group11.pojo.TimeTable;

import java.io.*;

public class PersistentUtils {

    public static String root = System.getProperty("user.dir") + File.separatorChar + "src" + File.separatorChar +
            "main" + File.separatorChar + "persistent" +  File.separatorChar;

    /*
     * Save the object to a file
     */
    public static void saveObjToFile(Object p, String fileName){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(p);
            oos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * Read object from file and return object
     */
    public static Object getObjFromFile(String fileName){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            Object object = ois.readObject();
            return object;
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
     * Get Persistent Screen object by screen_id
     */
    public static TimeTable getTimeTableById(String timeTableId){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(root + "TimeTable" + timeTableId + ".txt"));
            Object object = ois.readObject();
            return (TimeTable) object;
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
     * Save the Screen object to a file
     */
    public static void saveTimeTableToFile(TimeTable timeTable, String timeTableId){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(root + "TimeTable" + timeTableId + ".txt"));
            oos.writeObject(timeTable);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
