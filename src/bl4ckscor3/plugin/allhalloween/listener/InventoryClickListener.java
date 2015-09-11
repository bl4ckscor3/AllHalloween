package bl4ckscor3.plugin.allhalloween.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

public class InventoryClickListener implements Listener
{
	private Plugin pl;

	public InventoryClickListener(Plugin plugin)
	{
		pl = plugin;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event)
	{
		if(event.getCurrentItem() == null)
			return;

		if(!pl.getConfig().getBoolean("allowPlayersToPickupLantern"))
		{	
			if(event.getInventory().getName().equals("container.crafting"))
			{
				if(event.getSlot() == 39)
				{
					if(event.getCurrentItem().getType() == Material.JACK_O_LANTERN)
						event.setCancelled(true);
				}
			}
		}
	}
}
