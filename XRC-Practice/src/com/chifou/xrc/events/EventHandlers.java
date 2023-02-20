package com.chifou.xrc.events;

import com.chifou.xrc.gui.queue.UnrankedGuiCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EventHandlers implements Listener {

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
}
