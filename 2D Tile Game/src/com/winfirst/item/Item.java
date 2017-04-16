package com.winfirst.item;

import com.winfirst.inventory.InventoryItem;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Item implements InventoryItem {

    public static ArrayList<Item> itemList = new ArrayList<>();

    private boolean stackable;
    protected BufferedImage texture;

    public Item(BufferedImage texture){
        stackable = false;
        this.texture = texture;
        itemList.add(this);
    }

    @Override
    public int getNumItems(){
        return 0;
    }

    @Override
    public Item getItem(){
        return this;
    }

    public boolean isStackable(){
        return stackable;
    }

    protected void setStackable(boolean stackable) {
        this.stackable = stackable;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
