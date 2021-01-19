package me.lorenzo0111.rpcookbook;

import me.lorenzo0111.rpcookbook.command.CreateCommand;
import me.lorenzo0111.rpcookbook.command.ListCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class RpCookbook extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Enabling " + this.getDescription().getName() + " v" + this.getDescription().getVersion());

        this.getCommand("rpcreate").setExecutor(new CreateCommand());
        this.getCommand("rplist").setExecutor(new ListCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
