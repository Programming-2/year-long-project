package com.winfirst.entity;

import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

import java.awt.*;

public class NPC extends Creature {

    private Player p;
    private boolean track = false;
    private float pastX;
    private float pastY;

    public NPC(Handler handler, float x, float y, Player p) {
        super(handler, x, y, Player.DEFAULT_CREATURE_WIDTH, Player.DEFAULT_CREATURE_HEIGHT);
        this.p = p;
        this.pastX = p.getX();
        this.pastY = p.getY();
    }

    @Override
    public void tick() {
        if (track) {
            moveToPlayer();
        }
        this.move();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerStop[0], (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    private void moveToPlayer() {
        float xMove = 0;
        float yMove = 0;

        if(isMoving()) {
            if (this.getX() > p.getX()) {
                xMove = 4 * -1;
            } else if (this.getX() < p.getX()) {
                xMove = 4;
            } else {
                xMove = 0;
            }

            if (this.getY() > p.getY()) {
                yMove = 4 * -1;
            } else if (this.getY() < p.getY()) {
                yMove = 4;
            } else {
                yMove = 0;
            }
        }

        this.setxMove(xMove);
        this.setyMove(yMove);
    }

    public boolean isMoving(){
        updatePast();
        if(this.pastX == p.getX() && this.pastY == p.getY()){
            return true;
        }
        return false;
    }

    private void updatePast(){
        if(this.pastX != p.getX()){
            this.pastX = p.getX();
        }

        if(this.pastY != p.getY()){
            this.pastY = p.getY();
        }
    }

    public void setTrack(boolean b) {
        track = b;
    }

}
