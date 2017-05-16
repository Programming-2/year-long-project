package com.winfirst.item;

import com.winfirst.utils.Handler;

import java.awt.*;
import java.util.ArrayList;

public class ItemManager {

    private ArrayList<Item> items;
    private Handler handler;

    public ItemManager(Handler handler){
        items = new ArrayList<>();
        this.handler = handler;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void tick(){
        items.forEach(e -> e.tick());
        //System.out.println("Item Tick");
    }

    public void render(Graphics g){
        items.forEach(e -> e.render(g));
        //System.out.println("Item Render");
    }

    public String toString(){
        return new Integer(items.size()).toString();
    }
}
