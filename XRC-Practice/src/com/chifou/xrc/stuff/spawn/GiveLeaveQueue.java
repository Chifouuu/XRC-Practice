package com.chifou.xrc.stuff.spawn;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveLeaveQueue {

    public static void giveLeaveQueue(Player player) {

        player.getInventory().clear();

        ItemStack leavequeue = new ItemStack(Material.REDSTONE, 1);
        ItemMeta metaleave = leavequeue.getItemMeta();
        metaleave.setDisplayName("§4Leave Queue");
        leavequeue.setItemMeta(metaleave);

        player.getInventory().addItem(leavequeue);
    }
}
