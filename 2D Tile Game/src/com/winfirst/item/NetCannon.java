package com.winfirst.item;

import com.winfirst.projectile.Bullet;
import com.winfirst.projectile.Vector2D;
import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class NetCannon extends Weapon{

    private int time = 0;
    private static final int RELOAD_TIME = 10;

    public NetCannon (Handler handler, BufferedImage icon, int dmg){
        super(handler, icon, 10, 10, dmg);
    }

    @Override
    public void tick() {
        if (super.getHandler().getKeyManager().space && time == 0){
            int mouseX = (super.getHandler().getMouseManager().getMouseX()) - (int) ((super.getX() - super.getHandler().getGameCamera().getxOffset()));
            int mouseY = (super.getHandler().getMouseManager().getMouseY()) - (int) ((super.getY() - super.getHandler().getGameCamera().getyOffset()));
            super.getHandler().getEntityManager().addEntity(new Bullet(super.getHandler(), (int) (super.getX() - super.getHandler().getGameCamera().getxOffset()), (int) (super.getY() - super.getHandler().getGameCamera().getyOffset()), Assets.bullet, new Vector2D(this.getX(), this.getY(), mouseX, mouseY, 10, this.getHandler()), 4));
            super.getHandler().getEntityManager().addEntity(new Bullet(super.getHandler(), (int) (super.getX() - super.getHandler().getGameCamera().getxOffset()), (int) (super.getY() - super.getHandler().getGameCamera().getyOffset()), Assets.bullet, new Vector2D(this.getX(), this.getY(), mouseX - 40, mouseY - 40, 10, this.getHandler()), 4));
            super.getHandler().getEntityManager().addEntity(new Bullet(super.getHandler(), (int) (super.getX() - super.getHandler().getGameCamera().getxOffset()), (int) (super.getY() - super.getHandler().getGameCamera().getyOffset()), Assets.bullet, new Vector2D(this.getX(), this.getY(), mouseX + 40, mouseY + 40, 10, this.getHandler()), 4));
            time = RELOAD_TIME;
        }

        super.setX((super.getHandler().getEntityManager().getPlayer().getX()) + 10);
        super.setY((super.getHandler().getEntityManager().getPlayer().getY()) + 30);
        if(time > 0){
            time--;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(super.getIcon(), (int) (super.getX() - super.getHandler().getGameCamera().getxOffset()), (int) (super.getY() - super.getHandler().getGameCamera().getyOffset()), 32, 32, null);
    }
}
