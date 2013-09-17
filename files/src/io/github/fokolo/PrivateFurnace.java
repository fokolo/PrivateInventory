package io.github.fokolo;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PrivateFurnace extends JavaPlugin{
	
	@Override
    public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new onChestOpen(),this);
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }

}
