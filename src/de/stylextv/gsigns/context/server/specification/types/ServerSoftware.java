package de.stylextv.gsigns.context.server.specification.types;

import java.util.ArrayList;
import java.util.List;

import de.stylextv.gsigns.context.server.specification.Specification;

public class ServerSoftware extends Specification {
	
	private static List<ServerSoftware> softwares = new ArrayList<>();
	
	public static final ServerSoftware SPONGE = new ServerSoftware("Sponge", true);
	public static final ServerSoftware FORGE = new ServerSoftware("Forge", true);
	
	public static final ServerSoftware PAPER = new ServerSoftware("Paper");
	public static final ServerSoftware SPIGOT = new ServerSoftware("Spigot");
	
	public static final ServerSoftware BUKKIT = new ServerSoftware("Bukkit");
	
	public static final ServerSoftware UNKNOWN = new ServerSoftware("Unknown");
	
	private boolean modded;
	
	public ServerSoftware(String name) {
		this(name, false);
	}
	
	public ServerSoftware(String name, boolean modded) {
		super(name);
		
		this.modded = modded;
		
		softwares.add(this);
	}
	
	public boolean isModded() {
		return modded;
	}
	
	public static ServerSoftware fromString(String s) {
		for(ServerSoftware software : softwares) {
			
			if(software.matches(s)) return software;
		}
		
		return UNKNOWN;
	}
	
	public static List<ServerSoftware> getSoftwares() {
		return softwares;
	}
	
}
