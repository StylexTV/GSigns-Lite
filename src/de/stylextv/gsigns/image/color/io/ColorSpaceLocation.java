package de.stylextv.gsigns.image.color.io;

import de.stylextv.gsigns.context.server.specification.types.MinecraftVersion;

public class ColorSpaceLocation {
	
	private static final ColorSpaceLocation[] LOCATIONS = new ColorSpaceLocation[] {
			new ColorSpaceLocation("1_16.dat", MinecraftVersion.RELEASE_1_16)
	};
	
	private String path;
	
	private MinecraftVersion version;
	
	public ColorSpaceLocation(String path, MinecraftVersion v) {
		this.path = path;
		this.version = v;
	}
	
	public boolean isCompatibleWith(MinecraftVersion v) {
		return v.isNewerThan(v);
	}
	
	public String getPath() {
		return path;
	}
	
	public MinecraftVersion getVersion() {
		return version;
	}
	
	public static ColorSpaceLocation fromVersion(MinecraftVersion v) {
		for(ColorSpaceLocation l : LOCATIONS) {
			
			if(l.isCompatibleWith(v)) return l;
		}
		
		return null;
	}
	
	public static ColorSpaceLocation[] getLocations() {
		return LOCATIONS;
	}
	
}
