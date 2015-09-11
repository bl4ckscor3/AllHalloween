package bl4ckscor3.plugin.allhalloween.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
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
	
	/**
	 * Checks if the given Material is a door
	 * @param m The material
	 * @return If it's a door
	 */
	public static boolean isDoor(Material m)
	{
		return m == Material.ACACIA_DOOR || m == Material.BIRCH_DOOR || m == Material.DARK_OAK_DOOR || m == Material.JUNGLE_DOOR || m == Material.SPRUCE_DOOR || m == Material.WOODEN_DOOR;
	}

	/**
	 * Checks if two locations are the same
	 * @param loc1 The first location
	 * @param loc2 The second location
	 * @return Wether the two locations are the same
	 */
	public static boolean sameLocation(Location loc1, Location loc2)
	{
		return loc1.getWorld().getName().equals(loc2.getWorld().getName()) && loc1.getX() == loc2.getX() && loc1.getY() == loc2.getY() && loc1.getZ() == loc2.getZ();
	}
}
