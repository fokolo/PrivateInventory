package io.github.fokolo;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PrivateFurnace extends JavaPlugin{
	static ItemStack[] airs = new ItemStack[3];
	
	@Override
    public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
		
		getCommand("privateinventory").setExecutor(new UserCommand());
		pm.registerEvents(new FurnaceEvents(),this);
		pm.registerEvents(new UserEvents(),this);
		for(int i = 0; i < airs.length;i++){
			airs[i] = new ItemStack(Material.YELLOW_FLOWER);
		}
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }

}


/*Bugs:
 1.can destroy furnace
 
 
*/