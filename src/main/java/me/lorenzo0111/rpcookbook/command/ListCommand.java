package me.lorenzo0111.rpcookbook.command;

import me.lorenzo0111.rocketplaceholders.RocketPlaceholders;
import me.lorenzo0111.rocketplaceholders.api.RocketPlaceholdersAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ListCommand implements CommandExecutor {
    private final RocketPlaceholdersAPI api;

    public ListCommand(RocketPlaceholdersAPI api) {
        this.api = api;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage(ChatColor.GREEN + "Internal: " + ChatColor.GRAY + this.api.getInternalPlaceholders().getStorageManager().getInternalPlaceholders().getHashMap());

        sender.sendMessage(ChatColor.GREEN + "External: " + ChatColor.GRAY + this.api.getInternalPlaceholders().getStorageManager().getExternalPlaceholders().getHashMap());

        return true;
    }
}
