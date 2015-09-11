package bl4ckscor3.plugin.allhalloween.util;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class TrickOrTreatCheck
{
	private Location loc;
	private int clickTimes;
	private boolean topDoor;
	
	public TrickOrTreatCheck(Location location, int ct, Block b)
	{
		loc = location;
		clickTimes = ct;
		topDoor = Utilities.isDoor(b.getWorld().getBlockAt(new Location(b.getWorld(), b.getLocation().getX(), b.getLocation().getY() - 1, b.getLocation().getZ())).getType());
	}
	
	public Location getLocation()
	{
		return loc;
	}
	
	public int getClickTimes()
	{
		return clickTimes;
	}
	
	public void increaseClickTimesByOne()
	{
		clickTimes++;
	}
	
	public boolean isTopDoor()
	{
		return topDoor;
	}
}
