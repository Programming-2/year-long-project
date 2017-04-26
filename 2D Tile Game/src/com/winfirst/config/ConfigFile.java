package com.winfirst.config;

import com.winfirst.logging.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConfigFile {

    private String file;

    private ArrayList<String> fileAsList;
    private Map<String, Object> values;

    public ConfigFile(String file){
        this.file = file;
        this.fileAsList = new ArrayList<>();
        this.values = new HashMap<>();

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
        String name = a.substring(0, a.indexOf(':'));
        String value = a.substring(a.indexOf(':'));

        name.trim();
        value.trim();

        values.put(name, value);
    }
}
