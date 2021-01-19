package me.lorenzo0111.rpcookbook.command;

import me.lorenzo0111.rocketplaceholders.RocketPlaceholders;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ListCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage(ChatColor.GREEN + "Internal: " + ChatColor.GRAY + RocketPlaceholders.getApi().getInternalPlaceholders().getStorageManager().getInternalPlaceholders().getHashMap());

        sender.sendMessage(ChatColor.GREEN + "External: " + ChatColor.GRAY + RocketPlaceholders.getApi().getInternalPlaceholders().getStorageManager().getExternalPlaceholders().getHashMap());

        return true;
    }
}
