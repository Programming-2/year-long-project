package com.winfirst.noise;

public class NoiseGenerator {
	private float scale;
	private int min, max;
	
	public NoiseGenerator(float scale, int min, int max){
		this.scale = scale;
		this.min = min;
		this.max = max;
	}
	
	public int generateNoise(){
		return 0;
	}
}
