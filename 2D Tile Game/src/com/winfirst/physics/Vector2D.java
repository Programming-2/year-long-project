package com.winfirst.physics;

import com.winfirst.utils.Handler;

public class Vector2D {

    private float magnitude, angle, xVol, yVol;
    private Handler handler;

    public Vector2D(float xDir, float yDir, float magnitude, Handler handler) {
        this.magnitude = magnitude;
        this.angle = (float)(Math.atan2(yDir, xDir));
        System.out.println(Math.toDegrees(angle));
        xVol = (float)((magnitude) * Math.cos(angle));
        yVol = (float)((magnitude) * Math.sin(angle));
        this.handler = handler;
    }

    public float getXVol(){
        return xVol;
    }

    public float getYVol(){
        return yVol;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(float speed) {
        this.magnitude = magnitude;
    }

    public Handler getHandler() { return handler; }

    public float getAngle(){return angle;}


}
