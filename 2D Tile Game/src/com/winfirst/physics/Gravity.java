package com.winfirst.physics;

        import com.winfirst.utils.Handler;

public class Gravity{

    private VelocityVector vectA;

    public Gravity(double a, Handler h){
        vectA = new VelocityVector(0, 0, 0, 1, (float) a, h);
    }

    public VelocityVector getVector(){
        return vectA;
    }

}
