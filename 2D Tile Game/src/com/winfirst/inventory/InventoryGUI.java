package com.winfirst.inventory;

import com.winfirst.entity.Player;

public class InventoryGUI {

    private Inventory inventory;
    private Player player;

    public InventoryGUI(Inventory inventory, Player player){
        this.inventory = inventory;
        this.player = player;
    }

    public Inventory getInventory(){
        return inventory;
    }



}
