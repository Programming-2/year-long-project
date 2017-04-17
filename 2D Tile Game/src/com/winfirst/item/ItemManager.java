package com.winfirst.item;

import java.awt.*;
import java.util.ArrayList;

public class ItemManager {

    //Start singleton  utils
    private static ItemManager instatance;

    public static ItemManager getInstatance(){
        if(instatance == null){
            return new ItemManager();
        }
        return instatance;
    }
    //End singleton utils

    private ArrayList<Item> items;

    private ItemManager(){
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void tick(){
        items.forEach(e -> e.tick());
    }

    public void render(Graphics g){
        items.forEach(e -> e.render(g));
    }
}
