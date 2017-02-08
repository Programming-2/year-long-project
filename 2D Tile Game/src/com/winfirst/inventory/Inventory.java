package com.winfirst.inventory;

import java.util.HashMap;
import java.util.Map;

import com.winfirst.tile.Tile;

public class Inventory {
	
	private Map<Tile, Integer> inventory;
	
	public Inventory(){
		inventory = new HashMap<>();
	}
	
	public void addTile(Tile tile){
		inventory.put(tile, 0);
	}
	
	public void addItem(Tile tile){
		inventory.put(tile, inventory.get(tile) + 1);
	}
	
	public void setAmt(Tile tile, int value){
		inventory.put(tile, value);
	}
	
	public int getAmt(Tile tile){
		return inventory.get(tile);
	}
}
