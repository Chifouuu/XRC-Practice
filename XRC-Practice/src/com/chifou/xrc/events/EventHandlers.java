package com.chifou.xrc.events;

import com.chifou.xrc.Main;
import com.chifou.xrc.gui.queue.UnrankedGuiCommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.*;

public class EventHandlers implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

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

    @EventHandler
    public void guiEvents(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack currentItem = event.getCurrentItem();
        Inventory currentGui = event.getInventory();

        if(currentGui.getName() == "§b§lUnranked Queue") {
            event.setCancelled(true);
        } else if(currentGui.getName() == "§4§lRanked Queue") {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInterract(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();
        ItemStack currentItem = event.getItem();
        Action action = event.getAction();

        if(currentItem.getType() == Material.IRON_SWORD && currentItem.getItemMeta().getDisplayName() == "§bUnranked") {
            if(action != Action.LEFT_CLICK_AIR && action != Action.LEFT_CLICK_BLOCK) {
                Bukkit.dispatchCommand(player, "unrankedgui");
            }
        } else if(currentItem.getType() == Material.DIAMOND_SWORD && currentItem.getItemMeta().getDisplayName() == "§bRanked") {
            if(action != Action.LEFT_CLICK_AIR && action != Action.LEFT_CLICK_BLOCK) {
                Bukkit.dispatchCommand(player, "rankedgui");
            }
        }
    }
}
