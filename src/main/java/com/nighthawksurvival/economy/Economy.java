package com.nighthawksurvival.economy;

import com.nighthawksurvival.economy.shopinventory.Shop;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/**
 * ************
 * |NSEconomy
 * |Nathan Cole
 * |5/11/2015
 * ************
 */

public class Economy extends JavaPlugin
{
    private static PluginManager PM = Bukkit.getPluginManager();
    private static File config;
    private static FileConfiguration configuration;
    private static boolean WG_ENABLED;

    public static boolean hasAccount(Player player)
    {
        return configuration.isSet(player.getUniqueId().toString() + ".balance");
    }

    public static int getBal(Player player)
    {
        return configuration.getInt(player.getUniqueId().toString() + ".balance");
    }

    public static void setBal(Player player, Integer amount)
    {
        configuration.set(player.getUniqueId().toString() + ".balance", amount);
        savePlayers();
    }

    public static void savePlayers()
    {
        try {
            configuration.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isWGEnabled()
    {
        return WG_ENABLED;
    }

    public void onEnable()
    {
        Shop.setup();
        loadPlayers();
        Bukkit.getLogger().info("Shops have been setup!");
        PM.registerEvents(new Shop(), this);
        this.getCommand("shop").setExecutor(new Shop());
        if (Bukkit.getPluginManager().isPluginEnabled("WorldGuard"))
        {
            WG_ENABLED = true;
            Bukkit.getLogger().info("[NSEconomy] WorldGuard is enabled!");
        }
    }

    public void onDisable()
    {
    }

    public void loadPlayers()
    {
        config = new File("plugins/NSLib/players.yml");
        if (!config.exists()) {
            try {
                config.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        configuration = YamlConfiguration.loadConfiguration(config);
    }
}
