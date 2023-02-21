package com.chifou.xrc.stuff.spawn;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveSwords {

    public static void giveSword(Player player) {

        player.getInventory().clear();

        ItemStack unrankedItem = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta metaui = unrankedItem.getItemMeta();
        metaui.setDisplayName("§bUnranked");
        unrankedItem.setItemMeta(metaui);

        ItemStack rankedItem = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta metari = rankedItem.getItemMeta();
        metari.setDisplayName("§bRanked");
        rankedItem.setItemMeta(metari);

        player.getInventory().setItem(0, unrankedItem);
        player.getInventory().setItem(1, rankedItem);
    }
}
