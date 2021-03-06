package com.winfirst.events;

public class CollisionEvent{

    private Object creator, hit;
    private int x, y;

    public CollisionEvent(Object creator, Object hit, int x, int y) {
        this.x = x;
        this.y = y;
        this.creator = creator;
        this.hit = hit;
    }

    public Object getCreator() {
        return creator;
    }

    public Object getHit() {
        return hit;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
