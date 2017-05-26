package com.winfirst.game;

import com.winfirst.graphics.Display;
import com.winfirst.graphics.GameCamera;
import com.winfirst.input.KeyManager;
import com.winfirst.input.MouseManager;
import com.winfirst.logging.Logger;
import com.winfirst.states.GameState;
import com.winfirst.states.MainMenu;
import com.winfirst.states.State;
import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    public String title;
    public boolean running = false;
    private Display display;
    private int width, height;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init() {
        //Display Stuff
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        //Assets Init
        Assets.init();

        //Handler init (stores variables related to the game
        handler = new Handler(this);

        //Makes game camera
        gameCamera = new GameCamera(handler, 0, 0);

        //Init States
        gameState = new GameState(handler);
        menuState = new MainMenu(handler);

        //Sets current state to the Game State
        State.setState(gameState);
    }


    public void tick() {
        //Ticks key manager
        keyManager.tick();

        //Ticks current state
        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    public void render() {
        //Sets buffer strategy
        bs = display.getCanvas().getBufferStrategy();

        //Creates buffer strategy if bs is null
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        //Gets instance of graphics object
        g = bs.getDrawGraphics();

        //Clears the screen
        g.clearRect(0, 0, width, height);

        //Renders current state
        if (State.getState() != null) {
            State.getState().render(g);
        }

        //Shows buffer strategy
        bs.show();

        //Disposes graphics
        g.dispose();
    }

    public void run() {
        //Inits the game
        init();

        //Vars to set fps
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        //Writes to logger
        Logger.getInstance().write("Run started");

        //Game loop
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println(ticks);
                Logger.getInstance().write("" + ticks);
                ticks = 0;
                timer = 0;
            }

        }

        stop();
    }

    //Returns instance of key manager
    public KeyManager getKeyManager() {
        return keyManager;
    }

    //Returns instance of mouse manager
    public MouseManager getMouseManager() {
        return mouseManager;
    }

    //Returns instance of game camera
    public GameCamera getGameCamera() {
        return gameCamera;
    }

    //Returns window width
    public int getWidth() {
        return width;
    }

    //Returns window height
    public int getHeight() {
        return height;
    }

    //Function that starts the game
    public synchronized void start() {
        Logger.getInstance().write("Game Started");
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    //Function that stops game
    public synchronized void stop() {
        Logger.getInstance().write("Game Stopped");
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}