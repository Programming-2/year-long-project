package com.winfirst.item;

import com.winfirst.utils.Handler;

import java.awt.image.BufferedImage;

public abstract class Weapon extends Item {

    private int dmg;
    private Handler handler;

    public Weapon(Handler handler, BufferedImage icon, int dmg) {
        super(0 , 0, icon);
        this.dmg = dmg;
        this.handler = handler;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public Handler getHandler(){
        return handler;
    }
}
