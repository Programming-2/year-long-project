package com.winfirst.tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //Statics

    //Class
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile rockTile = new RockTile(2);
    public static Tile stoneBrickTile = new StoneBrickTile(3);
    protected final int id;
    protected BufferedImage texture;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public int getId() {
        return id;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }
}
