package com.winfirst.states;

import com.winfirst.utils.Handler;
import com.winfirst.world.World;

import java.awt.*;

public class GameState extends State {

    private World world;

    public GameState(Handler handler, String path) {
        super(handler);
        world = new World(handler, path);
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }


}
 