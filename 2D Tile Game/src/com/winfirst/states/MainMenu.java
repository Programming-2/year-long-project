package com.winfirst.states;

import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

import java.awt.*;

public class MainMenu extends State {

    public MainMenu(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        System.out.println(handler.getMouseManager().getMouseX() + " " + handler.getMouseManager().getMouseY());
        float x = handler.getMouseManager().getMouseX();
        float y = handler.getMouseManager().getMouseY();
        if(x>=870 && x<=1080 && y>=340 && y<=940 && handler.getMouseManager().isLeftPressed()) {
            State.setState(handler.getGame().gameState);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.mainMenu, 0, 0, null);
    }



}
