package bl4ckscor3.plugin.allhalloween.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.allhalloween.util.Utilities;

public class PlayerJoinListener implements Listener
{
	private static Plugin pl;

	public PlayerJoinListener(Plugin plugin)
	{
		pl = plugin;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player p = event.getPlayer();

		if(p.getInventory().getHelmet() == null) //if the player does not have a helmet
			p.getInventory().setHelmet(new ItemStack(Material.JACK_O_LANTERN));
		else
		{
			if(!pl.getConfig().getBoolean("shouldIgnoreHelmetSlot"))
			{
				if(p.getInventory().addItem(p.getInventory().getHelmet()).size() == 0) //if the helmet could successfully be moved to the main inventory
					p.getInventory().setHelmet(new ItemStack(Material.JACK_O_LANTERN));
				else
					System.out.println(Utilities.getPrefix() + " Could not add Jack o' Lantern to " + p.getName() + (p.getName().endsWith("s") ? "'" : "'s") + " head, as they don't have any space in their inventory for their current helmet.");
			}
			else
			{
				System.out.println(Utilities.getPrefix() + " WARNING: Config option \"shouldIgnoreHelmetSlot\" is set to true! Helmet of " + p.getName() + " got deleted! (" + p.getInventory().getHelmet().getType().name() + ")");
				p.getInventory().setHelmet(new ItemStack(Material.JACK_O_LANTERN));
			}
		}
	}
}
