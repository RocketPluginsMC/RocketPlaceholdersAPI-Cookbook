package me.lorenzo0111.rpcookbook;

import me.lorenzo0111.rocketplaceholders.api.RocketPlaceholdersAPI;
import me.lorenzo0111.rpcookbook.command.CreateCommand;
import me.lorenzo0111.rpcookbook.command.ListCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Objects;

public final class RpCookbook extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Enabling " + this.getDescription().getName() + " v" + this.getDescription().getVersion());

        RocketPlaceholdersAPI api = Bukkit.getServicesManager().load(RocketPlaceholdersAPI.class);
        if (api != null) {
            this.getCommand("rpcreate").setExecutor(new CreateCommand(api));
            this.getCommand("rplist").setExecutor(new ListCommand(api));
        } else {
            this.getLogger().severe("Unable to find RocketPlaceholdersAPI, disabling..");
            this.getServer().getPluginManager().disablePlugin(this);
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    @NotNull
    public PluginCommand getCommand(String name) {
        PluginCommand command = this.getServer().getPluginCommand(name.toLowerCase(Locale.ROOT));

        Objects.requireNonNull(command);

        return command;
    }

}
