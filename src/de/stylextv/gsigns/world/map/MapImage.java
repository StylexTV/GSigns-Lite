package de.stylextv.gsigns.world.map;

import java.util.UUID;

public class MapImage {
	
	public static final int WIDTH = 128;
	public static final int HEIGHT = 128;
	
	public static final int SIZE_IN_PIXELS = WIDTH * HEIGHT;
	
	private UUID id;
	
	private byte[] pixels;
	
	public MapImage(byte[] pixels) {
		this(UUID.randomUUID(), pixels);
	}
	
	public MapImage(UUID id, byte[] pixels) {
		this.id = id;
		this.pixels = pixels;
	}
	
	public boolean isInUse() {
		
	}
	
	public boolean pixelsEqual(byte[] pixels) {
		for(int i = 0; i < pixels.length; i++) {
			
			if(pixels[i] != this.pixels[i]) return false;
		}
		
		return true;
	}
	
	public UUID getID() {
		return id;
	}
	
	public byte[] getPixels() {
		return pixels;
	}
	
}
