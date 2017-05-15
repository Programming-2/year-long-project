package com.winfirst.tile;

import com.winfirst.graphics.ImageLoader;
import com.winfirst.graphics.SpriteSheet;

import java.awt.image.BufferedImage;

public class Assets {

    public static final int playerWidth = 13, playerHeight = 36;
    private static final int width = 32, height = 32;
    public static BufferedImage tree, dirt, grass, mainMenu, rock, stoneBrick;
    public static BufferedImage[] playerDown;
    public static BufferedImage[] playerUp;
    public static BufferedImage[] playerLeft;
    public static BufferedImage[] playerRight;
    public static BufferedImage[] playerStop;
    public static BufferedImage iron;
    public static BufferedImage bullet;
    public static BufferedImage netCannon;

    public static void init() {
        SpriteSheet ground = new SpriteSheet(ImageLoader.loadImage("/textures/ground.png"));
        SpriteSheet MainMenu = new SpriteSheet(ImageLoader.loadImage("/textures/MainMenu.png"));
        SpriteSheet character = new SpriteSheet(ImageLoader.loadImage("/textures/Char.png"));
        SpriteSheet item = new SpriteSheet(ImageLoader.loadImage("/textures/items.png"));

        playerDown = new BufferedImage[4];
        playerDown[0] = character.crop(0, 0, playerWidth, playerHeight);
        playerDown[1] = character.crop(0, playerHeight, playerWidth, playerHeight);
        playerDown[2] = character.crop(0, 2 * playerHeight, playerWidth, playerHeight);
        playerDown[3] = character.crop(0, playerHeight, playerWidth, playerHeight);

        playerUp = new BufferedImage[4];
        playerUp[0] = character.crop(playerWidth, 0, playerWidth, playerHeight);
        playerUp[1] = character.crop(playerWidth, playerHeight, playerWidth, playerHeight);
        playerUp[2] = character.crop(playerWidth, 2 * playerHeight, playerWidth, playerHeight);
        playerUp[3] = character.crop(playerWidth, playerHeight, playerWidth, playerHeight);

        playerRight = new BufferedImage[4];
        playerRight[0] = character.crop(2 * playerWidth, 0, playerWidth, playerHeight);
        playerRight[1] = character.crop(2 * playerWidth, playerHeight, playerWidth, playerHeight);
        playerRight[2] = character.crop(2 * playerWidth, 2 * playerHeight, playerWidth, playerHeight);
        playerRight[3] = character.crop(2 * playerWidth, playerHeight, playerWidth, playerHeight);

        playerLeft = new BufferedImage[4];
        playerLeft[0] = character.crop(3 * playerWidth, 0, playerWidth, playerHeight);
        playerLeft[1] = character.crop(3 * playerWidth, playerHeight, playerWidth, playerHeight);
        playerLeft[2] = character.crop(3 * playerWidth, 2 * playerHeight, playerWidth, playerHeight);
        playerLeft[3] = character.crop(3 * playerWidth, playerHeight, playerWidth, playerHeight);

        playerStop = new BufferedImage[1];
        playerStop[0] = character.crop(0, playerHeight, playerWidth, playerHeight);

        grass = ground.crop(0, 0, width, height);
        dirt = ground.crop(width, 0, width, height);
        mainMenu = MainMenu.crop(0, 0, 640, 360);
        rock = ground.crop(width * 2, 0, width, height);
        stoneBrick = ground.crop(width * 3, 0, width, height);
        tree = ground.crop(0, height, width, height);

        iron = item.crop(0,0,width * 2, height);
        bullet = item.crop(width * 2, 0, width, height);
        netCannon = item.crop(width * 3, 0, width, height);
    }

}
