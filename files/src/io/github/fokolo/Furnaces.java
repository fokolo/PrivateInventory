package io.github.fokolo;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Location;

public class Furnaces {

	static Inventory[] furnaces = new Inventory[50];
	static short[] cooks = new short[50];
	static short[] burns = new short[50];
	static Map<Location, Integer> locs = new HashMap<Location, Integer>();

	public static ItemStack[] getFurnace(Location loc) {
		int i = locs.get(loc);
		return furnaces[i].getContents();
	}

	public static short getCookTime(Location loc) {
		int i = locs.get(loc);
		return cooks[i];
	}

	public static short getBurnTime(Location loc) {
		int i = locs.get(loc);
		return burns[i];
	}

	public static void addFurnace(Location loc, short cook,
			short burn) {
		int i = 0;
		for (Inventory fs : furnaces) {
			if (fs == null) {
				break;
			} else {
				i++;
			}
		}
		furnaces[i].setContents(PrivateFurnace.airs);
		cooks[i] = cook;
		burns[i] = burn;
		locs.put(loc, i);
	}

	public static void updateFurnace(Location loc, ItemStack[] furn,
			short cook, short burn) {
		int i = locs.get(loc);
		furnaces[i].setContents(furn);
		cooks[i] = cook;
		burns[i] = burn;
	}

	public static boolean isFurnace(Location loc) {
		return locs.containsKey(loc);
	}

	public static boolean removeFurnace(Location loc) {
		return locs.remove(loc) != null;
	}

}
