package org.example.battleroyale.nojunk.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.example.battleroyale.nojunk.Nojunk;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class PlayerSettingsManager {
    private final Nojunk plugin;
    private final Map<UUID, Set<org.example.battleroyale.nojunk.managers.ItemCategory>> playerSettings;
    private final File dataFile;
    private FileConfiguration data;

    public PlayerSettingsManager(Nojunk plugin) {
        this.plugin = plugin;
        this.playerSettings = new HashMap<>();
        this.dataFile = new File(plugin.getDataFolder(), "playerdata.yml");
        loadSettings();
    }

    public void loadSettings() {
        if (!dataFile.exists()) {
            try {
                // Create plugin directory if it doesn't exist
                plugin.getDataFolder().mkdirs();
                // Create empty data file
                dataFile.createNewFile();
            } catch (IOException e) {
                plugin.getLogger().severe("Could not create playerdata.yml");
            }
        }
        data = YamlConfiguration.loadConfiguration(dataFile);

        // Load existing settings
        if (data != null) {
            for (String uuidString : data.getKeys(false)) {
                UUID playerUUID = UUID.fromString(uuidString);
                List<String> categoryNames = data.getStringList(uuidString);
                Set<org.example.battleroyale.nojunk.managers.ItemCategory> categories = new HashSet<>();

                for (String categoryName : categoryNames) {
                    try {
                        categories.add(org.example.battleroyale.nojunk.managers.ItemCategory.valueOf(categoryName));
                    } catch (IllegalArgumentException ignored) {
                        // Skip invalid category names
                    }
                }

                playerSettings.put(playerUUID, categories);
            }
        }
    }

    public Set<org.example.battleroyale.nojunk.managers.ItemCategory> getPlayerSettings(UUID playerUUID) {
        return playerSettings.getOrDefault(playerUUID, new HashSet<>());
    }

    public void toggleCategory(UUID playerUUID, org.example.battleroyale.nojunk.managers.ItemCategory category) {
        Set<org.example.battleroyale.nojunk.managers.ItemCategory> settings = playerSettings.computeIfAbsent(playerUUID, k -> new HashSet<>());
        if (settings.contains(category)) {
            settings.remove(category);
        } else {
            settings.add(category);
        }
        saveSettings(playerUUID);
    }

    public void saveSettings(UUID playerUUID) {
        Set<org.example.battleroyale.nojunk.managers.ItemCategory> settings = playerSettings.get(playerUUID);
        if (settings != null) {
            List<String> categoryNames = new ArrayList<>();
            for (org.example.battleroyale.nojunk.managers.ItemCategory category : settings) {
                categoryNames.add(category.name());
            }
            data.set(playerUUID.toString(), categoryNames);
            try {
                data.save(dataFile);
            } catch (IOException e) {
                plugin.getLogger().severe("Could not save settings for player " + playerUUID);
            }
        }
    }

    public void saveAllSettings() {
        for (UUID playerUUID : playerSettings.keySet()) {
            saveSettings(playerUUID);
        }
    }
}
