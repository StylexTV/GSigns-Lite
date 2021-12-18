package de.stylextv.gsigns;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Rotation;
import org.bukkit.block.BlockFace;
import org.bukkit.plugin.java.JavaPlugin;

import de.stylextv.gsigns.command.CommandManager;
import de.stylextv.gsigns.packet.PacketManager;
import de.stylextv.gsigns.world.sign.frame.VirtualFrame;

public class GSigns extends JavaPlugin {
	
	private static GSigns instance;
	
	public GSigns() {
		instance = this;
	}
	
	@Override
	public void onEnable() {
		CommandManager.registerPluginCommands();
		
		PacketManager.start();
		
		Location loc = new Location(Bukkit.getWorld("world"), 78, 142, 77);
		
		VirtualFrame f = new VirtualFrame(loc, BlockFace.SOUTH, Rotation.NONE);
		
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static GSigns getInstance() {
		return instance;
	}
	
}
