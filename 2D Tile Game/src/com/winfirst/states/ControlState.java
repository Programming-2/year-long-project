package com.winfirst.states;

import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

import java.awt.*;

public class ControlState extends State{

    public ControlState(Handler h){
        super(h);
    }

    @Override
    public void tick() {
        float x = handler.getMouseManager().getMouseX();
        float y = handler.getMouseManager().getMouseY();
        if(((x >= 800 && x <= 1103) && (y >= 500 && y <= 670)) && handler.getMouseManager().isLeftPressed()) {
            State.setState(handler.getGame().menuState);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.control, 0 ,0 , null);
    }
}
