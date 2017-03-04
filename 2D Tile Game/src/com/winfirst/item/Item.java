package com.winfirst.item;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Item {
	
	private BufferedImage icon;
	private int dmg;
	
	public Item(BufferedImage icon, int dmg){
		this.icon = icon;
		this.dmg = dmg;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public int getDmg(){
		return this.dmg;
	}
	
	public BufferedImage getIcon(){
		return this.icon;
	}
}
