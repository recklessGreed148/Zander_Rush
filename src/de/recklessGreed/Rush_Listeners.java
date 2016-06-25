package de.recklessGreed;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

/**
 * Created by dawen on 03.06.2016.
 */
public class Rush_Listeners implements Listener
{
    Rush_Main classMain;

    Villager blocks = null;
    MerchantRecipe sandstone;
    MerchantRecipe endstone;
    MerchantRecipe woodPickaxe;
    MerchantRecipe stonePickaxe;
    MerchantRecipe stairs;
    MerchantRecipe ironPickaxe;
    MerchantRecipe glowstone;
    MerchantRecipe goldaxe;


    Villager armor = null;
    MerchantRecipe helmet;
    MerchantRecipe leggings;
    MerchantRecipe boots;
    MerchantRecipe plate1;
    MerchantRecipe plate2;
    MerchantRecipe plate3;
    MerchantRecipe pumpkin;
    MerchantRecipe firework;


    Villager swords = null;
    MerchantRecipe sword1;
    MerchantRecipe sword2;
    MerchantRecipe sword3;
    MerchantRecipe tnt;
    MerchantRecipe flintASteel;
    MerchantRecipe chest;
    MerchantRecipe redChest;
    MerchantRecipe hopper;


    Villager extras = null;
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
        ItemStack silver = new ItemStack(Material.IRON_INGOT);
        ItemStack gold = new ItemStack(Material.GOLD_INGOT);

        //1 Bronze -> 4 Sandstone
        sandstone = new MerchantRecipe(new ItemStack(Material.SANDSTONE,4),Integer.MAX_VALUE);
        bronze.setAmount(1);
        sandstone.addIngredient(bronze);

        //4 Bronze -> 1 Endstone
        endstone = new MerchantRecipe(new ItemStack(Material.ENDER_STONE,1), Integer.MAX_VALUE);
        bronze.setAmount(4);
        endstone.addIngredient(bronze);

        //4 Bronze -> 1 Wood Pickaxe
        ItemStack woodPickItem = new ItemStack(Material.WOOD_PICKAXE,1);
        woodPickItem.addEnchantment(Enchantment.DIG_SPEED, 1);
        woodPickaxe = new MerchantRecipe(woodPickItem, Integer.MAX_VALUE);
        bronze.setAmount(4);
        woodPickaxe.addIngredient(bronze);

        //2 Silver -> 1 Stone Pickaxe
        ItemStack stonePickItem = new ItemStack(Material.STONE_PICKAXE,1);
        stonePickItem.addEnchantment(Enchantment.DIG_SPEED, 2);
        stonePickaxe = new MerchantRecipe(stonePickItem,Integer.MAX_VALUE);
        silver.setAmount(2);
        stonePickaxe.addIngredient(silver);

        //5 Bronze, 1 Sandstone -> 4 Stairs
        stairs = new MerchantRecipe(new ItemStack(Material.SANDSTONE_STAIRS,4),Integer.MAX_VALUE);
        bronze.setAmount(5);
        stairs.addIngredient(bronze);
        stairs.addIngredient(new ItemStack(Material.SANDSTONE, 1));

        //1 Gold -> 1 Iron Pickaxe
        ItemStack ironPickItem = new ItemStack(Material.IRON_PICKAXE,1);
        ironPickItem.addEnchantment(Enchantment.DIG_SPEED, 3);
        ironPickaxe = new MerchantRecipe(ironPickItem ,Integer.MAX_VALUE);

        //4 Bronze -> 2 Glowstone
        glowstone = new MerchantRecipe(new ItemStack(Material.GLOWSTONE,2), Integer.MAX_VALUE);
        bronze.setAmount(4);
        glowstone.addIngredient(bronze);

        //3 Iron, 1 Wood Pickaxe -> 1 Goldaxe
        goldaxe = new MerchantRecipe(new ItemStack(Material.GOLD_AXE,1), Integer.MAX_VALUE);
        silver.setAmount(3);
        goldaxe.addIngredient(silver);
        goldaxe.addIngredient(woodPickItem);


        //1 Bronze -> Leather Helmet
        //1 Bronze -> Leather Leggings
        //1 Bronze -> Leather Boots
        //1 Silver -> Chain Plate
        //3 Silver -> Chain Plate II
        //7 Silver -> Chain Plate III
        //10 Iron, 1 Helmet -> OP Pumpkin
        //1 Gold -> 1 Firework

        //1 Silver -> Gold Sword I
        //3 Silver -> Gold Sword II
        //7 Silver -> Gold Sword III
        //3 Silver -> TNT
        //1 Gold -> Flint and Steel
        //1 Silver -> Chest
        //2 Silver -> Redstone Chest
        //5 Silver -> Hopper

        //3 Gold -> Bow I
        //7 Gold -> Bow II
        //12 Gold -> Bow III
        //1 Gold -> Arrow
        //4 Bronze -> 2 Steaks
        //1 Silver -> GoldApple
        //3 Eisen -> Cobweb
        //Bed -> 9 Gold


    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event)
    {
        if(blocks == null || armor  == null || swords == null  || extras == null)
            createRecipe();
    }
}
