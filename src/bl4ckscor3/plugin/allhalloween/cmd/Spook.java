package bl4ckscor3.plugin.allhalloween.cmd;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.darkblade12.particleeffect.ParticleEffect;

import bl4ckscor3.plugin.allhalloween.util.Utilities;

public class Spook
{
	public static void execute(CommandSender sender, Command cmd, String[] args)
	{
		if(!sender.hasPermission("halloween.spook"))
		{
			sender.sendMessage(Utilities.getPrefix() + "Sorry, you don't have permission to spook players.");
			return;
		}
		
		if(args.length != 1)
		{
			sender.sendMessage(Utilities.getPrefix() + "Correct usage: /spooky <playername>");
			return;
		}
		
		if(!Utilities.isPlayerOnline(args[0]))
		{
			sender.sendMessage(Utilities.getPrefix() + args[0] + " is not online.");
			return;
		}
		
		Player p = Bukkit.getPlayer(args[0]);

		ParticleEffect.MOB_APPEARANCE.display(0.0F, 0.0F, 0.0F, 10.0F, 1, p.getLocation(), 255);
		p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
	}
}
