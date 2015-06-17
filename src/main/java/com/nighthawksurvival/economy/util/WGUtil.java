package com.nighthawksurvival.economy.util;

import com.nighthawksurvival.economy.Economy;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * ************
 * |NSEconomy
 * |Nathan Cole
 * |6/13/2015
 * ************
 */
public class WGUtil
{


    public static boolean canBuy(Player p, Location l) {
        if (!Economy.isWGEnabled()) return true;
        ApplicableRegionSet set = WorldGuardPlugin.inst().getRegionManager(p.getWorld()).getApplicableRegions(l);
        if (set.size() > 0) {
            for (ProtectedRegion r : set.getRegions()) {
                if (r.getFlags().containsKey(DefaultFlag.ENABLE_SHOP) && r.getFlag(DefaultFlag.ENABLE_SHOP) == StateFlag.State.DENY) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean canBuy(Player player)
    {
        return canBuy(player, player.getLocation());
    }
}
