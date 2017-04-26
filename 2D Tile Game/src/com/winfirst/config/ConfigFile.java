package com.winfirst.config;

import com.winfirst.logging.Logger;

import java.io.*;
import java.util.ArrayList;

public class ConfigFile {

    private String file;

    private ArrayList<String> fileAsList;

    public ConfigFile(String file){
        this.file = file;
        this.fileAsList = new ArrayList<>();

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
    }
}
