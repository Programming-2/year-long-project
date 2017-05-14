package com.winfirst.item;

import com.winfirst.utils.Handler;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class NetCannon extends Weapon{

    public NetCannon (Handler handler, BufferedImage icon, int dmg){
        super(handler, icon, dmg);
    }

    @Override
    public void tick() {
        if(super.getHandler().getGame().getKeyManager().e){
            //Shoot
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(super.getIcon(), (int) super.getHandler().getEntityManager().getPlayer().getX() + 10, (int) super.getHandler().getEntityManager().getPlayer().getY() + 10, 32, 32, null);
    }
}
