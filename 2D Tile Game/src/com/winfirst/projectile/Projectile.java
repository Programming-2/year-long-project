package com.winfirst.projectile;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Projectile {

    private Vector2D vector;
    private BufferedImage image;
    private float x, y;

    public Projectile(float startX, float startY, BufferedImage image, Vector2D vector) {
        this.vector = vector;
        this.image = image;
        this.x = startX;
        this.y = startY;
    }

    public Vector2D getVector() {
        return this.vector;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public BufferedImage getImage(){
        return image;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }
}
