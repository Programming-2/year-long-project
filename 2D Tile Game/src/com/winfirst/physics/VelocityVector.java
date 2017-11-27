package com.winfirst.physics;

import com.winfirst.utils.Handler;

public class VelocityVector extends Vector2D {

    private float x, y, speed, angle, xVol, yVol;
    private Handler handler;

    public VelocityVector(float x, float y, float xDir, float yDir, float speed, Handler handler) {
        super(xDir, yDir, speed, handler);
        this.x = x;
        this.y = y;
    }

    public void tick(){
        x += this.getXVol();
        y += this.getYVol();
    }

    public float getX() {
        return x - this.getHandler().getGameCamera().getxOffset();
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y  - this.getHandler().getGameCamera().getyOffset();
    }

    public void setY(float y) {
        this.y = y;
    }

}
