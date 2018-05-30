package me.endureblackout.JunkJet;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class JunkJetListener implements Listener {

	JunkJetPlugin core;

	public JunkJetListener(JunkJetPlugin core) {
		this.core = core;
	}

	@EventHandler
	public void useJunkJet(PlayerInteractEvent e) {
		if ((e.getAction() == Action.RIGHT_CLICK_AIR)
				|| (e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getItem().getType().equals(Material.STONE_HOE))) {

			if (isJunkJet(e.getItem())) {
				shootJunk(e.getPlayer());
			}
		}
	}

	public void shootJunk(Player p) {

		if (p.getInventory().contains(Material.STONE) || p.getInventory().contains(Material.COBBLESTONE)) {
			for (int i = 0; i < p.getInventory().getSize(); i++) {
				if (p.getInventory().getItem(i) == null) {
					continue;
				} else if (p.getInventory().getItem(i).getType().equals(Material.STONE)) {
					ItemStack stone = new ItemStack(Material.STONE);

					removeItem(p, 1, stone, i);

					Location loc = p.getEyeLocation().toVector().add(p.getLocation().getDirection().multiply(2))
							.toLocation(p.getWorld(), p.getLocation().getYaw(), p.getLocation().getPitch());
					Arrow arrow = p.getWorld().spawn(loc, Arrow.class);
					arrow.setShooter(p);
					arrow.setVelocity(p.getEyeLocation().getDirection().multiply(4));
					p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 30, 30);
					break;
				} else if (p.getInventory().getItem(i).equals(Material.COBBLESTONE)) {
					ItemStack cobble = new ItemStack(Material.COBBLESTONE);

					removeItem(p, 1, cobble, i);

					Location loc = p.getEyeLocation().toVector().add(p.getLocation().getDirection().multiply(2))
							.toLocation(p.getWorld(), p.getLocation().getYaw(), p.getLocation().getPitch());
					Arrow arrow = p.getWorld().spawn(loc, Arrow.class);
					arrow.setShooter(p);
					arrow.setVelocity(p.getEyeLocation().getDirection().multiply(4));
					p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 30, 30);
					break;
				}
			}
		} else {
			p.playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 30, 30);
			p.sendMessage(ChatColor.RED + "You don't have any junk to use!");
		}
	}

	public void removeItem(Player p, int amount, ItemStack item, int slot) {
		if (p.getInventory().getItem(slot).getType().equals(item.getType())) {
			int stack = p.getInventory().getItem(slot).getAmount();

			stack = stack - amount;

			p.getInventory().getItem(slot).setAmount(stack);
		}
	}

	public boolean isJunkJet(ItemStack i) {
		if (i.getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Junk Jet")) {
			if (i.getItemMeta().getLore().contains(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "JUNK JUNK JUNK")) {
				return true;
			}
		}
		return false;
	}
}
