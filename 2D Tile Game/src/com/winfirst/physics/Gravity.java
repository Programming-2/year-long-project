package com.winfirst.physics;

        import com.winfirst.utils.Handler;

public class Gravity{

    private Vector2D vectA;

    public Gravity(double a, Handler h){
        vectA = new Vector2D(0, 0, 0, 1, (float) a, h);
    }

    public Vector2D getVector(){
        return vectA;
    }

}
