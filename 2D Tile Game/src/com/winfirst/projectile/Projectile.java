package com.winfirst.projectile;

import com.winfirst.entity.Entity;
import com.winfirst.utils.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Projectile extends Entity{

    private Vector2D vector;
    private BufferedImage image;

    public Projectile(Handler h, float startX, float startY, BufferedImage image, Vector2D vector, int width, int height) {
        super(h, startX, startY, width, height);
        this.vector = vector;
        this.image = image;
    }

    public Vector2D getVector() {
        return this.vector;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void onCollision();

    public BufferedImage getImage(){
        return image;
    }
}
