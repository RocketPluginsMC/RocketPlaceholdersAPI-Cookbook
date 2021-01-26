package me.lorenzo0111.rpcookbook.command;

import me.lorenzo0111.rocketplaceholders.api.PlaceholderBuilder;
import me.lorenzo0111.rocketplaceholders.api.RocketPlaceholdersAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CreateCommand implements CommandExecutor {
    private final RocketPlaceholdersAPI api;

    public CreateCommand(RocketPlaceholdersAPI api) {
        this.api = api;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 4) {
            sender.sendMessage(ChatColor.RED + "Try to use /example identifier text permission text");
            return true;
        }

        this.api.addPlaceholder(new PlaceholderBuilder(args[0], args[1]).createPermissionNode(args[2], args[3]).build());

        sender.sendMessage(ChatColor.GREEN + "Placeholder created!");

        return true;
    }
}
