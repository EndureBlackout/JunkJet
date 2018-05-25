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
		ItemStack junk = null;

		for (ItemStack i : p.getInventory()) {
			if (p.getInventory().getItem(i).equals(Material.STONE)) {

				junk.setAmount(junk.getAmount() - 1);

				Location loc = p.getEyeLocation().toVector().add(p.getLocation().getDirection().multiply(2))
						.toLocation(p.getWorld(), p.getLocation().getYaw(), p.getLocation().getPitch());
				Arrow arrow = p.getWorld().spawn(loc, Arrow.class);
				arrow.setShooter(p);
				arrow.setVelocity(p.getEyeLocation().getDirection().multiply(2));
				break;
			} else if (p.getInventory().getItem(i).equals(Material.COBBLESTONE)) {
				junk = new ItemStack(p.getInventory().getItem(i));

				junk.setAmount(junk.getAmount() - 1);

				Location loc = p.getEyeLocation().toVector().add(p.getLocation().getDirection().multiply(2))
						.toLocation(p.getWorld(), p.getLocation().getYaw(), p.getLocation().getPitch());
				Arrow arrow = p.getWorld().spawn(loc, Arrow.class);
				arrow.setShooter(p);
				arrow.setVelocity(p.getEyeLocation().getDirection().multiply(2));
				break;
			}
		}
	}
}
