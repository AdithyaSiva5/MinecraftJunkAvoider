package org.example.battleroyale.nojunk.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.example.battleroyale.nojunk.Nojunk;
import org.example.battleroyale.nojunk.managers.ItemCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JunkCommand implements CommandExecutor, Listener {
    private final Nojunk plugin;
    private static final String GUI_TITLE = ChatColor.DARK_GRAY + "Junk Filter";

    public JunkCommand(Nojunk plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players!");
            return true;
        }

        Player player = (Player) sender;
        openJunkGUI(player);
        return true;
    }

    private void openJunkGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 9, GUI_TITLE);
        Set<ItemCategory> playerSettings = plugin.getSettingsManager().getPlayerSettings(player.getUniqueId());

        // Add category items
        for (ItemCategory category : ItemCategory.values()) {
            ItemStack icon = createCategoryIcon(category, playerSettings.contains(category));
            gui.addItem(icon);
        }

        // Add support creator item in the last slot
        ItemStack supportItem = new ItemStack(Material.DIAMOND);
        ItemMeta meta = supportItem.getItemMeta();
        meta.setDisplayName("§b§lSupport Creator");
        List<String> lore = new ArrayList<>();
        lore.add("§7Click to visit our");
        lore.add("§7support page!");
        lore.add("");
        lore.add("§e§lClick to open!");
        meta.setLore(lore);
        supportItem.setItemMeta(meta);
        gui.setItem(8, supportItem);

        player.openInventory(gui);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(GUI_TITLE)) {
            return;
        }

        event.setCancelled(true);

        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem != null && clickedItem.hasItemMeta()) {
            String displayName = ChatColor.stripColor(clickedItem.getItemMeta().getDisplayName());

            if (displayName.equals("Support Creator")) {
                player.closeInventory();
                sendSupportLink(player);
                return;
            }

            // Get the display name and convert it to category format
            String categoryName = displayName
                    .replace(" ", "_")
                    .replace("Nature_Items", "SEEDS_SAPLINGS_FLOWERS")
                    .replace("Monster_Drops", "MOB_DROPS")
                    .replace("Raw_Foods", "RAW_FOOD")
                    .replace("Raw_Minerals", "RAW_ORES")
                    .replace("Wood_Variants", "WOOD_ITEMS")
                    .replace("Stone_Types", "STONES")
                    .replace("Block_Blacklist", "NO_BLOCKS")
                    .replace("Item_Blacklist", "NO_ITEMS");

            try {
                ItemCategory category = ItemCategory.valueOf(categoryName.toUpperCase());
                plugin.getSettingsManager().toggleCategory(player.getUniqueId(), category);
                openJunkGUI(player);
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private void sendSupportLink(Player player) {
        TextComponent message = new TextComponent("§b§lClick here to support the creator!");
        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.youtube.com/@Qfie"));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("§eClick to open support page!").create()));
        player.spigot().sendMessage(message);
    }

    private ItemStack createCategoryIcon(ItemCategory category, boolean enabled) {
        Material iconMaterial;
        String displayName;
        List<String> description = new ArrayList<>();

        switch (category) {
            case SEEDS_SAPLINGS_FLOWERS:
                iconMaterial = Material.WHEAT_SEEDS;
                displayName = "§6§lNature Items";
                description.add("§7Filters out:");
                description.add("§8• Seeds");
                description.add("§8• Saplings");
                description.add("§8• Flowers");
                break;
            case MOB_DROPS:
                iconMaterial = Material.ROTTEN_FLESH;
                displayName = "§c§lMonster Drops";
                description.add("§7Filters out:");
                description.add("§8• Rotten Flesh");
                description.add("§8• Bones");
                description.add("§8• Spider Eyes");
                description.add("§8• Other monster items");
                break;
            case RAW_FOOD:
                iconMaterial = Material.BEEF;
                displayName = "§d§lRaw Foods";
                description.add("§7Filters out:");
                description.add("§8• Raw Meat");
                description.add("§8• Raw Fish");
                description.add("§8• Uncooked Foods");
                break;
            case RAW_ORES:
                iconMaterial = Material.RAW_IRON;
                displayName = "§b§lRaw Minerals";
                description.add("§7Filters out:");
                description.add("§8• Raw Iron");
                description.add("§8• Raw Gold");
                description.add("§8• Raw Copper");
                description.add("§8• Ore blocks");
                break;
            case WOOD_ITEMS:
                iconMaterial = Material.OAK_STAIRS;
                displayName = "§e§lWood Variants";
                description.add("§7Filters out:");
                description.add("§8• Wooden Stairs");
                description.add("§8• Wooden Slabs");
                description.add("§8• Wooden Fences");
                break;
            case STONES:
                iconMaterial = Material.COBBLESTONE;
                displayName = "§7§lStone Types";
                description.add("§7Filters out:");
                description.add("§8• Cobblestone");
                description.add("§8• Stone Variants");
                description.add("§8• Granite/Andesite/Diorite");
                break;
            case NO_BLOCKS:
                iconMaterial = Material.BARRIER;
                displayName = "§4§lBlock Blacklist";
                description.add("§7Filters out:");
                description.add("§8• All placeable blocks");
                break;
            case NO_ITEMS:
                iconMaterial = Material.STICK;
                displayName = "§4§lItem Blacklist";
                description.add("§7Filters out:");
                description.add("§8• All non-block items");
                break;
            default:
                iconMaterial = Material.STONE;
                displayName = "§7§lMiscellaneous";
                description.add("§7Filters out misc items");
        }

        ItemStack icon = new ItemStack(iconMaterial);
        ItemMeta meta = icon.getItemMeta();
        meta.setDisplayName(displayName);

        description.add("");
        description.add(enabled ? "§a§l✔ ENABLED" : "§c§l✘ DISABLED");
        description.add("§7Click to toggle");

        meta.setLore(description);
        icon.setItemMeta(meta);
        return icon;
    }
}
