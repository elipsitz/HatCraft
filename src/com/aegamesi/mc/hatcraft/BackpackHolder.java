package com.aegamesi.mc.hatcraft;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class BackpackHolder implements InventoryHolder {
	public Inventory inventory;
	public String player;

	public Inventory getInventory() {
		return inventory;
	}

	public BackpackHolder(int size, String player, ItemStack[] contents) {
		this.player = player;

		inventory = Bukkit.getServer().createInventory(this, size, player + "'s Backpack");
		if (contents != null)
			inventory.setContents(contents);
	}
}
