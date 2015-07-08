package com.nighthawksurvival.economy.shopinventory;

import com.nighthawksurvival.economy.Economy;
import com.nighthawksurvival.economy.manager.ShopManager;
import com.nighthawksurvival.util.Item;
import com.nighthawksurvival.util.MSG;
import com.nighthawksurvival.util.WGUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.io.File;

import static com.nighthawksurvival.util.Item.*;

/**
 * ************
 * |NSEconomy
 * |Nathan Cole
 * |6/8/2015
 * ************
 */
public class Shop implements Listener, CommandExecutor
{

    private static Inventory mainpage;
    private static Inventory food;
    private static Inventory tools;
    private static Inventory combat;
    private static Inventory brewing;
    private static Inventory materials;
    private static Inventory buildingBlocks;
    private static Inventory decorationBlocks;
    private static Inventory redstone;
    private static Inventory transportation;
    private static Inventory miscellaneous;
    private static ItemStack plant = new ItemStack(Material.DOUBLE_PLANT, 1, (short) 0, (byte) 5);
    private static ItemStack mp = custom(new ItemStack(Material.BOOK), ChatColor.GOLD + "Main Page", ChatColor.YELLOW + "Goes to the", ChatColor.YELLOW + "Main Page");
    private static ItemStack fo = Item.custom(new ItemStack(Material.APPLE), ChatColor.DARK_RED + "Food", ChatColor.RED + "Goes to the", ChatColor.RED + "Foods");
    private static ItemStack to = Item.custom(new ItemStack(Material.IRON_AXE), ChatColor.DARK_GRAY + "Tools", ChatColor.GRAY + "Goes to the", ChatColor.GRAY + "Tools");
    private static ItemStack co = Item.custom(new ItemStack(Material.GOLD_SWORD), ChatColor.DARK_AQUA + "Combat", ChatColor.AQUA + "Goes to the", ChatColor.AQUA + "Combat");
    private static ItemStack be = Item.custom(new ItemStack(Material.POTION), ChatColor.DARK_GREEN + "Brewing", ChatColor.GREEN + "Goes to the", ChatColor.GREEN + "Brewing");
    private static ItemStack ma = Item.custom(new ItemStack(Material.STICK), ChatColor.DARK_PURPLE + "Materials", ChatColor.LIGHT_PURPLE + "Goes to the", ChatColor.LIGHT_PURPLE + "Materials");
    private static ItemStack bb = Item.custom(new ItemStack(Material.BRICK), ChatColor.DARK_GRAY + "Building Blocks", ChatColor.GRAY + "Goes to the", ChatColor.GRAY + "Building Blocks");
    private static ItemStack db = Item.custom(plant, ChatColor.DARK_AQUA + "Decoration Blocks", ChatColor.AQUA + "Goes to the", ChatColor.AQUA + "Decoration Blocks");
    private static ItemStack re = Item.custom(new ItemStack(Material.REDSTONE), ChatColor.DARK_GREEN + "Redstone", ChatColor.GREEN + "Goes to the", ChatColor.GREEN + "Redstone");
    private static ItemStack tr = Item.custom(new ItemStack(Material.MINECART), ChatColor.DARK_BLUE + "Transportation", ChatColor.BLUE + "Goes to the", ChatColor.BLUE + "Transportation");
    private static ItemStack mi = Item.custom(new ItemStack(Material.LAVA_BUCKET), ChatColor.DARK_GREEN + "Miscellaneous", ChatColor.GREEN + "Goes to the", ChatColor.GREEN + "Miscellaneous");
    private static ItemStack exit = Item.custom(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0, (byte) 15), ChatColor.DARK_GRAY + "--X--", ChatColor.GRAY + "Exit");
    private static ItemStack air = new ItemStack(Material.AIR);
    private static String shop = ChatColor.YELLOW + "" + ChatColor.BOLD + "SHOP" + ChatColor.DARK_GRAY + " - ";
    private static File file;
    private static FileConfiguration fileConfiguration;

    public static void setMainpage()
    {
        mainpage = Bukkit.createInventory(null, 45, ChatColor.YELLOW + "" + ChatColor.BOLD + "SHOP" + ChatColor.DARK_GRAY + " - " + ChatColor.BLUE + "Main Page");
        mainpage.setItem(11, fo);
        mainpage.setItem(13, to);
        mainpage.setItem(15, co);
        mainpage.setItem(19, be);
        mainpage.setItem(21, ma);
        mainpage.setItem(23, bb);
        mainpage.setItem(25, db);
        mainpage.setItem(29, re);
        mainpage.setItem(31, tr);
        mainpage.setItem(33, mi);
        mainpage.setItem(0, exit);
        mainpage.setItem(1, exit);
        mainpage.setItem(2, exit);
        mainpage.setItem(3, exit);
        mainpage.setItem(4, exit);
        mainpage.setItem(5, exit);
        mainpage.setItem(6, exit);
        mainpage.setItem(7, exit);
        mainpage.setItem(8, exit);
        mainpage.setItem(36, exit);
        mainpage.setItem(37, exit);
        mainpage.setItem(38, exit);
        mainpage.setItem(39, exit);
        mainpage.setItem(40, exit);
        mainpage.setItem(41, exit);
        mainpage.setItem(42, exit);
        mainpage.setItem(43, exit);
        mainpage.setItem(44, exit);
    }

    public static void setFood()
    {
        food = Bukkit.createInventory(null, 36, shop + ChatColor.BLUE + "Food");
        ItemStack[] itemStacks = new ItemStack[]{
                shop(new ItemStack(Material.APPLE), 8),
                shop(new ItemStack(Material.MUSHROOM_SOUP), 1),
                shop(new ItemStack(Material.BREAD), 8),
                shop(new ItemStack(Material.PORK), 8),
                shop(new ItemStack(Material.GRILLED_PORK), 8),
                shop(new ItemStack(Material.GOLDEN_APPLE), 1),
                shop(new ItemStack(Material.RAW_FISH), 8),
                shop(new ItemStack(Material.COOKED_FISH), 8),
                shop(new ItemStack(Material.CAKE), 1),
                shop(new ItemStack(Material.COOKIE), 8),
                shop(new ItemStack(Material.MELON), 8),
                shop(new ItemStack(Material.RAW_BEEF), 8),
                shop(new ItemStack(Material.COOKED_BEEF), 8),
                shop(new ItemStack(Material.RAW_CHICKEN), 8),
                shop(new ItemStack(Material.COOKED_CHICKEN), 8),
                shop(new ItemStack(Material.ROTTEN_FLESH), 8),
                shop(new ItemStack(Material.SPIDER_EYE), 8),
                shop(new ItemStack(Material.CARROT_ITEM), 8),
                shop(new ItemStack(Material.POTATO_ITEM), 8),
                shop(new ItemStack(Material.BAKED_POTATO), 8),
                shop(new ItemStack(Material.POISONOUS_POTATO), 8),
                shop(new ItemStack(Material.PUMPKIN_PIE), 1),
                shop(new ItemStack(Material.RABBIT), 8),
                shop(new ItemStack(Material.COOKED_RABBIT), 8),
                shop(new ItemStack(Material.RABBIT_STEW), 1),
                shop(new ItemStack(Material.MUTTON), 8),
                shop(new ItemStack(Material.COOKED_MUTTON), 8),
        };
        food.setContents(itemStacks);
        food.setItem(35, exit);
        food.setItem(34, exit);
        food.setItem(33, exit);
        food.setItem(32, exit);
        food.setItem(31, mp);
        food.setItem(30, exit);
        food.setItem(29, exit);
        food.setItem(28, exit);
        food.setItem(27, exit);
    }

    public static void setTools()
    {
        tools = Bukkit.createInventory(null, 36, shop + ChatColor.BLUE + "Tools");
        ItemStack[] toolss = new ItemStack[]{
                shop(new ItemStack(Material.WOOD_AXE), 1),
                shop(new ItemStack(Material.WOOD_HOE), 1),
                shop(new ItemStack(Material.WOOD_PICKAXE), 1),
                shop(new ItemStack(Material.WOOD_SPADE), 1),
                shop(new ItemStack(Material.STONE_AXE), 1),
                shop(new ItemStack(Material.STONE_HOE), 1),
                shop(new ItemStack(Material.STONE_PICKAXE), 1),
                shop(new ItemStack(Material.STONE_SPADE), 1),
                shop(new ItemStack(Material.IRON_AXE), 1),
                shop(new ItemStack(Material.IRON_HOE), 1),
                shop(new ItemStack(Material.IRON_PICKAXE), 1),
                shop(new ItemStack(Material.IRON_SPADE), 1),
                shop(new ItemStack(Material.GOLD_AXE), 1),
                shop(new ItemStack(Material.GOLD_HOE), 1),
                shop(new ItemStack(Material.GOLD_PICKAXE), 1),
                shop(new ItemStack(Material.GOLD_SPADE), 1),
                shop(new ItemStack(Material.DIAMOND_AXE), 1),
                shop(new ItemStack(Material.DIAMOND_HOE), 1),
                shop(new ItemStack(Material.DIAMOND_PICKAXE), 1),
                shop(new ItemStack(Material.DIAMOND_SPADE), 1),
                shop(new ItemStack(Material.SHEARS), 1),
                shop(new ItemStack(Material.FISHING_ROD), 1),
                shop(new ItemStack(Material.FLINT_AND_STEEL), 1),
                shop(new ItemStack(Material.COMPASS), 1),
                shop(new ItemStack(Material.WATCH), 1),
                shop(new ItemStack(Material.LEASH), 1),
                shop(new ItemStack(Material.NAME_TAG), 1),
        };
        ItemStack[] tw = toolss.clone();
        tools.setContents(toolss);
        tools.setItem(31, mp);
        tools.setItem(32, exit);
        tools.setItem(33, exit);
        tools.setItem(34, exit);
        tools.setItem(35, exit);
        tools.setItem(30, exit);
        tools.setItem(29, exit);
        tools.setItem(28, exit);
        tools.setItem(27, exit);
    }

    public static void setCombat()
    {
        combat = Bukkit.createInventory(null, 36, shop + ChatColor.BLUE + "Combat");
        ItemStack[] combats = new ItemStack[]{
                shop(new ItemStack(Material.BOW), 1),
                shop(new ItemStack(Material.ARROW), 8),
                shop(new ItemStack(Material.WOOD_SWORD), 1),
                shop(new ItemStack(Material.STONE_SWORD), 1),
                shop(new ItemStack(Material.IRON_SWORD), 1),
                shop(new ItemStack(Material.GOLD_SWORD), 1),
                shop(new ItemStack(Material.DIAMOND_SWORD), 1),
                shop(new ItemStack(Material.LEATHER_HELMET), 1),
                shop(new ItemStack(Material.LEATHER_CHESTPLATE), 1),
                shop(new ItemStack(Material.LEATHER_LEGGINGS), 1),
                shop(new ItemStack(Material.LEATHER_BOOTS), 1),
                shop(new ItemStack(Material.CHAINMAIL_HELMET), 1),
                shop(new ItemStack(Material.CHAINMAIL_CHESTPLATE), 1),
                shop(new ItemStack(Material.CHAINMAIL_LEGGINGS), 1),
                shop(new ItemStack(Material.CHAINMAIL_BOOTS), 1),
                shop(new ItemStack(Material.IRON_HELMET), 1),
                shop(new ItemStack(Material.IRON_CHESTPLATE), 1),
                shop(new ItemStack(Material.IRON_LEGGINGS), 1),
                shop(new ItemStack(Material.IRON_BOOTS), 1),
                shop(new ItemStack(Material.GOLD_HELMET), 1),
                shop(new ItemStack(Material.GOLD_CHESTPLATE), 1),
                shop(new ItemStack(Material.GOLD_LEGGINGS), 1),
                shop(new ItemStack(Material.GOLD_BOOTS), 1),
                shop(new ItemStack(Material.DIAMOND_HELMET), 1),
                shop(new ItemStack(Material.DIAMOND_CHESTPLATE), 1),
                shop(new ItemStack(Material.DIAMOND_LEGGINGS), 1),
                shop(new ItemStack(Material.DIAMOND_BOOTS), 1),
        };
        combat.setContents(combats);
        combat.setItem(31, mp);
        combat.setItem(32, exit);
        combat.setItem(33, exit);
        combat.setItem(34, exit);
        combat.setItem(35, exit);
        combat.setItem(30, exit);
        combat.setItem(29, exit);
        combat.setItem(28, exit);
        combat.setItem(27, exit);
    }

    public static void setBrewing()
    {
        brewing = Bukkit.createInventory(null, 18, shop + ChatColor.BLUE + "Brewing");
        ItemStack[] brew = new ItemStack[]{
                shop(new ItemStack(Material.GHAST_TEAR), 8),
                shop(new ItemStack(Material.GLASS_BOTTLE), 8),
                shop(new ItemStack(Material.FERMENTED_SPIDER_EYE), 8),
                shop(new ItemStack(Material.BLAZE_POWDER), 8),
                shop(new ItemStack(Material.MAGMA_CREAM), 8),
                shop(new ItemStack(Material.BREWING_STAND_ITEM), 1),
                shop(new ItemStack(Material.SPECKLED_MELON), 8),
                shop(new ItemStack(Material.GOLDEN_CARROT), 8),
                shop(new ItemStack(Material.RABBIT_FOOT), 8),
        };
        brewing.setContents(brew);
        brewing.setItem(17,exit);
        brewing.setItem(16, exit);
        brewing.setItem(15,exit);
        brewing.setItem(14, exit);
        brewing.setItem(13,mp);
        brewing.setItem(12, exit);
        brewing.setItem(11,exit);
        brewing.setItem(10, exit);
        brewing.setItem(9,exit);
    }

    public static void setMaterials()
    {
        materials = Bukkit.createInventory(null, 45, shop + ChatColor.BLUE + "Materials");
        ItemStack[] mats = new ItemStack[]{
                shop(new ItemStack(Material.COAL), 8),
                shop(new ItemStack(Material.DIAMOND), 8),
                shop(new ItemStack(Material.IRON_INGOT), 8),
                shop(new ItemStack(Material.GOLD_INGOT), 8),
                shop(new ItemStack(Material.STICK), 8),
                shop(new ItemStack(Material.BOWL), 8),
                shop(new ItemStack(Material.STRING), 8),
                shop(new ItemStack(Material.FEATHER), 8),
                shop(new ItemStack(Material.SULPHUR), 8),
                shop(new ItemStack(Material.SEEDS), 8),
                shop(new ItemStack(Material.WHEAT), 8),
                shop(new ItemStack(Material.FLINT), 8),
                shop(new ItemStack(Material.LEATHER), 8),
                shop(new ItemStack(Material.CLAY_BRICK), 8),
                shop(new ItemStack(Material.CLAY_BALL), 8),
                shop(new ItemStack(Material.SUGAR_CANE), 8),
                shop(new ItemStack(Material.EGG), 8),
                shop(new ItemStack(Material.GLOWSTONE_DUST), 8),
                shop(new ItemStack(Material.SUGAR), 8),
                shop(new ItemStack(Material.PUMPKIN_SEEDS), 8),
                shop(new ItemStack(Material.MELON_SEEDS), 8),
                shop(new ItemStack(Material.BLAZE_ROD), 8),
                shop(new ItemStack(Material.GOLD_NUGGET), 8),
                shop(new ItemStack(Material.NETHER_STALK), 8),
                shop(new ItemStack(Material.EMERALD), 8),
                shop(new ItemStack(Material.NETHER_STAR), 8),
                shop(new ItemStack(Material.NETHER_BRICK_ITEM), 8),
                shop(new ItemStack(Material.QUARTZ), 8),
                shop(new ItemStack(Material.PRISMARINE_SHARD), 8),
                shop(new ItemStack(Material.PRISMARINE_CRYSTALS), 8),
                shop(new ItemStack(Material.RABBIT_HIDE), 8),
        };
        materials.setContents(mats);
        materials.setItem(31, exit);
        materials.setItem(32, exit);
        materials.setItem(33, exit);
        materials.setItem(34, exit);
        materials.setItem(35, exit);
        materials.setItem(36, exit);
        materials.setItem(37, exit);
        materials.setItem(38, exit);
        materials.setItem(39, exit);
        materials.setItem(40, mp);
        materials.setItem(41, exit);
        materials.setItem(42, exit);
        materials.setItem(43, exit);
        materials.setItem(44, exit);
    }

    public static void setBuildingBlocks()
    {
        buildingBlocks = Bukkit.createInventory(null, 45, shop + ChatColor.BLUE + "Building Blocks");
        ItemStack[] blocks = new ItemStack[]{
                shop(new ItemStack(Material.STONE), 8),
                shop(new ItemStack(Material.GRASS), 8),
                shop(new ItemStack(Material.DIRT), 8),
                shop(new ItemStack(Material.COBBLESTONE), 8),
                shop(new ItemStack(Material.WOOD), 8),
                shop(new ItemStack(Material.SAND), 8),
                shop(new ItemStack(Material.GRAVEL), 8),
                shop(new ItemStack(Material.LOG), 8),
                shop(new ItemStack(Material.GLASS), 8),
                shop(new ItemStack(Material.SANDSTONE), 8),
                shop(new ItemStack(Material.BRICK), 8),
                shop(new ItemStack(Material.BOOKSHELF), 8),
                shop(new ItemStack(Material.MOSSY_COBBLESTONE), 8),
                shop(new ItemStack(Material.OBSIDIAN), 8),
                shop(new ItemStack(Material.ICE), 8),
                shop(new ItemStack(Material.SNOW_BLOCK), 8),
                shop(new ItemStack(Material.CLAY), 8),
                shop(new ItemStack(Material.PUMPKIN), 8),
                shop(new ItemStack(Material.NETHERRACK), 8),
                shop(new ItemStack(Material.SOUL_SAND), 8),
                shop(new ItemStack(Material.GLOWSTONE), 8),
                shop(new ItemStack(Material.SMOOTH_BRICK), 8),
                shop(new ItemStack(Material.MELON_BLOCK), 8),
                shop(new ItemStack(Material.MYCEL), 8),
                shop(new ItemStack(Material.NETHER_BRICK), 8),
                shop(new ItemStack(Material.ENDER_STONE), 8),
                shop(new ItemStack(Material.QUARTZ_BLOCK), 8),
                shop(new ItemStack(Material.LOG_2), 8),
                shop(new ItemStack(Material.PRISMARINE), 8),
                shop(new ItemStack(Material.SEA_LANTERN), 8),
                shop(new ItemStack(Material.PACKED_ICE), 8),
                shop(new ItemStack(Material.RED_SANDSTONE), 8),
        };
        buildingBlocks.setContents(blocks);
        buildingBlocks.setItem(32, exit);
        buildingBlocks.setItem(33, exit);
        buildingBlocks.setItem(34, exit);
        buildingBlocks.setItem(35, exit);
        buildingBlocks.setItem(36, exit);
        buildingBlocks.setItem(37, exit);
        buildingBlocks.setItem(38, exit);
        buildingBlocks.setItem(39, exit);
        buildingBlocks.setItem(40, mp);
        buildingBlocks.setItem(41, exit);
        buildingBlocks.setItem(42, exit);
        buildingBlocks.setItem(43, exit);
        buildingBlocks.setItem(44, exit);
    }

    public static void setDecorationBlocks()
    {
        decorationBlocks = Bukkit.createInventory(null, 27, shop + ChatColor.BLUE + "Decoration Blocks");
        ItemStack[] blocks = new ItemStack[]{
                shop(new ItemStack(Material.WEB), 8),
                shop(new ItemStack(Material.TORCH), 8),
                shop(new ItemStack(Material.LADDER), 8),
                shop(new ItemStack(Material.CACTUS), 8),
                shop(new ItemStack(Material.FENCE), 8),
                shop(new ItemStack(Material.IRON_FENCE), 8),
                shop(new ItemStack(Material.THIN_GLASS), 8),
                shop(new ItemStack(Material.NETHER_FENCE), 8),
                shop(new ItemStack(Material.ENCHANTMENT_TABLE), 1),
                shop(new ItemStack(Material.ENDER_CHEST), 1),
                shop(new ItemStack(Material.ANVIL), 1),
                shop(new ItemStack(Material.SLIME_BLOCK), 1),
                shop(new ItemStack(Material.PAINTING), 2),
                shop(new ItemStack(Material.SIGN), 3),
                shop(new ItemStack(Material.BED), 1),
                shop(new ItemStack(Material.ITEM_FRAME), 4),
                shop(new ItemStack(Material.FLOWER_POT_ITEM), 1),
                shop(new ItemStack(Material.ARMOR_STAND), 1),
        };
        decorationBlocks.setContents(blocks);
        decorationBlocks.setItem(26, exit);
        decorationBlocks.setItem(25, exit);
        decorationBlocks.setItem(24, exit);
        decorationBlocks.setItem(23, exit);
        decorationBlocks.setItem(22, mp);
        decorationBlocks.setItem(21, exit);
        decorationBlocks.setItem(20, exit);
        decorationBlocks.setItem(19, exit);
        decorationBlocks.setItem(18, exit);
    }

    public static void setRedstone()
    {
        redstone = Bukkit.createInventory(null, 18, shop + ChatColor.BLUE + "Redstone");
        ItemStack[] redstones = new ItemStack[]{
                shop(new ItemStack(Material.DISPENSER), 1),
                shop(new ItemStack(Material.PISTON_STICKY_BASE), 1),
                shop(new ItemStack(Material.PISTON_BASE), 1),
                shop(new ItemStack(Material.REDSTONE_LAMP_OFF), 1),
                shop(new ItemStack(Material.TRIPWIRE_HOOK), 1),
                shop(new ItemStack(Material.DAYLIGHT_DETECTOR), 1),
                shop(new ItemStack(Material.HOPPER), 1),
                shop(new ItemStack(Material.DROPPER), 1),
                shop(new ItemStack(Material.REDSTONE), 1),
        };
        redstone.setContents(redstones);
        redstone.setItem(17, exit);
        redstone.setItem(16, exit);
        redstone.setItem(15,exit);
        redstone.setItem(14, exit);
        redstone.setItem(13,mp);
        redstone.setItem(12, exit);
        redstone.setItem(11,exit);
        redstone.setItem(10, exit);
        redstone.setItem(9,exit);
    }

    public static void setTransportation()
    {
        transportation = Bukkit.createInventory(null, 18, shop + ChatColor.BLUE + "Transportation");
        ItemStack[] trans = new ItemStack[]{
                shop(new ItemStack(Material.RAILS), 8),
                shop(new ItemStack(Material.MINECART), 1),
                shop(new ItemStack(Material.SADDLE), 1),
                shop(new ItemStack(Material.BOAT), 1),
                shop(new ItemStack(Material.CARROT_STICK), 1),
        };
        transportation.setContents(trans);
        transportation.setItem(13, mp);
        transportation.setItem(14, exit);
        transportation.setItem(15, exit);
        transportation.setItem(16, exit);
        transportation.setItem(17, exit);
        transportation.setItem(12, exit);
        transportation.setItem(11, exit);
        transportation.setItem(10, exit);
        transportation.setItem(9, exit);
        transportation.setItem(8, exit);
        transportation.setItem(7, exit);
        transportation.setItem(6, exit);
        transportation.setItem(5, exit);
    }

    public static void setMiscellaneous()
    {
        miscellaneous = Bukkit.createInventory(null, 27, shop + ChatColor.BLUE + "Miscellaneous");
        ItemStack[] misc = new ItemStack[]{
                shop(new ItemStack(Material.BEACON), 1),
                shop(new ItemStack(Material.BUCKET), 1),
                shop(new ItemStack(Material.SNOW_BALL), 1),
                shop(new ItemStack(Material.MILK_BUCKET), 1),
                shop(new ItemStack(Material.PAPER), 1),
                shop(new ItemStack(Material.BOOK), 1),
                shop(new ItemStack(Material.SLIME_BALL), 1),
                shop(new ItemStack(Material.BONE), 1),
                shop(new ItemStack(Material.ENDER_PEARL), 1),
                shop(new ItemStack(Material.BOOK_AND_QUILL), 1),
                shop(new ItemStack(Material.EMPTY_MAP), 1),
        };
        miscellaneous.setContents(misc);
        miscellaneous.setItem(22, mp);
        miscellaneous.setItem(23, exit);
        miscellaneous.setItem(24, exit);
        miscellaneous.setItem(25, exit);
        miscellaneous.setItem(26, exit);
        miscellaneous.setItem(21, exit);
        miscellaneous.setItem(20, exit);
        miscellaneous.setItem(19, exit);
        miscellaneous.setItem(18, exit);
        miscellaneous.setItem(17, exit);
        miscellaneous.setItem(16, exit);
        miscellaneous.setItem(15, exit);
        miscellaneous.setItem(14, exit);
        miscellaneous.setItem(13, exit);
        miscellaneous.setItem(12, exit);
        miscellaneous.setItem(11, exit);

    }

    public static void setup()
    {
        setFile();
        setMainpage();
        setFood();
        setTools();
        setCombat();
        setBrewing();
        setMaterials();
        setBuildingBlocks();
        setDecorationBlocks();
        setRedstone();
        setTransportation();
        setMiscellaneous();
    }

    public static void setFile() {
        try {
            file = new File("plugins/NSLib/shops.yml");
            if (!file.exists()) {
                file.createNewFile();
            }
            fileConfiguration = YamlConfiguration.loadConfiguration(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("shop")) {
            Player player = (Player) sender;
            if (WGUtil.canBuy(player)) {
                if (args.length == 0) {
                    player.openInventory(mainpage);
                    player.sendMessage(MSG.economyMSG() + "Shop interface has been opened");
                }
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reset")) {
                    setup();
                    player.sendMessage(MSG.economyMSG() + "The Shops were reset!");
                }
            }
        }
        return true;
    }

    @EventHandler
    public void onICLE(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory().equals(mainpage))
        {
            if (event.getCurrentItem().equals(exit))
            {
                player.closeInventory();
            }
            if (event.getCurrentItem().equals(fo))
            {
                player.openInventory(food);
            }
            else if (event.getCurrentItem().equals(to))
            {
                player.openInventory(tools);
            }
            else if (event.getCurrentItem().equals(co))
            {
                player.openInventory(combat);
            }
            else if (event.getCurrentItem().equals(be))
            {
                player.openInventory(brewing);
            }
            else if (event.getCurrentItem().equals(ma))
            {
                player.openInventory(materials);
            }
            else if (event.getCurrentItem().equals(bb))
            {
                player.openInventory(buildingBlocks);
            }
            else if (event.getCurrentItem().equals(db))
            {
                player.openInventory(decorationBlocks);
            }
            else if (event.getCurrentItem().equals(re))
            {
                player.openInventory(redstone);
            }
            else if (event.getCurrentItem().equals(tr))
            {
                player.openInventory(transportation);
            }
            else if (event.getCurrentItem().equals(mi))
            {
                player.openInventory(miscellaneous);
            }
            event.setCancelled(true);
        }
        else {
            if (event.getInventory().equals(food) || event.getInventory().equals(tools) || event.getInventory().equals(combat) || event.getInventory().equals(brewing) ||
                    event.getInventory().equals(materials) || event.getInventory().equals(buildingBlocks) || event.getInventory().equals(decorationBlocks) || event.getInventory().equals(redstone)
                    || event.getInventory().equals(transportation) || event.getInventory().equals(miscellaneous)) {
                if (event.getCurrentItem().equals(exit)) {
                    player.closeInventory();
                }
                if (WGUtil.canBuy(player))
                {
                    if (ShopManager.exists(event.getCurrentItem().getType().name())) {
                        ItemStack itemStack = null;
                        ItemStack godApple = shop(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 0, (byte) 1), 1);
                        String item = event.getCurrentItem().getType().toString();
                        PlayerInventory pi = player.getInventory();
                        int amount = 0;
                        int buy = 0;
                        int sell = 0;
                        if (ShopManager.hasByte(item)) {
                            itemStack = new ItemStack(event.getCurrentItem().getType(), amount, (short) 0, ShopManager.getByte(item));
                            player.sendMessage("has byte");
                        } else if (!ShopManager.hasByte(item)) {
                            itemStack = new ItemStack(event.getCurrentItem().getType(), amount);
                        }
                        //buy
                        if (event.isRightClick()) {
                            if (ShopManager.hasBuy(item)) {
                                if (ShopManager.cannotBuy(event.getCurrentItem())) {
                                    player.sendMessage(MSG.economyMSG() + ChatColor.RED + "You cannot buy this item for fucks sake");
                                    return;
                                }
                                //stack
                                if (event.isShiftClick()) {
                                    amount = 64;
                                    itemStack.setAmount(amount);
                                    buy = ShopManager.getBuy(item) * amount;
                                    if (event.getCurrentItem().equals(godApple)) {
                                        buy = 1500 * amount;
                                    }
                                    if (Economy.getBal(player) >= buy) {
                                        Economy.setBal(player, Economy.getBal(player) - buy);
                                        player.sendMessage(MSG.economyMSG() + ChatColor.YELLOW + "You have bought " + ChatColor.AQUA + amount + " " + item + ChatColor.YELLOW + " for " + ChatColor.GREEN + "$" + ChatColor.BLUE + buy);
                                        pi.addItem(itemStack);
                                        player.updateInventory();
                                    } else {
                                        player.sendMessage(MSG.economyMSG() + ChatColor.RED + "You do not have enough money to buy this!");
                                    }
                                }
                                //amount of clicked item
                                else {
                                    amount = event.getCurrentItem().getAmount();
                                    itemStack.setAmount(amount);
                                    buy = ShopManager.getBuy(item) * amount;
                                    if (Economy.getBal(player) >= buy) {
                                        Economy.setBal(player, Economy.getBal(player) - buy);
                                        player.sendMessage(MSG.economyMSG() + ChatColor.YELLOW + "You have bought " + ChatColor.AQUA + amount + " " + item + ChatColor.YELLOW + " for " + ChatColor.GREEN + "$" + ChatColor.BLUE + buy);
                                        pi.addItem(itemStack);
                                        player.updateInventory();
                                    } else {
                                        player.sendMessage(MSG.economyMSG() + ChatColor.RED + "You do not have enough money to buy this!");
                                    }
                                }
                            } else {
                                player.sendMessage(MSG.economyMSG() + ChatColor.RED + "This item can not be bought!");
                            }
                        }
                        //sell
                        else if (event.isLeftClick()) {
                            if (ShopManager.hasSell(item)) {
                                if (event.isShiftClick()) {
                                    amount = 64;
                                    itemStack.setAmount(amount);
                                    sell = ShopManager.getSell(item) * amount;
                                    if (pi.containsAtLeast(itemStack, amount)) {
                                        Economy.setBal(player, Economy.getBal(player) + sell);
                                        player.sendMessage(MSG.economyMSG() + ChatColor.YELLOW + "You have sold " + ChatColor.AQUA + amount + " " + item + ChatColor.YELLOW + " for " + ChatColor.GREEN + "$" + ChatColor.BLUE + sell);
                                        removeAmount(player, Material.getMaterial(item), amount);
                                        player.updateInventory();
                                    } else {
                                        player.sendMessage(MSG.economyMSG() + ChatColor.RED + "You do not have enough item(s) to sell!");
                                    }
                                } else {
                                    amount = event.getCurrentItem().getAmount();
                                    itemStack.setAmount(amount);
                                    sell = ShopManager.getSell(item) * amount;
                                    if (pi.containsAtLeast(itemStack, amount)) {
                                        Economy.setBal(player, Economy.getBal(player) + sell);
                                        player.sendMessage(MSG.economyMSG() + ChatColor.YELLOW + "You have sold " + ChatColor.AQUA + amount + " " + item + ChatColor.YELLOW + " for " + ChatColor.GREEN + "$" + ChatColor.BLUE + sell);
                                        removeAmount(player, Material.getMaterial(item), amount);
                                        player.updateInventory();
                                    } else {
                                        player.sendMessage(MSG.economyMSG() + ChatColor.RED + "You do not have enough item(s) to sell!");
                                    }
                                }
                            } else {
                                player.sendMessage(MSG.economyMSG() + ChatColor.RED + "This item can not be sold!");
                            }
                        }
                        player.sendMessage("BUY: " + ShopManager.getBuy(item) + " - SELL: " + ShopManager.getSell(item) + " + " + item);
                        player.updateInventory();
                        event.setCancelled(true);
                    }
                    else
                    {
                        if (event.getCurrentItem().equals(exit) || event.getCurrentItem().equals(air))
                        {
                            player.closeInventory();
                            event.setCancelled(true);
                            return;
                        }
                        if (event.getCurrentItem().equals(mp))
                        {
                            player.openInventory(mainpage);
                            event.setCancelled(true);
                            return;
                        }
                        player.sendMessage(MSG.economyMSG() + ChatColor.RED + "This item is not set!");
                        player.sendMessage("BUY: " + ShopManager.getBuy(event.getCurrentItem().getType().name()) + " - SELL: " + ShopManager.getSell(event.getCurrentItem().getType().name()) + " + " + event.getCurrentItem().getType().name());
                        event.setCancelled(true);
                    }
                    event.setCancelled(true);
                }
            }
        }
    }
}
