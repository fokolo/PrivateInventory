package io.github.fokolo;

import org.bukkit.Material;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;

public class UserEvents implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if (!(e.getBlock().getType().equals(Material.FURNACE))) {
			return;
		} else if (!(Players.isPlayer(e.getPlayer().getName()))) {
			return;
		} else {
			Furnace f = (Furnace) e.getBlock().getState();
			Furnaces.addFurnace(f.getLocation(), f.getCookTime(), f.getBurnTime());
			Players.removePlayer(e.getPlayer().getName());
			e.getPlayer().sendMessage("Succesfully placed Private Inventory");
		}
	}
	
	@EventHandler
	public void onBlockRemove(BlockBreakEvent e) {
		if (!(e.getBlock().getType().equals(Material.FURNACE))) {
			System.out.println("Not Furnace");
			return;
		} else if (!(Furnaces.isFurnace(e.getBlock().getLocation()))) {
			return;
		}else{
			e.setCancelled(true);
			e.getPlayer().sendMessage("Cannot Destroy This Private Inventory");
		}
	}

}
