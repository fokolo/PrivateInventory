package io.github.fokolo;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class UserCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player!");
			return false;
		}
		if (args.length > 1) {
			sender.sendMessage("Too many arguments!");
			return false;
		}
		if (args.length < 1) {
			sender.sendMessage("Not enough arguments!");
			return false;
		}
		if (args[0].equalsIgnoreCase("create")) {
			Player p = (Player) sender;
			if (Bukkit.getPlayerExact(sender.getName()) != null) {
				String pn = p.getName();
				sender.sendMessage("Now Place inventory of your choice");
				Players.addPlayer(pn);
			}else{
				System.out.println(sender.getName() + " FALSE!");
			}
			return true;
		}
		return false;
	}

}
