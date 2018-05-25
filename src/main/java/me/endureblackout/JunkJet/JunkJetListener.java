package me.endureblackout.JunkJet;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class JunkJetListener implements Listener {

	JunkJetPlugin core;

	public JunkJetListener(JunkJetPlugin core) {
		this.core = core;
	}

	@EventHandler
	public void useJunkJet(PlayerInteractEvent e) {
		if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			shootJunk(e.getPlayer());
		}
	}

	public void shootJunk(Player p) {

		if (p.getInventory().contains(Material.STONE) || p.getInventory().contains(Material.COBBLESTONE)) {
			for (ItemStack i : p.getInventory()) {
				if (i.getType().equals(Material.STONE)) {
					ItemStack stone = new ItemStack(Material.STONE);

					removeItem(p, 1, stone);

					Location loc = p.getEyeLocation().toVector().add(p.getLocation().getDirection().multiply(2))
							.toLocation(p.getWorld(), p.getLocation().getYaw(), p.getLocation().getPitch());
					Arrow arrow = p.getWorld().spawn(loc, Arrow.class);
					arrow.setShooter(p);
					arrow.setVelocity(p.getEyeLocation().getDirection().multiply(2));
					break;
				} else if (i.getType().equals(Material.COBBLESTONE)) {
					ItemStack cobble = new ItemStack(Material.COBBLESTONE);

					removeItem(p, 1, cobble);

					Location loc = p.getEyeLocation().toVector().add(p.getLocation().getDirection().multiply(2))
							.toLocation(p.getWorld(), p.getLocation().getYaw(), p.getLocation().getPitch());
					Arrow arrow = p.getWorld().spawn(loc, Arrow.class);
					arrow.setShooter(p);
					arrow.setVelocity(p.getEyeLocation().getDirection().multiply(2));
					break;
				} else if (i.getType().equals(null)) {
					continue;
				}
			}
		} else {
			p.sendMessage(ChatColor.RED + "You don't have any junk to use!");
		}
	}

	public void removeItem(Player p, int amount, ItemStack item) {
		for (int i = 0; i < p.getInventory().getSize(); i++) {
			if (p.getInventory().getItem(i).getType().equals(item.getType())) {
				int stack = p.getInventory().getItem(i).getAmount();

				stack = stack - amount;

				p.getInventory().getItem(i).setAmount(stack);
				break;
			}
		}
	}
}
