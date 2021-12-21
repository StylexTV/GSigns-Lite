package de.stylextv.gsigns.context.server;

import org.bukkit.Bukkit;

import de.stylextv.gsigns.context.server.specification.types.MinecraftVersion;
import de.stylextv.gsigns.context.server.specification.types.ServerSoftware;

public class ServerContext {
	
	public static boolean isModded() {
		ServerSoftware software = getServerSoftware();
		
		return software.isModded();
	}
	
	public static MinecraftVersion getMinecraftVersion() {
		String s = Bukkit.getBukkitVersion();
		
		return MinecraftVersion.fromString(s);
	}
	
	public static ServerSoftware getServerSoftware() {
		String s = Bukkit.getVersion();
		
		return ServerSoftware.fromString(s);
	}
	
}
