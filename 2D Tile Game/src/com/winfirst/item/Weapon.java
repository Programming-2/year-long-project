package com.winfirst.item;

import java.awt.image.BufferedImage;

public abstract class Weapon extends Item{
	
	private int dmg;

	public Weapon(BufferedImage icon, int dmg){
		super(icon);
		this.dmg = dmg;
	}
	
	public void setDmg(int dmg){
		this.dmg = dmg;
	}
	
	public int getDmg(){
		return dmg;
	}
}
