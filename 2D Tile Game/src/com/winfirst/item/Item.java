package com.winfirst.item;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Item {

    private BufferedImage icon;

    public Item(BufferedImage icon) {
        this.icon = icon;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public BufferedImage getIcon() {
        return this.icon;
    }
}
