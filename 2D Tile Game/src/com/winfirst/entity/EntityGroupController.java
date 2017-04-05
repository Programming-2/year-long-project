package com.winfirst.entity;

import java.util.ArrayList;

public class EntityGroupController<T extends Entity> {

    private T t;
    private ArrayList<T> group = new ArrayList<>();
    private GroupType type;

    public EntityGroupController(GroupType type) {
        this.type = type;
    }

    public void add(T t) {
        group.add(t);
    }

    public T get(int i) {
        return group.get(i);
    }

    public void moveGroup(int x, int y){
        for(Entity e : group){
            e.setX(x);
            e.setY(y);
        }
        for(Entity e : group){
            e.setX(0);
            e.setY(0);
        }
    }
}
