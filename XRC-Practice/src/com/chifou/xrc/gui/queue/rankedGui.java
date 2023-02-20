package com.chifou.xrc.gui.queue;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class rankedGui implements CommandExecutor {
    public static Inventory inv = Bukkit.createInventory(null, 27, "§4§lRanked Queue");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
            ItemMeta metaglass = glass.getItemMeta();
            metaglass.setDisplayName(" ");
            glass.setItemMeta(metaglass);

            ItemStack white = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.WHITE.getData());
            ItemMeta metawihte = glass.getItemMeta();
            metawihte.setDisplayName(" ");
            white.setItemMeta(metawihte);


            ItemStack ndb = new ItemStack(Material.POTION, 1);
            ItemMeta metandb = ndb.getItemMeta();
            metandb.setDisplayName("§bNodebuff");
            ndb.setItemMeta(metandb);

            inv.setItem(0, glass);
            inv.setItem(1, white);
            inv.setItem(2, glass);
            inv.setItem(3, white);
            inv.setItem(4, glass);
            inv.setItem(5, white);
            inv.setItem(6, glass);
            inv.setItem(7, white);
            inv.setItem(8, glass);
            inv.setItem(9, white);
            inv.setItem(17, white);
            inv.setItem(18, glass);
            inv.setItem(19, white);
            inv.setItem(20, glass);
            inv.setItem(21, white);
            inv.setItem(22, glass);
            inv.setItem(23, white);
            inv.setItem(24, glass);
            inv.setItem(25, white);
            inv.setItem(26, glass);

            inv.setItem(10, ndb);


            player.openInventory(inv);
        }

        return false;
    }
}
