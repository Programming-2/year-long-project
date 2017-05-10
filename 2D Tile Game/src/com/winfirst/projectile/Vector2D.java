package com.winfirst.projectile;

public class Vector2D {

    private double x, y, speed, angle;

    public Vector2D(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.angle = Math.atan2(y, x);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAngle(){return angle;}

}
