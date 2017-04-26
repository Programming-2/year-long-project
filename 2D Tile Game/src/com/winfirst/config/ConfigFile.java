package com.winfirst.config;

import com.winfirst.logging.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConfigFile {

    private String file;

    private ArrayList<String> fileAsList;
    private Map<String, Object> value;

    public ConfigFile(String file){
        this.file = file;
        this.fileAsList = new ArrayList<>();
        this.value = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(file)));
            fileAsList.add(br.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Logger.getInstance().write("Configs have crashed");
        } catch (IOException e) {
            e.printStackTrace();
            Logger.getInstance().write("Configs have crashed");
        }

        fillMap();
    }

    private void fillMap(){
        fileAsList.forEach(a -> getValue(a));
    }

    private void getValue(String a){
        
    }
}
