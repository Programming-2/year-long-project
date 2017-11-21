package com.winfirst.physics;

public class KinematicUtils {

    public static float vel(float vNaught, float a, float t){
        return a * t + vNaught;
    }

    public static float distance(float xNaught, float vNaught, float a, float t){
        return (float) ((.5 * a * t * t) + (vNaught * t) + xNaught);
    }

    public static float vel(float vNaught, float a, float xNaught, float x){
        return (float) (Math.sqrt(Math.pow(vNaught, 2) + 2 * a * (x - xNaught)));
    }
}
