package com.winfirst.noise;

public class NoiseGenerator {
	private float scale;
	private int max;
	
	public NoiseGenerator(float scale, int max){
		this.scale = scale;
		this.max = max;
	}
	
	public int generateNoise(){
		return ((int) (Math.random() * max));
	}
}
