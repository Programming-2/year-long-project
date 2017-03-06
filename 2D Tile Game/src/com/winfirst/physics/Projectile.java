package com.winfirst.physics;

public class Projectile {
	
	private Vector2D vector;
	
	public Projectile(Vector2D vector){
		this.vector = vector;
	}
	
	public Vector2D getVector(){
		return this.vector;
	}
}
