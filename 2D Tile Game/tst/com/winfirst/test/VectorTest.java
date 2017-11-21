package com.winfirst.test;

import com.winfirst.physics.Vector2D;
import org.junit.Test;

public class VectorTest {

    public static void main(String[] args) {
        Vector2D vect = new Vector2D(0, 0, 0, 1, 9.8f, null);
        System.out.println(Math.toDegrees(vect.getAngle()));
    }

}
