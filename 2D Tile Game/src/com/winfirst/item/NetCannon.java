package com.winfirst.item;

import com.winfirst.projectile.Bullet;
import com.winfirst.projectile.Vector2D;
import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class NetCannon extends Weapon{

    public NetCannon (Handler handler, BufferedImage icon, int dmg){
        super(handler, icon, 10, 10, dmg);
    }

    @Override
    public void tick() {
        if (super.getHandler().getKeyManager().space){
            System.out.println(super.getHandler().getMouseManager().getMouseX());
            System.out.println(super.getHandler().getMouseManager().getMouseY());
            //Needs mouse math
            int mouseX = (super.getHandler().getMouseManager().getMouseX()) - (int) ((super.getX() - super.getHandler().getGameCamera().getxOffset()));
            int mouseY = (super.getHandler().getMouseManager().getMouseY()) - (int) ((super.getY() - super.getHandler().getGameCamera().getyOffset()));

            super.getHandler().getEntityManager().addEntity(new Bullet(super.getHandler(), (int) (super.getX() - super.getHandler().getGameCamera().getxOffset()), (int) (super.getY() - super.getHandler().getGameCamera().getyOffset()), Assets.bullet, new Vector2D(mouseX, mouseY, 10), 4));
            System.out.println(super.getX() + " " + super.getY());
        }

        super.setX((super.getHandler().getEntityManager().getPlayer().getX()) + 10);
        super.setY((super.getHandler().getEntityManager().getPlayer().getY()) + 30);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(super.getIcon(), (int) (super.getX() - super.getHandler().getGameCamera().getxOffset()), (int) (super.getY() - super.getHandler().getGameCamera().getyOffset()), 32, 32, null);
    }
}
