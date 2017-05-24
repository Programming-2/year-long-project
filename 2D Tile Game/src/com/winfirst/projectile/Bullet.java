package com.winfirst.projectile;

import com.winfirst.entity.Entity;
import com.winfirst.tile.Tile;
import com.winfirst.utils.Handler;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends Projectile{

    private int dmg;

    public Bullet(Handler h, int startX, int startY, BufferedImage image, Vector2D vect, int dmg){
        super(h, startX, startY, image, vect, 4, 4);
        this.dmg = dmg;
    }

    @Override
    public void tick() {
        super.getVector().tick();
        super.setX(super.getVector().getX());
        super.setY(super.getVector().getY());

        if(x < 0 || y < 0 || x > 45 * 64 || y > 32 * 64){
            handler.getEntityManager().removeEntity(this);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(super.getImage(), (int) super.getX(), (int) super.getY(), null);
    }
}
