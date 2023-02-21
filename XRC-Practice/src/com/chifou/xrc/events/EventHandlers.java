package com.chifou.xrc.events;

import com.chifou.xrc.Main;
import com.chifou.xrc.gui.queue.UnrankedGuiCommand;
import com.chifou.xrc.queue.Unranked;
import com.chifou.xrc.stuff.spawn.GiveLeaveQueue;
import com.chifou.xrc.stuff.spawn.GiveSwords;
import com.chifou.xrc.utils.References;
import org.bukkit.Bukkit;
import org.bukkit.Location;
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

        GiveSwords.giveSword(player);
    }

    @EventHandler
    public void guiEvents(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack currentItem = event.getCurrentItem();
        Inventory currentGui = event.getInventory();

        if(currentGui.getName() == "§b§lUnranked Queue") {
            event.setCancelled(true);
            if(currentItem.getType() == Material.POTION) {
                player.closeInventory();

                if(Unranked.nodebuff.containsKey(1)) {
                    Unranked.nodebuff.put(2, player);
                    startGame(player);
                } else if (!Unranked.nodebuff.containsKey(1)) {
                    Unranked.nodebuff.put(1, player);
                    GiveLeaveQueue.giveLeaveQueue(player);
                }
            }
        } else if(currentGui.getName() == "§4§lRanked Queue") {
            event.setCancelled(true);
        }
    }

    private static void startGame(Player player) {
        player.getInventory().clear();


        Player player1 = Unranked.nodebuff.get(1);
        Player player2 = Unranked.nodebuff.get(2);


        Unranked.nodebuff.clear();

        int x1 = Integer.parseInt(Main.getInstance().getConfig().getString("maps.ndb1.co1.x"));
        int y1 = Integer.parseInt(Main.getInstance().getConfig().getString("maps.ndb1.co1.y"));
        int z1 = Integer.parseInt(Main.getInstance().getConfig().getString("maps.ndb1.co1.z"));
        Location loc1 = new Location(player1.getWorld(), x1, y1, z1);

        int x2 = Integer.parseInt(Main.getInstance().getConfig().getString("maps.ndb1.co2.x"));
        int y2 = Integer.parseInt(Main.getInstance().getConfig().getString("maps.ndb1.co2.y"));
        int z2 = Integer.parseInt(Main.getInstance().getConfig().getString("maps.ndb1.co2.z"));
        Location loc2 = new Location(player1.getWorld(), x2, y2, z2);

        player1.teleport(loc1);
        player2.teleport(loc2);

        player1.sendMessage(References.msgPrefix + "The fight start !");
        player2.sendMessage(References.msgPrefix + "The fight start !");
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
        } else if(currentItem.getType() == Material.REDSTONE && currentItem.getItemMeta().getDisplayName() == "§4Leave Queue") {
            if(action != Action.LEFT_CLICK_AIR && action != Action.LEFT_CLICK_BLOCK) {
                if(Unranked.nodebuff.containsValue(player)) {
                    Unranked.nodebuff.clear();
                    GiveSwords.giveSword(player);
                }
            }

        }
    }
}
