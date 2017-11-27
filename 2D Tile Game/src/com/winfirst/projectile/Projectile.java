package com.winfirst.projectile;

import com.winfirst.entity.Entity;
import com.winfirst.physics.VelocityVector;
import com.winfirst.utils.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Projectile extends Entity{

    private VelocityVector vector;
    private BufferedImage image;

    public Projectile(Handler h, float startX, float startY, BufferedImage image, VelocityVector vector, int width, int height) {
        super(h, startX, startY, width, height);
        this.vector = vector;
        this.image = image;
    }

    public VelocityVector getVector() {
        return this.vector;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public BufferedImage getImage(){
        return image;
    }
}
