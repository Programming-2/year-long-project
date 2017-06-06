package com.winfirst.states;

import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

import java.awt.*;

/**
 * Created by gleit18055 on 6/6/2017.
 */
public class WinState extends State{

    public WinState(Handler h){
        super(h);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.victory, 0 ,0 , null);
    }
}
