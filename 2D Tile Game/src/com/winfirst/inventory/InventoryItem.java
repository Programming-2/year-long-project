package com.winfirst.inventory;

public interface InventoryItem {

    int getNumItems(); //Needed?

    InventoryItem getItem(); //Change to Item

    boolean isStackable();
}
