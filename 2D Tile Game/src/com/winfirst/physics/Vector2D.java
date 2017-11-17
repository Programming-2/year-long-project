package com.winfirst.physics;

import com.winfirst.utils.Handler;

public class Vector2D {

    private float x, y, speed, angle, xVol, yVol;
    private Handler handler;

    public Vector2D(float x, float y, float xDir, float yDir, float speed, Handler handler) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.angle = (float)(Math.atan2(yDir, xDir));
        xVol = (float)((speed) * Math.cos(angle));
        yVol = (float)((speed) * Math.sin(angle));
        this.handler = handler;
    }

    public void tick(){
        x += xVol;
        y += yVol;
    }

    public float getX() {
        return x - handler.getGameCamera().getxOffset();
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y  - handler.getGameCamera().getyOffset();
    }

    public float getXVol(){
        return xVol;
    }

    public float getYVol(){
        return yVol;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getAngle(){return angle;}

}
