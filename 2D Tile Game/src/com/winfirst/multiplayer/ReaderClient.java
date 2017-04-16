package com.winfirst.multiplayer;

import com.winfirst.utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReaderClient extends Client {

    private boolean running;
    private Thread thread;
    private BufferedReader br;
    private ArrayList<Position> posArr;

    public ReaderClient(final int port, final String ip) {
        super(port, ip);
        this.running = false;
        posArr = new ArrayList<>();
        try {
            this.br = new BufferedReader(new InputStreamReader(super.getSocket().getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() {

    }

    private void readLine() {
        String fromServer = null;
        try {
            fromServer = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fromServer != null) {
            float x = Utils.parseFloat(fromServer.substring(0, 1));
            float y = Utils.parseFloat(fromServer.substring(2));
            posArr.add(new Position(x, y));
        }
    }

    @Override
    public void run() {
        init();

        while (running) {
            readLine();
        }
    }

    public synchronized void start() {
        if (!running) {
            this.thread = new Thread(this);
            this.thread.start();
            running = true;
        }
    }

    public synchronized void stop() {
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

    public boolean isRunning() {
        return running;
    }

    public Thread getThread() {
        return thread;
    }

    public ArrayList<Position> getPosArr() {
        return posArr;
    }

}
