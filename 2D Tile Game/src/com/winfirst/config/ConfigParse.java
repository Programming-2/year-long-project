package com.winfirst.config;

public class ConfigParse {

    public static Object parseObject(String input) throws NumberFormatException{
        if(input.substring(0, 1).equals("\"")){
            return new String(input.substring(1, input.length()-1));
        }else if(input.indexOf('.') != -1){
            return new Double(Double.parseDouble(input));
        }else{
            return new Integer(Integer.parseInt(input));
        }
    }
}
