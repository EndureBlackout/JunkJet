package me.endureblackout.JunkJet;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class JunkJetPlugin extends JavaPlugin {
	public void onEnable() {
		System.out.println(ChatColor.GREEN + "JUNKJET LOADED!");
		getServer().getPluginManager().registerEvents(new JunkJetListener(this), this);
		

		@SuppressWarnings("deprecation")
		ShapedRecipe junkJet = new ShapedRecipe(createJunkJet());
		
		junkJet.shape("IIR", "AAI", "IIS");
		junkJet.setIngredient('I', Material.IRON_INGOT);
		junkJet.setIngredient('R', Material.REDSTONE_TORCH_ON);
		junkJet.setIngredient('S', Material.STICK);
		
		@SuppressWarnings("deprecation")
		ShapedRecipe ignitedJunkJet = new ShapedRecipe(ignitedJunkJet());
		ignitedJunkJet.shape("AAA", "AJF", "AAA");
		ignitedJunkJet.setIngredient('J', createJunkJet().getData());
		ignitedJunkJet.setIngredient('F', Material.FLINT_AND_STEEL);
		
		Bukkit.addRecipe(junkJet);
	}
	
	public ItemStack createJunkJet() {
		ItemStack junkJet = new ItemStack(Material.STONE_HOE);
		ItemMeta jetMeta = junkJet.getItemMeta();

		jetMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Junk Jet");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "JUNK JUNK JUNK");

		jetMeta.setLore(lore);

		junkJet.setItemMeta(jetMeta);

		return junkJet;
	}
	
	public ItemStack ignitedJunkJet() {
		ItemStack junkJet = new ItemStack(Material.GOLD_HOE);
		ItemMeta junkMeta = junkJet.getItemMeta();
		
		junkMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Ignited Junk Jet");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', "&1&l&k; &1&lJUNK JUNK JUNK &1&l&k;"));

		junkMeta.setLore(lore);

		junkJet.setItemMeta(junkMeta);

		return junkJet;
	}
}
