package com.winfirst.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    //Start singleton utils
    private static Logger instance = null;

    public static Logger getInstance(){
        if(instance == null){
            instance =  new Logger();
        }
        return instance;
    }
    //End singleton utils

    private static String path = null;
    private BufferedWriter bw;
    private File file;
    private FileWriter fw;
    private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

    private Logger(){
        try {
            Date date  = new Date();

            file = new File(path +  sdf.format(date) + ".txt");

            System.out.println(file);

            if(!file.exists()) {
                   file.createNewFile();
            }

            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            write("Writer Initialized");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Logger has crashed");
        }

    }

    public void write(String msg){
        try {
            bw.write(msg + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            if(bw == null){
                System.out.println("Its Null");
            }
            write("Closing");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Logger Closed");
    }

    public static String getPath(){
        return path;
    }

    //Should only be set once
    public static void setPath(String inpPath) {
        if (path == null) {
            path = inpPath;
        }
    }
}
