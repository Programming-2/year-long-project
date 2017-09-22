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
        float x = handler.getMouseManager().getMouseX();
        float y = handler.getMouseManager().getMouseY();
        if(((x >= 870 && x <= 1080) && (y >= 340 && y <= 382)) && handler.getMouseManager().isLeftPressed()) {
            State.setState(handler.getGame().gameState);
        }
        else if(((x >= 135 && x <= 295) && (y >= 340 && y <= 375)) && handler.getMouseManager().isLeftPressed()){
            State.setState(handler.getGame().controlState);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.mainMenu, 0, 0, null);
    }



}
