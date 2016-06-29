package de.recklessGreed;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

/**
 * Created by dawen on 03.06.2016.
 */
public class Rush_Main extends JavaPlugin
{
    private static Rush_Main instance;
    Listener events;
    FileConfiguration config = this.getConfig();

    /*
     * Custom defined Errors:
     */

    World currentWorld = null;
    String ccGreen = ChatColor.GREEN + "";
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

    public static Rush_Main getInstance()
    {
        return instance;
    }


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
        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (currentWorld == null) currentWorld = player.getWorld();
            if (player.hasMetadata("ingame")) player.removeMetadata("ingame", Rush_Main.getInstance());
            player.teleport(spawnLobbyLoc);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getName().equals("addToWL"))
        {
            return addPlayersToWhitelist(args);
        }
        else if (command.getName().equals("clearWL"))
        {
            return clearWL();
        }
        else if (command.getName().equals("newgame"))
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

    public Location getSpawnLobbyLoc()
    {
        return spawnLobbyLoc;
    }

    public void setSpawnLobbyLoc(Location spawnLobbyLoc)
    {
        this.spawnLobbyLoc = spawnLobbyLoc;
    }

    public Location getSpawnRed()
    {
        return spawnRed;
    }

    public void setSpawnRed(Location spawnRed)
    {
        this.spawnRed = spawnRed;
    }

    public Location getSpawnBlue()
    {
        return spawnBlue;
    }

    public void setSpawnBlue(Location spawnBlue)
    {
        this.spawnBlue = spawnBlue;
    }

    public Location getBedLocRed()
    {
        return bedLocRed;
    }

    public void setBedLocRed(Location bedLocRed)
    {
        this.bedLocRed = bedLocRed;
    }

    public Location getBedLocBlue()
    {
        return bedLocBlue;
    }

    public void setBedLocBlue(Location bedLocBlue)
    {
        this.bedLocBlue = bedLocBlue;
    }

    private boolean newGame()
    {
        return true;
    }

    private void readConfig()
    {
        if (new File(this.getDataFolder(), "config.yml").exists())
        {
            this.getServer().getConsoleSender().sendMessage(ccGreen + "Found config.yml!");
        }
        else
        {
            this.getServer().getConsoleSender().sendMessage(ccRed + "Missing config.yml | Creating one!");
            getConfig().options().copyDefaults(true);
            saveConfig();
            //this.getServer().shutdown();
        }

        String worldName = (String) config.get("Lobby.name");
        File srcFolder = new File("./template");
        File destFolder = new File("./gamemap");
        World lobbyWorld = Bukkit.createWorld(new WorldCreator(worldName));
        World gameWorld = Bukkit.createWorld(new WorldCreator("gamemap"));

        spawnLobbyLoc  = new Location(lobbyWorld, config.getDouble("normalSpawn.x"), config.getDouble("normalSpawn.y"), config.getDouble("normalSpawn.z"));
        System.out.println(spawnLobbyLoc.getX() + " , " + spawnLobbyLoc.getY() + " , " + spawnLobbyLoc.getZ());
        spawnRed  = new Location(gameWorld, config.getDouble("spawnRed.x"), config.getDouble("spawnRed.y"), config.getDouble("spawnRed.z"));
        spawnBlue  = new Location(gameWorld, config.getDouble("spawnBlue.x"), config.getDouble("spawnBlue.y"), config.getDouble("spawnBlue.z"));
        bedLocRed  = new Location(gameWorld, config.getDouble("bedRed.x"), config.getDouble("bedRed.y"), config.getDouble("bedRed.z"));
        bedLocBlue  = new Location(gameWorld, config.getDouble("bedBlue.x"), config.getDouble("bedBlue.y"), config.getDouble("bedBlue.z"));
    }

    public static void copyFolder(File src, File dest) throws IOException
    {

        if (src.isDirectory())
        {

            //if directory not exists, create it
            if (!dest.exists())
            {
                dest.mkdir();
            }

            //list all the directory contents
            String files[] = src.list();

            for (String file : files)
            {
                //construct the src and dest file structure
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                //recursive copy
                copyFolder(srcFile, destFile);
            }

        }
        else
        {
            //if file, then copy it
            //Use bytes stream to support all file types
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = in.read(buffer)) > 0)
            {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
        }
    }
}
