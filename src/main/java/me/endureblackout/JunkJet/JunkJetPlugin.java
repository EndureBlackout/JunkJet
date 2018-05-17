package me.endureblackout.JunkJet;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class JunkJetPlugin extends JavaPlugin {
	public void onEnable() {
		
		Bukkit.getServer().getPluginManager().registerEvents(new CraftingHandler(this), this);
	}
}
