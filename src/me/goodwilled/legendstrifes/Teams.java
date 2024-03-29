package me.goodwilled.legendstrifes;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Teams {
    private Main main;
    public Teams(Main main){ this.main = main; }

    public FileConfiguration legendscfg;
    public File legendsfile;

    public void setup() {
        if(!main.getDataFolder().exists()) {
            main.getDataFolder().mkdir();
        }

        legendsfile = new File(main.getDataFolder(), "legends.yml");

        if(!legendsfile.exists()) {
            try {
                legendsfile.createNewFile();
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "CREATED legends.YML FILE");
            } catch(IOException e) {
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "COULD NOT CREATE legends.YML FILE");
            }
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "LOADED legends.YML FILE");
        }

        legendscfg = YamlConfiguration.loadConfiguration(legendsfile);
    }

    public FileConfiguration getPlayers() {
        return legendscfg;
    }

    public void savePlayers() {
        try {
            legendscfg.save(legendsfile);
        } catch(IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "COULD NOT SAVE PLAYERS.");
        }
    }
}
