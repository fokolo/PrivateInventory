package io.github.fokolo;

import org.bukkit.Material;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;

public class FurnaceEvents implements Listener {
	
	@EventHandler
	public void onFurnaceOpen(InventoryOpenEvent e) {		
		//checks if furnace and if in database
		if(!(e.getInventory().getType().equals(InventoryType.FURNACE)))
			return;
		Furnace f = (Furnace) e.getInventory().getHolder();
		if(!(Furnaces.isFurnace(f.getLocation())))
			return;
		
		short burntime = Furnaces.getBurnTime(f.getLocation());
		short cooktime = Furnaces.getCookTime(f.getLocation());
		ItemStack[] furn = Furnaces.getFurnace(f.getLocation());
		f.setBurnTime(burntime);
		f.setCookTime(cooktime);
		f.getInventory().setFuel(furn[1]);
		f.getInventory().setResult(furn[2]);
		f.getInventory().setSmelting(furn[0]);
	}
	
	@EventHandler
	public void onFurnaceClose(InventoryCloseEvent e){
		//checks if furnace and if in database
		if(!(e.getInventory().getType().equals(InventoryType.FURNACE)))
			return;
		Furnace f = (Furnace) e.getInventory().getHolder();
		if(!(Furnaces.isFurnace(f.getLocation())))
			return;
		
		Furnaces.updateFurnace(f.getLocation(), f.getInventory().getContents(), f.getCookTime(), f.getBurnTime());
		f.setType(Material.FURNACE);
		f.getInventory().clear();
	}
}