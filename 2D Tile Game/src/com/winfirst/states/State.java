package com.winfirst.states;

import com.winfirst.utils.Handler;

import java.awt.*;

public abstract class State {

    //Manager
    private static State currentState = null;
    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    public static State getState() {
        return currentState;
    }

    public static void setState(State state) {
        currentState = state;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
