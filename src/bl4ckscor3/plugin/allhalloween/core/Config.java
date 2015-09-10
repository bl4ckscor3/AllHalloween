package bl4ckscor3.plugin.allhalloween.core;

import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.allhalloween.util.Utilities;

public class Config
{
	public static void setup(Plugin pl)
	{
		pl.reloadConfig();
		pl.getConfig().options().header(getHeader());
		pl.getConfig().addDefault("shouldIgnoreHelmetSlot", false);
		pl.getConfig().options().copyDefaults(true);
		pl.saveConfig();
		System.out.println(Utilities.getPrefix() + "Config created/enabled! How spooky.");
	}
	
	private static String getHeader()
	{
		return "";
	}
}
