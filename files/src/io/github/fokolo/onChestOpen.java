package io.github.fokolo;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class onChestOpen implements Listener {

	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent e) {
		HumanEntity player = e.getPlayer();

		if (e.getInventory().getType() == InventoryType.CHEST && getInv.get(player.getName()) != null) {
			ItemStack[] playerinv = getInv.get(player.getName());
			int j = 0;
			
			for(ItemStack i:playerinv)
			{
				if(i == null){
					j++;
				}else{
					e.getInventory().setItem(j, i);
					j++;
				}

			}
		} else {
			System.out.println("null inventory sorry");
		}
	}

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		HumanEntity player = e.getPlayer();
		Inventory inv = e.getInventory();
		ItemStack[] playerinv = new ItemStack[54];
		int j=0;
		
		if (inv.getType() == InventoryType.CHEST) {
			
			for(ItemStack i : inv.getContents()){
				if(i == null){
					playerinv[j] = new ItemStack(Material.AIR,0);
					j++;
				}else{
					playerinv[j] = i;
					j++;
				}
			}
			
			getInv.insert(player.getName(), playerinv);
			inv.clear();
		}
	}

}
