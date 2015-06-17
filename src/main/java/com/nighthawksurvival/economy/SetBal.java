package com.nighthawksurvival.economy;

import com.nighthawksurvival.util.MSG;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * ************
 * |NSEconomy
 * |Nathan Cole
 * |5/11/2015
 * ************
 */

public class SetBal implements CommandExecutor
{

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getName().equals("balance") && sender.hasPermission("ns.econ"))
        {
            Player player = (Player) sender;

            if (args.length == 0)
            {
                player.sendMessage(MSG.economyMSG() + ChatColor.YELLOW + "Balance" + ChatColor.GRAY + ": " + ChatColor.GREEN + "$" + ChatColor.BLUE + Economy.getBal(player));
                return true;
            }
            if (args.length == 2) {
                if (player.hasPermission("ns.econ.admin")) {
                    if (args[0].equalsIgnoreCase("set")) {
                        Economy.setBal(player, Integer.parseInt(args[1]));
                        player.sendMessage(MSG.economyMSG() + ChatColor.YELLOW + "You have set your balance to " + ChatColor.GREEN + "$" + ChatColor.BLUE + args[1]);
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("add")) {
                        Economy.setBal(player, Economy.getBal(player) + Integer.parseInt(args[1]));
                        player.sendMessage(MSG.economyMSG() + ChatColor.YELLOW + "You have added " + ChatColor.GREEN + "$" + ChatColor.BLUE + args[1] + ChatColor.YELLOW + " to your balance.");
                        return true;
                    }
                }
            }
            if (args.length == 3)
            {
                if (args[0] == null)
                {
                    player.sendMessage(MSG.syntaxError());
                    return true;
                }
                if (args[1] == null)
                {
                    player.sendMessage(MSG.syntaxError());
                    return true;
                }
                if (args[2] == null)
                {
                    player.sendMessage(MSG.syntaxError());
                    return true;
                }
                if (args[0].equalsIgnoreCase("pay")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null) {
                        player.sendMessage(MSG.error());
                        return true;
                    }
                    if (target == player)
                    {
                        player.sendMessage(MSG.economyMSG() + ChatColor.RED + "You can't send yourself money!");
                        return true;
                    }
                    int bal = Integer.parseInt(args[2]);
                    int pbal = Economy.getBal(player) - bal;
                    if (Economy.getBal(player) < bal)
                    {
                        player.sendMessage(MSG.economyMSG() + ChatColor.RED + "You have insufficient funds!");
                        return true;
                    }
                    Economy.setBal(target, bal);
                    Economy.setBal(player, pbal);
                    player.sendMessage(MSG.economyMSG() + ChatColor.YELLOW + "You have paid " + ChatColor.BLUE + target.getName() + ChatColor.GREEN + " $" + ChatColor.BLUE + args[2]);
                    target.sendMessage(MSG.economyMSG() + ChatColor.BLUE + player.getName() + ChatColor.YELLOW + " has paid you " + ChatColor.GREEN + "$" + ChatColor.BLUE + args[2]);
                    return true;
                }
            }
            if (args.length == 1)
            {
                Player target = Bukkit.getPlayer(args[0]);
                if (Bukkit.getPlayer(args[0]) != target)
                {
                    player.sendMessage(MSG.error());
                    return true;
                }
                player.sendMessage(MSG.economyMSG() + ChatColor.BLUE + target.getName() + "'s" + ChatColor.YELLOW + " balance is " + ChatColor.GREEN + "$" + ChatColor.BLUE + Economy.getBal(target));
            }
            else
            {
                player.sendMessage(MSG.error());
                return true;
            }
        }
        return true;
    }
}
