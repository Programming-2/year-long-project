package com.winfirst.projectile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet extends Projectile{

    private int dmg;
    private int rotation = 0;

    public Bullet(BufferedImage image, Vector2D vect, int dmg){
        super(image, vect);
        this.dmg = dmg;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
