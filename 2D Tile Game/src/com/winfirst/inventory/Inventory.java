package com.winfirst.inventory;

import java.util.HashMap;
import java.util.Map;

import com.winfirst.tile.Tile;

public class Inventory {
	
	private Map<Tile, Integer> inventory;
	
	public Inventory(){
		inventory = new HashMap<>();
	}
}
