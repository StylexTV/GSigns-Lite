package de.stylextv.gsigns;

import org.bukkit.plugin.java.JavaPlugin;

import de.stylextv.gsigns.command.CommandManager;
import de.stylextv.gsigns.packet.PacketManager;
import de.stylextv.gsigns.util.async.AsyncUtil;

public class GSigns extends JavaPlugin {
	
	private static GSigns instance;
	
	public GSigns() {
		instance = this;
	}
	
	@Override
	public void onEnable() {
		CommandManager.registerPluginCommands();
		
		PacketManager.start();
		
		AsyncUtil.loopAsync(() -> System.out.println("Hey2"), 1000);
	}
	
	@Override
	public void onDisable() {
		AsyncUtil.shutdown();
	}
	
	public static GSigns getInstance() {
		return instance;
	}
	
}
