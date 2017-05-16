package com.winfirst.projectile;

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
        super.setX((float) (((super.getX() + super.getVector().getXVol()))));
        super.setY((float) (((super.getY() + super.getVector().getYVol()))));
        //System.out.println("X: " + super.getX() + " " + "Y: " + super.getY());
        onCollision();
    }

    public void onCollision() {
        if (checkEntityCollision(super.getVector().getXVol(), super.getVector().getYVol()) || handler.getWorld().getTile((int)(super.getX()), (int)(super.getY())).isSolid()) {
            super.getHandler().getEntityManager().removeEntity(this);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(super.getImage(), (int) super.getX(), (int) super.getY(), null);
    }
}
