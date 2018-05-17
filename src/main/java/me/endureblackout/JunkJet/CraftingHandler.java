package me.endureblackout.JunkJet;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CraftingHandler implements Listener {

	JunkJetPlugin core;

	public CraftingHandler(JunkJetPlugin core) {
		this.core = core;
	}

	@EventHandler
	public void onInventoryInteract(InventoryInteractEvent e) {
		Inventory inv = e.getInventory();
		boolean create = false;
		
		ItemStack iron = new ItemStack(Material.IRON_INGOT);
		ItemStack rtorch = new ItemStack(Material.REDSTONE_TORCH_OFF);

		if (inv.getType().equals(InventoryType.WORKBENCH)) {
			for (int i = 0; i < inv.getSize(); i++) {
				if (i == 0 || i == 1 || i == 5 | i == 6 || i == 7) {
					if (!inv.getItem(i).equals(iron)) {
						break;
					} else {
						continue;
					}
				}
				
				if(i == 2) {
					if(!inv.getItem(i).equals(rtorch)) {
						
					}
				}
			}
		}
	}

}
