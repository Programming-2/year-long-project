package com.winfirst.test;

import com.winfirst.noise.NoiseGenerator;
import org.junit.Test;

public class NoiseTest {

    @Test
    public void testNoise() {
        NoiseGenerator noise = new NoiseGenerator(0, 10);
        for (int i = 100;
             i > 0;
             i--) {
            System.out.println(noise.generateNoise());
        }
    }
}
