package de.recklessGreed;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

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

    private Location spawnLobbyLoc;
    private Location spawnRed;
    private Location spawnBlue;
    private Location bedLocRed;
    private Location bedLocBlue;

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
        Bukkit.getServer().setDefaultGameMode(GameMode.ADVENTURE);
        Bukkit.getServer().getWorlds().get(0).setPVP(true);
        Bukkit.getServer().getWorlds().get(0).setSpawnFlags(false, false);
        Bukkit.getServer().getWorlds().get(0).setStorm(false);
        Bukkit.getServer().getWorlds().get(0).setGameRuleValue("doFireTick", "false");
        Bukkit.getServer().getWorlds().get(0).setGameRuleValue("doEntityDrop", "false");
        Bukkit.getServer().getWorlds().get(0).setGameRuleValue("mobGriefing", "false");
        Bukkit.getServer().getWorlds().get(0).setGameRuleValue("showDeathMessages", "false");
        Bukkit.getServer().getWorlds().get(0).setTime(6800);
        Bukkit.getServer().getWorlds().get(0).setDifficulty(Difficulty.EASY);
        readConfig();
        for(Player player : Bukkit.getOnlinePlayers())
        {
            if(currentWorld == null) currentWorld = player.getWorld();
            if(player.hasMetadata("ingame")) player.removeMetadata("ingame", Rush_Main.getInstance());
            player.teleport(spawnLobbyLoc);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(command.getName().equals("addToWL"))
        {
            return addPlayersToWhitelist(args);
        }
        else if (command.getName().equals("clearWL"))
        {
            return clearWL();
        }
        else if(command.getName().equals("newgame"))
        {
            return newGame();
        }
        return super.onCommand(sender, command, label, args);
    }

    private boolean addPlayersToWhitelist(String[] args)
    {
        return true;
    }

    private boolean clearWL()
    {
        return true;
    }

    private boolean newGame()
    {
        return true;
    }

    private void readConfig()
    {
        if (new File(this.getDataFolder(), "config.yml").exists())
        {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
        else
        {
            this.getServer().getConsoleSender().sendMessage(ccRed + "Missing config.yml");
            this.getServer().shutdown();
        }
    }
}
