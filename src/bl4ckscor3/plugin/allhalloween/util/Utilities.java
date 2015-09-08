package bl4ckscor3.plugin.allhalloween.util;

import org.bukkit.ChatColor;

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
}
