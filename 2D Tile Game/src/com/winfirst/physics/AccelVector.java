package com.winfirst.physics;

import com.winfirst.utils.Handler;

public class AccelVector extends Vector2D {

    private float magnitude, xDir, yDir;
    private Handler handler;


    public AccelVector(float xDir, float yDir, float magnitude, Handler handler) {
        super(xDir, yDir, magnitude, handler);
    }
}
