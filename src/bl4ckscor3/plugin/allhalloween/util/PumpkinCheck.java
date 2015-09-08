package bl4ckscor3.plugin.allhalloween.util;

import org.bukkit.Location;
import org.bukkit.Material;

public class PumpkinCheck
{
	private Location loc;
	private boolean isPumpkin;
	
	public PumpkinCheck(Material mat, Location location)
	{
		loc = location;
		isPumpkin = mat == Material.PUMPKIN || mat == Material.JACK_O_LANTERN;
	}
	
	public Location getLocation()
	{
		return loc;
	}
	
	public boolean isPumpkin()
	{
		return isPumpkin;
	}
}
