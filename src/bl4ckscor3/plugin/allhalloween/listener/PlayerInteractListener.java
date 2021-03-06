package bl4ckscor3.plugin.allhalloween.listener;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.allhalloween.util.TrickOrTreatCheck;
import bl4ckscor3.plugin.allhalloween.util.Utilities;

public class PlayerInteractListener implements Listener
{
	private HashMap<Player,TrickOrTreatCheck> tot = new HashMap<Player,TrickOrTreatCheck>();
	private Plugin pl;
	private static int chance;
	
	public PlayerInteractListener(Plugin plugin, int c)
	{
		pl = plugin;
		chance = c;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if(event.getPlayer().getGameMode() != GameMode.CREATIVE)
		{
			if(event.getAction() == Action.LEFT_CLICK_BLOCK)
			{
				if(Utilities.isDoor(event.getClickedBlock().getType()))
				{
					if(!tot.containsKey(event.getPlayer()))
						tot.put(event.getPlayer(), new TrickOrTreatCheck(event.getClickedBlock().getLocation(), 1, event.getClickedBlock()));
					else
					{
						if(isDifferentBlock(event.getPlayer(), event.getClickedBlock()))
						{
							tot.remove(event.getPlayer());
							return;
						}
						else
							tot.get(event.getPlayer()).increaseClickTimesByOne();
					}

					if(tot.get(event.getPlayer()).getClickTimes() == 3)
					{
						int x = new Random().nextInt(99);
						
						event.getPlayer().getWorld().dropItem(event.getPlayer().getLocation(), new ItemStack(x < chance ? Material.DIRT : Material.EMERALD));
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.0F, 1.0F);
						tot.remove(event.getPlayer());
					}
				}
				else
				{
					if(tot.containsKey(event.getPlayer()))
						tot.remove(event.getPlayer());
				}
			}
		}
	}

	private boolean isDifferentBlock(Player p, Block b)
	{
		TrickOrTreatCheck t = tot.get(p);

		if(t.isTopDoor())
		{
			if(!Utilities.sameLocation(t.getLocation(), b.getLocation()))
			{
				if(!Utilities.sameLocation(new Location(p.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 1, t.getLocation().getZ()), b.getLocation()))
					return true;
			}
		}
		else
		{
			if(!Utilities.sameLocation(t.getLocation(), b.getLocation()))
			{
				if(!Utilities.sameLocation(new Location(p.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 1, t.getLocation().getZ()), b.getLocation()))
					return true;
			}
		}

		return false;
	}
}
