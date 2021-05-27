package me.lorenzo0111.rpcookbook.command;

import me.lorenzo0111.rocketplaceholders.api.PlaceholderBuilder;
import me.lorenzo0111.rocketplaceholders.api.RocketPlaceholdersAPI;
import me.lorenzo0111.rocketplaceholders.creator.conditions.types.HasPermissionCondition;
import me.lorenzo0111.rpcookbook.RpCookbook;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CreateCommand implements CommandExecutor {
    private final RocketPlaceholdersAPI api;

    public CreateCommand(RocketPlaceholdersAPI api) {
        this.api = api;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args.length != 4) {
            sender.sendMessage(ChatColor.RED + "Try to use /example identifier text permission text");
            return true;
        }

        this.api.addPlaceholder(new PlaceholderBuilder(args[0], RpCookbook.getPlugin(RpCookbook.class), args[1])
                .createConditionNode(new HasPermissionCondition(null, args[2]), args[3])
                .build());

        sender.sendMessage(ChatColor.GREEN + "Placeholder created!");

        return true;
    }
}
