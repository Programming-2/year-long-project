package com.winfirst.inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
	
	private Map<InventoryItem, Integer> inventory;
	
	public Inventory(){
		inventory = new HashMap<>();
	}
	
	public void addTile(InventoryItem item){
		inventory.put(item, 0);
	}
	
	public void addItem(InventoryItem item){
		inventory.put(item, inventory.get(item) + 1);
	}
	
	public void setAmt(InventoryItem item, int value){
		inventory.put(item, value);
	}
	
	public int getAmt(InventoryItem item){
		return inventory.get(item);
	}
}
