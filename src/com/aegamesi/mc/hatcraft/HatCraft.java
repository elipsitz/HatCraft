package com.aegamesi.mc.hatcraft;

import java.util.ArrayList;
import java.util.Collections;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class HatCraft extends JavaPlugin implements Listener {
	public static ArrayList<Integer> disallowed = null;

	@SuppressWarnings("unchecked")
	public void onEnable() {
		saveDefaultConfig();

		disallowed = (ArrayList<Integer>) getConfig().getList("disallowed");
		
		getCommand("hat").setExecutor(new CommandHandler(this));
		getCommand("backpack").setExecutor(new CommandHandler(this));
		
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent evt) {
		if (evt.getInventory().getHolder() instanceof BackpackHolder) {
			BackpackHolder hold = (BackpackHolder) evt.getInventory().getHolder();
			String configKey = "backpack." + hold.player.toLowerCase();
			ArrayList<ItemStack> stack = new ArrayList<ItemStack>();
			Collections.addAll(stack, hold.inventory.getContents());
			getConfig().set(configKey, stack);
			saveConfig();
		}
	}
}