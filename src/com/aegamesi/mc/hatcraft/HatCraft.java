package com.aegamesi.mc.hatcraft;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

public final class HatCraft extends JavaPlugin {
	public static ArrayList<Integer> disallowed = null;
	
	@SuppressWarnings("unchecked")
	public void onEnable() {
		saveDefaultConfig();
		
		disallowed = (ArrayList<Integer>) getConfig().getList("disallowed");
		getCommand("hat").setExecutor(new CommandHandler(this));
	}

	public void onDisable() {
	}
}