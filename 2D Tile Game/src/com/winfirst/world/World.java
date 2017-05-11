package com.winfirst.world;

import com.winfirst.entity.EntityManager;
import com.winfirst.entity.NPC;
import com.winfirst.entity.Player;
import com.winfirst.entity.Tree;
import com.winfirst.noise.SimplexNoise;
import com.winfirst.projectile.Projectile;
import com.winfirst.tile.Tile;
import com.winfirst.utils.Handler;
import com.winfirst.utils.Utils;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class World {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    private NPC npc;
    private Player p;

    //Entities
    private EntityManager entityManager;

    public World(Handler handler, String path) {
        this.handler = handler;

        p = new Player(handler, 100, 100);
        entityManager = new EntityManager(handler, p);
        //entityManager.addEntity(new Tree(handler, 200, 200));
        npc = new NPC(handler, 300, 300, p);
        entityManager.addEntity(npc);
        npc.setTrack(true);

        for (int i = 0; i < 5; i++) {
            entityManager.addEntity(new Tree(handler, ThreadLocalRandom.current().nextInt(1, 35) * 64, ThreadLocalRandom.current().nextInt(1, 22) * 64));
        }


        loadWorld(path);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

    public void addProjectile(Projectile p){
        entityManager.addEntity(p);
    }

    public void tick() {
        entityManager.tick();
        //Add something to remove bullets no longer on the screen or map
    }

    public void render(Graphics g) {
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

        for (int y = yStart;
             y < yEnd;
             y++) {
            for (int x = xStart;
                 x < xEnd;
                 x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }

        //Entities
        entityManager.render(g);
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.grassTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];

        if (t == null) {
            return Tile.dirtTile;
        }

        return t;

    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];

        for (int y = 0;
             y < height;
             y++) {
            for (int x = 0;
                 x < width;
                 x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }

//        for (int i = 0; i < tiles.length; i++) {
//            System.out.println();
//            for (int j = 0; j < tiles[0].length; j++) {
//                if(i == 0 || j == 0 || j == tiles[0].length - 1 || i == tiles.length - 1){
//                    tiles[i][j] = 2;
//                }else {
//                    System.out.print((int) ((((Math.abs(SimplexNoise.noise(i, j)))) * 4)) + " ");
//                    tiles[i][j] = (int) ((((Math.abs(SimplexNoise.noise(i, j)))) * 4));
//                }
//            }
//        }
    }

    //Getters and Setters
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}