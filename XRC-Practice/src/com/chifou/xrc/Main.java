package com.chifou.xrc;

import com.chifou.xrc.help.HelpCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        int boo = 1;
        while (boo < 8) {
            System.out.println("XRC 1.0 BY CHIFOU");
            boo++;
        }

        getCommand("practicehelp").setExecutor(new HelpCommand());


    }

    @Override
    public void onDisable() {


    }

    public static Main getInstance() {
        return instance;
    }
}
