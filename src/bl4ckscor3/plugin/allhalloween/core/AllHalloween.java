package bl4ckscor3.plugin.allhalloween.core;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import bl4ckscor3.plugin.allhalloween.cmd.Spook;
import bl4ckscor3.plugin.allhalloween.listener.PlayerInteractListener;
import bl4ckscor3.plugin.allhalloween.listener.PlayerJoinListener;
import bl4ckscor3.plugin.allhalloween.listener.PlayerMoveAndQuitListener;
import bl4ckscor3.plugin.allhalloween.util.Utilities;

public class AllHalloween extends JavaPlugin
{
	private static AllHalloween instance;
	
	@Override
	public void onEnable()
	{
		instance = this;
		Config.setup(this);
		getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
		getServer().getPluginManager().registerEvents(new PlayerMoveAndQuitListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
		System.out.println(Utilities.getPrefix() + getDescription().getVersion() + " has been enabled. Spooky.");
	}
	
	@Override
	public void onDisable()
	{
		System.out.println(Utilities.getPrefix() + getDescription().getVersion() + " has been disabled. Even more spooky.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(cmd.getName().equals("spook"))
			Spook.execute(sender, cmd, args);
		
		return true;
	}
	
	public static AllHalloween getInstance()
	{
		return instance;
	}
}
