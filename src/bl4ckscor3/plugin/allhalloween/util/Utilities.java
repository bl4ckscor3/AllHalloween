package bl4ckscor3.plugin.allhalloween.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import bl4ckscor3.plugin.allhalloween.core.AllHalloween;

public class Utilities
{
	/**
	 * Returns the default message prefix of the plugin
	 */
	public static String getPrefix()
	{
		return ChatColor.RED + "[" + ChatColor.GOLD + AllHalloween.getInstance().getDescription().getName() + ChatColor.RED + "] " + ChatColor.YELLOW;
	}
	
	/**
	 * Checks if a player is online.
	 * 
	 * @param name - The player to search for
	 * @return - Returns if the player is online or not
	 */
	public static boolean isPlayerOnline(String name)
	{
		for(Player p : Bukkit.getOnlinePlayers())
		{
			if(p.getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}
}
