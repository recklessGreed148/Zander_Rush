package de.recklessGreed;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by dawen on 03.06.2016.
 */
public class Rush_Main extends JavaPlugin
{
    private static Rush_Main instance;
    Listener events;

    /*
     * Custom defined Errors:
     */

    World currentWorld = null;
    String ccRed = ChatColor.RED + "";
    String onlyPlayer = ccRed + "This Command is only useable as a Player.";
    String noPermissions = ccRed + "TeamspeakVoice: Insufficient Permissions";
    String argsCount = ccRed + "Too less or too many Arguments.";
    String wrongArgs = ccRed + "You sure you got this right? Better check.";

    private Location spawnLoc;

    public static Rush_Main getInstance(){return instance;}


    @Override
    public void onDisable()
    {
        super.onDisable();
    }

    @Override
    public void onEnable()
    {
        instance = this;
        events = new Rush_Listeners(this);
        getServer().getPluginManager().registerEvents(events, this);
        super.onEnable();
        getServer().getPluginManager().registerEvents(events, this);
        Bukkit.getServer().setDefaultGameMode(GameMode.ADVENTURE);
        Bukkit.getServer().getWorlds().get(0).setPVP(true);
        Bukkit.getServer().getWorlds().get(0).setSpawnFlags(false, false);
        Bukkit.getServer().getWorlds().get(0).setStorm(false);
        Bukkit.getServer().getWorlds().get(0).setGameRuleValue("doFireTick", "false");
        Bukkit.getServer().getWorlds().get(0).setGameRuleValue("doEntityDrop", "false");
        Bukkit.getServer().getWorlds().get(0).setGameRuleValue("mobGriefing", "false");
        Bukkit.getServer().getWorlds().get(0).setGameRuleValue("showDeathMessages", "false");
        Bukkit.getServer().getWorlds().get(0).setTime(6800);
        Bukkit.getServer().getWorlds().get(0).setDifficulty(Difficulty.PEACEFUL);

        for(Player player : Bukkit.getOnlinePlayers())
        {
            if(currentWorld == null) currentWorld = player.getWorld();
            if(player.hasMetadata("ingame")) player.removeMetadata("ingame", Rush_Main.getInstance());
            player.teleport(spawnLoc);
        }
    }
}
