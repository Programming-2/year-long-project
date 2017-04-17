package com.winfirst.item;

import java.awt.image.BufferedImage;

public abstract class Weapon extends Item {

    private int dmg;

    public Weapon(BufferedImage[] icon, int dmg) {
        super(0 , 0, icon);
        this.dmg = dmg;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
}
