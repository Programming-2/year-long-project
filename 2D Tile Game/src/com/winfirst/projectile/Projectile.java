package com.winfirst.projectile;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Projectile {

    private Vector2D vector;
    private BufferedImage image;

    public Projectile(BufferedImage image, Vector2D vector) {
        this.vector = vector;
        this.image = image;
    }

    public Vector2D getVector() {
        return this.vector;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
