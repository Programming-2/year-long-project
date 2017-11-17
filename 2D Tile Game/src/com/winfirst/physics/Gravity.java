package com.winfirst.physics;

import com.winfirst.utils.Handler;

public class Gravity{

    private Vector2D vectA;

    public Gravity(double a, Handler h){
        vectA = new Vector2D(0, 0, 0, (float) a, (float) a, h);
    }

}
