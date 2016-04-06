package bl4ckscor3.plugin.allhalloween.core;

import org.bukkit.plugin.java.JavaPlugin;

import bl4ckscor3.plugin.allhalloween.cmd.Spook;
import bl4ckscor3.plugin.allhalloween.listener.InventoryClickListener;
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
		getCommand("spook").setExecutor(new Spook());
		getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
		getServer().getPluginManager().registerEvents(new PlayerMoveAndQuitListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerInteractListener(this, getChance()), this);
		getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
		System.out.println(Utilities.getPrefix() + getDescription().getVersion() + " has been enabled. Spooky.");
	}
	
	@Override
	public void onDisable()
	{
		System.out.println(Utilities.getPrefix() + getDescription().getVersion() + " has been disabled. Even more spooky.");
	}
	
	public static AllHalloween getInstance()
	{
		return instance;
	}
	
	private int getChance()
	{
		return getConfig().getInt("dirtChance") < 0 || getConfig().getInt("dirtChance") > 100 ? 20 : getConfig().getInt("dirtChance");
	}
}
