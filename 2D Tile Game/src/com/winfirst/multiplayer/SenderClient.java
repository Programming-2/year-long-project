package com.winfirst.multiplayer;

import com.winfirst.entity.Entity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SenderClient extends Client {
    private boolean running;
    private Thread thread;
    private PrintWriter pw;
    private ArrayList<Entity> entArr;

    public SenderClient(int port, String ip) {
        super(port, ip);
        this.running = false;
        entArr = new ArrayList<>();
        try {
            this.pw = new PrintWriter(super.getSocket().getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        pw.println("Connected");
    }

    private void writePosition(Position position) {
        pw.println(position.toString());
    }

    @Override
    public void run() {
        init();

        while (running) {
            entArr.forEach((e) -> writePosition(new Position(e.getX(), e.getY())));
        }
    }

    public void addEntity(Entity e) {
        entArr.add(e);
    }

    public synchronized void start() {
        if (!running) {
            this.thread = new Thread(this);
            this.thread.start();
            running = true;
        }
    }

    public synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isRunning() {
        return running;
    }

    public Thread getThread() {
        return thread;
    }

}
