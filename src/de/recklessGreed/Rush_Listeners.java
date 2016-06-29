package de.recklessGreed;

import net.minecraft.server.v1_9_R2.Village;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
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

import java.util.LinkedList;

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
            Villager villager = (Villager) event.getRightClicked();
            player.closeInventory();

            if (villager.getName().equals("Schneider"))
            {
                player.openMerchant(armor, true);
            }
            else if (villager.getName().equals("Baumeister"))
            {
                player.openMerchant(blocks, true);
            }
            else if (villager.getName().equals("Krieger"))
            {
                player.openMerchant(swords, true);
            }
            else if (villager.getName().equals("Extras"))
            {
                player.openMerchant(extras, true);
            }

        }
    }

    private void createRecipe(Player p)
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
        woodPickItem.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);
        woodPickaxe = new MerchantRecipe(woodPickItem, Integer.MAX_VALUE);
        bronze.setAmount(4);
        woodPickaxe.addIngredient(bronze);

        //2 Silver -> 1 Stone Pickaxe
        ItemStack stonePickItem = new ItemStack(Material.STONE_PICKAXE,1);
        stonePickItem.addUnsafeEnchantment(Enchantment.DIG_SPEED, 2);
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
        ironPickItem.addUnsafeEnchantment(Enchantment.DIG_SPEED, 3);
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

        // Next Villager------------------------------------------------------------------------------------------------

        //1 Bronze -> Leather Helmet
        ItemStack helmetItem = new ItemStack(Material.LEATHER_HELMET, 1);
        helmetItem.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
        helmet = new MerchantRecipe(helmetItem,Integer.MAX_VALUE);
        bronze.setAmount(1);
        helmet.addIngredient(bronze);

        //1 Bronze -> Leather Leggings
        ItemStack leggingsItem = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        leggingsItem.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
        leggings = new MerchantRecipe(leggingsItem,Integer.MAX_VALUE);
        bronze.setAmount(1);
        leggings.addIngredient(bronze);

        //1 Bronze -> Leather Boots
        ItemStack bootsItem = new ItemStack(Material.LEATHER_BOOTS, 1);
        bootsItem.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
        boots = new MerchantRecipe(bootsItem,Integer.MAX_VALUE);
        bronze.setAmount(1);
        boots.addIngredient(bronze);

        //1 Silver -> Chain Plate
        ItemStack chain1Item = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        chain1Item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
        plate1 = new MerchantRecipe(chain1Item,Integer.MAX_VALUE);
        silver.setAmount(1);
        plate1.addIngredient(silver);

        //3 Silver -> Chain Plate II
        ItemStack chain2Item = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        chain2Item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
        plate2 = new MerchantRecipe(chain2Item,Integer.MAX_VALUE);
        silver.setAmount(3);
        plate2.addIngredient(silver);

        //7 Silver -> Chain Plate III
        ItemStack chain3Item = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        chain3Item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
        plate3 = new MerchantRecipe(chain3Item,Integer.MAX_VALUE);
        silver.setAmount(7);
        plate3.addIngredient(silver);

        //10 Iron, 1 Helmet -> OP Pumpkin
        ItemStack pumpkinItem = new ItemStack(Material.PUMPKIN, 1);
        pumpkinItem.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
        pumpkinItem.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE,5);
        pumpkinItem.addUnsafeEnchantment(Enchantment.THORNS,1);
        pumpkinItem.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS,5);
        pumpkin = new MerchantRecipe(pumpkinItem,Integer.MAX_VALUE);

        //1 Gold -> 1 Firework
        firework = new MerchantRecipe(new ItemStack(Material.FIREWORK, 1),Integer.MAX_VALUE);

        //Next Villager-------------------------------------------------------------------------------------------------

        //1 Silver -> Gold Sword I
        ItemStack sword1Item = new ItemStack(Material.GOLD_SWORD, 1);
        sword1Item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL,1);
        sword1 = new MerchantRecipe(sword1Item ,Integer.MAX_VALUE);
        silver.setAmount(1);
        sword1.addIngredient(silver);

        //3 Silver -> Gold Sword II
        ItemStack sword2Item = new ItemStack(Material.GOLD_SWORD, 1);
        sword2Item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL,2);
        sword2 = new MerchantRecipe(sword2Item ,Integer.MAX_VALUE);
        silver.setAmount(3);
        sword2.addIngredient(silver);

        //7 Silver -> Gold Sword III
        ItemStack sword3Item = new ItemStack(Material.GOLD_SWORD, 1);
        sword3Item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL,2);
        sword3Item.addUnsafeEnchantment(Enchantment.KNOCKBACK,1);
        sword3 = new MerchantRecipe(sword3Item ,Integer.MAX_VALUE);
        silver.setAmount(7);
        sword3.addIngredient(silver);

        //3 Silver -> TNT
        tnt = new MerchantRecipe(new ItemStack(Material.TNT, 1),Integer.MAX_VALUE);
        silver.setAmount(3);
        tnt.addIngredient(silver);

        //1 Gold -> Flint and Steel
        flintASteel = new MerchantRecipe(new ItemStack(Material.FLINT_AND_STEEL, 1),Integer.MAX_VALUE);
        gold.setAmount(1);
        flintASteel.addIngredient(gold);

        //1 Silver -> Chest
        chest = new MerchantRecipe(new ItemStack(Material.CHEST, 1),Integer.MAX_VALUE);
        silver.setAmount(1);
        chest.addIngredient(silver);

        //2 Silver -> Redstone Chest
        redChest = new MerchantRecipe(new ItemStack(Material.TRAPPED_CHEST, 1),Integer.MAX_VALUE);
        silver.setAmount(2);
        redChest.addIngredient(silver);

        //5 Silver -> Hopper
        hopper = new MerchantRecipe(new ItemStack(Material.HOPPER, 1),Integer.MAX_VALUE);
        silver.setAmount(5);
        hopper.addIngredient(silver);

        //Next Villager-------------------------------------------------------------------------------------------------

        //3 Gold -> Bow I
        ItemStack bow1Item = new ItemStack(Material.BOW, 1);
        bow1Item.addUnsafeEnchantment(Enchantment.ARROW_INFINITE,1);
        bow1 = new MerchantRecipe(bow1Item,Integer.MAX_VALUE);
        gold.setAmount(3);
        bow1.addIngredient(gold);

        //7 Gold -> Bow II
        ItemStack bow2Item = new ItemStack(Material.BOW, 1);
        bow2Item.addUnsafeEnchantment(Enchantment.ARROW_INFINITE,1);
        bow2Item.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE,1);
        bow2 = new MerchantRecipe(bow2Item,Integer.MAX_VALUE);
        gold.setAmount(7);
        bow2.addIngredient(gold);

        //12 Gold -> Bow III
        ItemStack bow3Item = new ItemStack(Material.BOW, 1);
        bow3Item.addUnsafeEnchantment(Enchantment.ARROW_INFINITE,1);
        bow3Item.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE,2);
        bow3 = new MerchantRecipe(bow3Item,Integer.MAX_VALUE);
        gold.setAmount(12);
        bow3.addIngredient(gold);

        //1 Gold -> Arrow
        arrow = new MerchantRecipe(new ItemStack(Material.ARROW, 1),Integer.MAX_VALUE);
        gold.setAmount(1);
        arrow.addIngredient(gold);

        //4 Bronze -> 2 Steaks
        beef = new MerchantRecipe(new ItemStack(Material.COOKED_BEEF, 1),Integer.MAX_VALUE);
        bronze.setAmount(4);
        beef.addIngredient(bronze);

        //1 Silver -> GoldApple
        goldApple = new MerchantRecipe(new ItemStack(Material.GOLDEN_APPLE, 1),Integer.MAX_VALUE);
        silver.setAmount(1);
        goldApple.addIngredient(silver);

        //3 Eisen -> Cobweb
        cobweb = new MerchantRecipe(new ItemStack(Material.WEB, 1),Integer.MAX_VALUE);
        silver.setAmount(3);
        cobweb.addIngredient(silver);

        //Bed -> 9 Gold
        gold.setAmount(9);
        extraGold = new MerchantRecipe(gold,Integer.MAX_VALUE);
        extraGold.addIngredient(new ItemStack(Material.BED));

        Location loc = new Location(p.getWorld(), 0,0,0);

        blocks = (Villager) p.getWorld().spawnEntity(loc, EntityType.VILLAGER);
        LinkedList<MerchantRecipe> blocksList = new LinkedList<>();
        blocksList.add(sandstone);
        blocksList.add(endstone);
        blocksList.add(woodPickaxe);
        blocksList.add(stonePickaxe);
        blocksList.add(stairs);
        blocksList.add(ironPickaxe);
        blocksList.add(glowstone);
        blocksList.add(goldaxe);
        blocks.setRecipes(blocksList);
        blocks.remove();

        armor  = (Villager) p.getWorld().spawnEntity(loc, EntityType.VILLAGER);
        LinkedList<MerchantRecipe> armorList = new LinkedList<>();
        armorList.add(helmet);
        armorList.add(leggings);
        armorList.add(boots);
        armorList.add(plate1);
        armorList.add(plate2);
        armorList.add(plate3);
        armorList.add(pumpkin);
        armorList.add(firework);
        armor.setRecipes(armorList);
        armor.remove();


        swords = (Villager) p.getWorld().spawnEntity(loc, EntityType.VILLAGER);
        LinkedList<MerchantRecipe> swordsList = new LinkedList<>();
        swordsList.add(sword1);
        swordsList.add(sword2);
        swordsList.add(sword3);
        swordsList.add(tnt);
        swordsList.add(flintASteel);
        swordsList.add(chest);
        swordsList.add(redChest);
        swordsList.add(hopper);
        swords.setRecipes(swordsList);
        swords.remove();

        extras = (Villager) p.getWorld().spawnEntity(loc, EntityType.VILLAGER);
        LinkedList<MerchantRecipe> extrasList = new LinkedList<>();
        extrasList.add( bow1);
        extrasList.add( bow2);
        extrasList.add( bow2);
        extrasList.add( arrow);
        extrasList.add( beef);
        extrasList.add( goldApple);
        extrasList.add( cobweb);
        extrasList.add( extraGold);
        extras.setRecipes(extrasList);
        extras.remove();

    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        //if(blocks == null || armor  == null || swords == null  || extras == null)
          //  createRecipe(player);

        if(player.getWorld().getName() != "lobby")
        {
            player.teleport(classMain.getSpawnLobbyLoc());
        }
    }
}
