package com.winfirst.events;

import java.util.ArrayList;

public class Collisions {

    private Collisions instance;

    public Collisions getInstance(){
        if(instance == null){
            instance = new Collisions();
        }
        return instance;
    }

    private ArrayList<CollisionEvent> collisions;

    private Collisions(){
        this.collisions = new ArrayList<>();
    }

    public void addCollision(CollisionEvent e){
        collisions.add(e);
    }

    public CollisionEvent getCollision(int i){
        return collisions.get(i);
    }
}
