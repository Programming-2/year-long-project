package com.winfirst.config;

public class ConfigList {

    //Start singleton utils
    private static ConfigList instance = null;

    private static ConfigList getInstance(){
        if(instance ==  null){
            return new ConfigList();
        }
        return instance;
    }
    //End singleton utils

    private ConfigList(){

    }
}
