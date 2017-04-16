package com.winfirst.inventory;

import com.winfirst.item.Item;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public void addItem(Item item){
        inventory.add(item);
    }

    public InventoryItem getItem(int index){
        return inventory.get(index);
    }
}
