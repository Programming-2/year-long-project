package com.winfirst.test;

import org.junit.Test;

import com.winfirst.noise.NoiseGenerator;

public class NoiseTest {
	
	@Test
	public void testNoise(){
		NoiseGenerator noise = new NoiseGenerator(0, 10);
		for(int i = 100; i > 0; i--){
			System.out.println(noise.generateNoise());
		}
	}
}
