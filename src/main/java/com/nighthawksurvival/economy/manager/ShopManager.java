package com.nighthawksurvival.economy.manager;

import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.List;

/**
 * ************
 * |NSEconomy
 * |Nathan Cole
 * |6/9/2015
 * ************
 */
public class ShopManager
{

    private static File file = new File("plugins/NSLib/shops.yml");
    private static FileConfiguration conf = YamlConfiguration.loadConfiguration(file);
    private static int am;
    private static List<ItemStack> cannotbuy = Lists.newArrayList(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 0, (byte) 1));

    public static boolean exists(String name)
    {
        return conf.isSet(name);
    }

    public static String get(String name)
    {
        return conf.getString(name);
    }

    public static boolean hasByte(String name)
    {
        return conf.isSet(name + ".byte");
    }

    public static byte getByte(String name)
    {
        return Byte.parseByte(conf.getString(name + ".byte"));
    }

    public static int getBuy(String name)
    {
        return conf.getInt(name + ".buy");
    }

    public static int getSell(String name)
    {
        return conf.getInt(name + ".sell");
    }

    public static boolean hasBuy(String name)
    {
        return conf.isSet(name + ".buy");
    }

    public static boolean hasSell(String name)
    {
        return conf.isSet(name + ".sell");
    }

    public static boolean cannotBuy(ItemStack itemStack)
    {
        return cannotbuy.contains(itemStack);
    }
}
