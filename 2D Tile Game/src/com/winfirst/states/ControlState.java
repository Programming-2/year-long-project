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

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.control, 0 ,0 , null);
    }
}
