package com.winfirst.main;

import com.winfirst.config.ConfigFile;
import com.winfirst.game.Game;
import com.winfirst.logging.Logger;

public class Launcher {

    public static void main(String[] args) {
        //SettingsGUI settings = new SettingsGUI(300, 300);
        //settings.makeSettingsGui();

        //Logger Init
        //Logger.setPath("res/log/");
        //Logger.getInstance().write("Path set");
        //ConfigFile cfgconfigfilefile = new ConfigFile("res/config/config.cfg");

        //Starts Game
        Game game = new Game("RPG Game", 1280, 720);
        game.start();
    }

}
