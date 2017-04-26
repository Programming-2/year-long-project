package com.winfirst.config;

public class Config <T>{

    private T t;
    private String name;

    private T value;

    public Config(String name){
        this.name = name;
        readConfig();
    }

    private void readConfig(){

    }

}
