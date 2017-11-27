package com.winfirst.test;

import com.winfirst.physics.VelocityVector;

public class VectorTest {

    public static void main(String[] args) {
        VelocityVector vect = new VelocityVector(0, 0, 0, 1, 9.8f, null);
        System.out.println(Math.toDegrees(vect.getAngle()));
    }

}
