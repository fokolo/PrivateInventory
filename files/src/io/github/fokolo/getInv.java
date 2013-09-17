package io.github.fokolo;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.inventory.ItemStack;

public class getInv {
	static Map<String,ItemStack[]> hm = new HashMap<String,ItemStack[]>();
	
	
	static void insert(String player,ItemStack[] inv){
		hm.put(player, inv);
	}
	static ItemStack[] get(String player){
		return hm.get(player);
	}
}
