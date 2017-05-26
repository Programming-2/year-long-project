package com.winfirst.entity;

import com.winfirst.projectile.Projectile;
import com.winfirst.utils.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;

    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        //Creates collision bounds
        bounds = new Rectangle(0, 0, width, height);
    }

    //Abstract tick
    public abstract void tick();

    //Abstract render
    public abstract void render(Graphics g);

    //Checks for entity collision
    public boolean checkEntityCollision(float xOffset, float yOffset) {
        //Loops through all entities in the world
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this) || e instanceof Projectile) {
                continue;
            } else if(this instanceof Projectile && e instanceof Player) {
                continue;
            }
            //Returns true if two bounds intersect
            if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(xOffset, yOffset))) {
                return true;
            }
        }

        return false;
    }

    //Returns collision bounds
    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Handler getHandler() { return handler; }

}
