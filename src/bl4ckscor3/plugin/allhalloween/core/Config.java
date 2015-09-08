package bl4ckscor3.plugin.allhalloween.core;

import org.bukkit.plugin.Plugin;

public class Config
{
	public static void setup(Plugin pl)
	{
		pl.reloadConfig();
		pl.getConfig().options().header(getHeader());
		pl.getConfig().addDefault("shouldIgnoreHelmetSlot", false);
		pl.getConfig().options().copyDefaults(true);
		pl.saveConfig();
		System.out.println("Config created/enabled! How spooky.");
	}
	
	private static String getHeader()
	{
		return "";
	}
}