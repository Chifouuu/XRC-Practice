package com.chifou.xrc;

import com.chifou.xrc.events.EventHandlers;
import com.chifou.xrc.gui.queue.UnrankedGuiCommand;
import com.chifou.xrc.gui.queue.rankedGui;
import com.chifou.xrc.help.HelpCommand;
import com.chifou.xrc.queue.Unranked;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        clearHashmaps();

        saveDefaultConfig();

        int boo = 1;
        while (boo < 8) {
            System.out.println("XRC 1.0 BY CHIFOU");
            boo++;
        }

        getCommand("practicehelp").setExecutor(new HelpCommand());
        getCommand("unrankedgui").setExecutor(new UnrankedGuiCommand());
        getCommand("rankedgui").setExecutor(new rankedGui());

        Bukkit.getPluginManager().registerEvents(new EventHandlers(), this);

        //in config item in hotbar when joinevent
    }

    private static void clearHashmaps() {
        Unranked.nodebuff.clear();
    }

    @Override
    public void onDisable() {


    }

    public static Main getInstance() {
        return instance;
    }
}
