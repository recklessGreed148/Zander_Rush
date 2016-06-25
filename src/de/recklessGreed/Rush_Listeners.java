package de.recklessGreed;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

/**
 * Created by dawen on 03.06.2016.
 */
public class Rush_Listeners implements Listener
{
    Rush_Main classMain;


    Villager blocks;
    MerchantRecipe sandstone;
    MerchantRecipe endstone;
    MerchantRecipe woodPickaxe;
    MerchantRecipe stonePickaxe;
    MerchantRecipe stairs;
    MerchantRecipe ironPick;
    MerchantRecipe glowstone;
    MerchantRecipe goldaxe;


    Villager armor;
    MerchantRecipe helmet;
    MerchantRecipe leggings;
    MerchantRecipe boots;
    MerchantRecipe plate1;
    MerchantRecipe plate2;
    MerchantRecipe plate3;
    MerchantRecipe pumpkin;
    MerchantRecipe firework;


    Villager swords;
    MerchantRecipe sword1;
    MerchantRecipe sword2;
    MerchantRecipe sword3;
    MerchantRecipe tnt;
    MerchantRecipe flintASteel;
    MerchantRecipe chest;
    MerchantRecipe redChest;
    MerchantRecipe hopper;


    Villager extras;
    MerchantRecipe bow1;
    MerchantRecipe bow2;
    MerchantRecipe bow3;
    MerchantRecipe arrow;
    MerchantRecipe beef;
    MerchantRecipe goldApple;
    MerchantRecipe cobweb;
    MerchantRecipe extraGold;


    public Rush_Listeners(Rush_Main main)
    {
        classMain = main;
    }

    public void onEntityInteract(PlayerInteractEntityEvent event)
    {
        Player player = event.getPlayer();
        if (event.getRightClicked() instanceof Villager)
        {
            player.closeInventory();
            openInventory(player, "test01");
        }
    }

    public void openInventory(Player player, String name)
    {
        if (name.equals("test01"))
        {

            return;
        }
    }


    private void createRecipe()
    {
        ItemStack bronze = new ItemStack(Material.CLAY_BRICK);
        ItemStack silver = new ItemStack(Material.IRON_BARDING);
        ItemStack gold = new ItemStack(Material.GOLD_BARDING);
        sandstone = new MerchantRecipe(new ItemStack(Material.SANDSTONE,4),Integer.MAX_VALUE);
        bronze.setAmount(1);
        sandstone.addIngredient(bronze);


    }
}
