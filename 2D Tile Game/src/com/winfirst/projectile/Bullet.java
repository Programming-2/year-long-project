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
        move();
//        super.setX((float) (((super.getX() + super.getVector().getXVol()))));
//        super.setY((float) (((super.getY() + super.getVector().getYVol()))));
        //System.out.println("X: " + super.getX() + " " + "Y: " + super.getY());
    }

    public void move() {
        if (!checkEntityCollision(super.getVector().getXVol(), 0f)) {
            moveX();
        }
        if (!checkEntityCollision(0f, super.getVector().getYVol())) {
            moveY();
        }
    }

    public void moveX() {
        if (super.getVector().getXVol() > 0) {//Moving right
            int tx = (int) (x + super.getVector().getXVol() + bounds.x + bounds.width) / Tile.TILEWIDTH;

            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                super.setX((float) (((super.getX() + super.getVector().getXVol()))));
            } else {
                super.getHandler().getEntityManager().removeEntity(this);
            }

        } else if (super.getVector().getXVol() < 0) {//Moving left
            int tx = (int) (x + super.getVector().getXVol() + bounds.x) / Tile.TILEWIDTH;

            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                super.setX((float) (((super.getX() + super.getVector().getXVol()))));
            } else {
                super.getHandler().getEntityManager().removeEntity(this);
            }
        }
    }

    public void moveY() {
        if (super.getVector().getYVol() < 0) {//Up
            int ty = (int) (y + super.getVector().getYVol() + bounds.y) / Tile.TILEHEIGHT;

            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                super.setY((float) (((super.getY() + super.getVector().getYVol()))));
            } else {
                super.getHandler().getEntityManager().removeEntity(this);
            }

        } else if (super.getVector().getYVol() > 0) {//Down
            int ty = (int) (y + super.getVector().getYVol() + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                super.setY((float) (((super.getY() + super.getVector().getYVol()))));
            } else {
                super.getHandler().getEntityManager().removeEntity(this);
            }
        }
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }
//        if (checkEntityCollision(super.getVector().getXVol(), super.getVector().getYVol())) {
//            super.getHandler().getEntityManager().removeEntity(this);
//        } else if(handler.getWorld().getTile((int) (super.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, (int) (super.getY() + bounds.y) / Tile.TILEHEIGHT).isSolid()) {
//            super.getHandler().getEntityManager().removeEntity(this);
//        }

    @Override
    public boolean checkEntityCollision(float xOffset, float yOffset) {
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this) || e instanceof Bullet) {
                continue;
            } else if(e.equals(super.getHandler().getEntityManager().getPlayer())) {
                continue;
            }
            if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(xOffset, yOffset))) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(super.getImage(), (int) super.getX(), (int) super.getY(), null);
    }
}
