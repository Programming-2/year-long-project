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
        g.drawImage(super.getIcon(), (int) (super.getHandler().getEntityManager().getPlayer().getX() - super.getHandler().getGameCamera().getxOffset()) + 13, (int) (super.getHandler().getEntityManager().getPlayer().getY() - super.getHandler().getGameCamera().getyOffset()) + 30, 32, 32, null);
    }
}
