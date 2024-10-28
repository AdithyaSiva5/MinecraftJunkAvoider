package org.example.battleroyale.nojunk.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.example.battleroyale.nojunk.Nojunk;
import org.example.battleroyale.nojunk.managers.ItemCategory;

import java.util.Set;

public class ItemPickupListener implements Listener {
    private final Nojunk plugin;

    public ItemPickupListener(Nojunk plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getEntity();
        Set<ItemCategory> playerSettings = plugin.getSettingsManager().getPlayerSettings(player.getUniqueId());

        for (ItemCategory category : playerSettings) {
            if (category.contains(event.getItem().getItemStack())) {
                event.setCancelled(true);
                return;
            }
        }
    }
}
