package com.winfirst.item;

import com.winfirst.inventory.InventoryItem;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Item implements InventoryItem {

    private boolean stackable;
    protected BufferedImage[] texture;
    private float x, y;

    public Item(float x, float y, BufferedImage[] texture){
        stackable = false;
        this.texture = texture;
        this.x = x;
        this.y = y;
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

    public float getX(){
        return this.x;
    }

    public void setX(float x){
        this.x = x;
    }

    public float getY(){
        return this.y;
    }

    public void setY(float y){
        this.y = y;
    }
}
