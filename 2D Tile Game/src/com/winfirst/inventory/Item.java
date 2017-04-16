package com.winfirst.inventory;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Item implements InventoryItem{

    private boolean stackable;
    protected BufferedImage texture;

    public Item(BufferedImage texture){
        stackable = false;
        this.texture = texture;
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
