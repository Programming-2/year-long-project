package com.winfirst.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    private Logger(){
        if(!file.exists()){
            try {
                file = new File(path);

                if(!file.exists()) {
                    file.createNewFile();
                }

                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                bw.write("Writer Initialized");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Logger has crashed");
            }
        }

    }

    public void write(String msg){
        try {
            bw.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPath(){
        return path;
    }

    //Should only be set once
    public static void setPath(String inpPath){
        if(path == null){
            path = inpPath;
        }
    }

}
