package com.winfirst.tile;

public class RockTile extends Tile {

    public RockTile(int id) {
        super(Assets.rock, id);
    }

    //Tile is solid
    @Override
    public boolean isSolid() {
        return true;
    }

}