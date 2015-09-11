package bl4ckscor3.plugin.allhalloween.listener;

import java.util.HashMap;
import java.util.Set;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import bl4ckscor3.plugin.allhalloween.util.PumpkinCheck;

public class PlayerMoveAndQuitListener implements Listener
{
	private static HashMap<Player,PumpkinCheck> targetBlocks = new HashMap<Player,PumpkinCheck>();

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event)
	{
		Player p = event.getPlayer();
		Block b = p.getTargetBlock((Set<Material>)null, p.getGameMode() == GameMode.CREATIVE ? 5 : 4);
		PumpkinCheck check = new PumpkinCheck(p.getWorld().getBlockAt(b.getLocation()).getType(), b.getLocation());

		if(targetBlocks.containsKey(p) && targetBlocks.get(p).isPumpkin() && !check.isPumpkin())
		{
			Block newBlock = p.getWorld().getBlockAt(targetBlocks.get(p).getLocation());
			byte data = newBlock.getData();

			newBlock.setType(Material.PUMPKIN);
			newBlock.setData(data);
		}

		targetBlocks.put(p, check);

		if(targetBlocks.get(p).isPumpkin())
		{
			Block newBlock = p.getWorld().getBlockAt(targetBlocks.get(p).getLocation());
			byte data = newBlock.getData();

			newBlock.setType(Material.JACK_O_LANTERN);
			newBlock.setData(data);
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		targetBlocks.remove(event.getPlayer());
	}
}
