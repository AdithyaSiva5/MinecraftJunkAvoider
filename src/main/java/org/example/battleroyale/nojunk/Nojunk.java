package org.example.battleroyale.nojunk;

import org.bukkit.plugin.java.JavaPlugin;
import org.example.battleroyale.nojunk.commands.JunkCommand;
import org.example.battleroyale.nojunk.listeners.ItemPickupListener;
import org.example.battleroyale.nojunk.managers.PlayerSettingsManager;

public final class Nojunk extends JavaPlugin {
    private PlayerSettingsManager settingsManager;

    @Override
    public void onEnable() {
        // Initialize the settings manager
        settingsManager = new PlayerSettingsManager(this);

        // Register command
        getCommand("junk").setExecutor(new JunkCommand(this));

        // Register listeners
        getServer().getPluginManager().registerEvents(new ItemPickupListener(this), this);
    }

    @Override
    public void onDisable() {
        // Save all player settings
        if (settingsManager != null) {
            settingsManager.saveAllSettings();
        }
    }

    public PlayerSettingsManager getSettingsManager() {
        return settingsManager;
    }
}
