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
    private static Map<String, Object> values; //Will be changed to not be static

    public ConfigFile(String file){
        this.file = file;
        this.fileAsList = new ArrayList<>();
        this.values = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(file)));
            String line = br.readLine();
            while(line != null) {
                if(line.substring(0, 2).equals("//")) {
                    line = br.readLine();
                    continue;
                }
                fileAsList.add(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Logger.getInstance().write("Configs have crashed");
        } catch (IOException e) {
            e.printStackTrace();
            Logger.getInstance().write("Configs have crashed");
        }


        fillMap();
        values.forEach((k, v) -> System.out.println(v));
    }

    private void fillMap(){
        fileAsList.forEach(a -> splitConfig(a));
    }

    private void splitConfig(String a){
        String name = a.substring(0, a.indexOf(':'));
        String value = a.substring(a.indexOf(':') + 2);

        name.trim();
        value.trim();

        values.put(name, value);
    }

    public static Object getValue(String name){
        return values.get(name);
    }

    public Map<String, Object> getValues(){
        return values;
    }
}
