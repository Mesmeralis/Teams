package me.goodwilled.legendstrifes;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerInConfig {
    Team team;
    Main main;

    public static Player player(Player p){
        return Bukkit.getServer().getPlayer(p.getName());
    }

   public void configString(Player plr){
        main.getlegends().legendscfg.getString(player(plr).getUniqueId().toString());
   }

}
