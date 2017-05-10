package com.winfirst.projectile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends Projectile{

    private int dmg;

    public Bullet(int startX, int startY, BufferedImage image, Vector2D vect, int dmg){
        super(startX, startY, image, vect);
        this.dmg = dmg;
    }
        
    @Override
    public void tick() {
        super.setX((float) (super.getX() + super.getVector().getX()));
        super.setY((float) (super.getY() + super.getVector().getY()));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(super.getImage(), (int) super.getX(), (int) super.getY(), null);
    }
}
