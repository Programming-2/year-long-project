package com.winfirst.inventory;

import com.winfirst.item.Item;

import java.util.ArrayList;

public class Inventory {

    private Item[] inventory;
    private int invSize = 0;
    private int nextEmptyPos;

    public Inventory(final int invSize) {
        this.invSize = invSize;
        inventory = new Item[invSize];
        nextEmptyPos = 0;
    }

    public void addItem(Item item){
        findEmptySpace();
        if(nextEmptyPos != -1)
            inventory[nextEmptyPos] = item;
    }

    public void addItem(Item item, int index){
        inventory[index] = item;
    }

    public void removeItem(int index){
        inventory[index] = null;
        findEmptySpace();
    }

    public void findEmptySpace(){
        for(int i = 0; i < inventory.length; i++){
            if(isEmpty(i)) {
                nextEmptyPos = i;
                return;
            }
        }
        nextEmptyPos = -1;
    }

    public InventoryItem getItem(int index){
        return inventory[index];
    }

    public Item[] getInventory(){
        return inventory;
    }

    public int getInvSize(){ return invSize; }

    public boolean isEmpty(int pos){
        return inventory[pos] == null;
    }

    public void swapItems(int pos1, int pos2){
        Item temp = inventory[pos1];
        removeItem(pos1);
        inventory[pos1] = inventory[pos2];
        inventory[pos2] = temp;
    }
}
