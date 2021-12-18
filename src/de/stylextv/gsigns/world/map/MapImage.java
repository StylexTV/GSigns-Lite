package de.stylextv.gsigns.world.map;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import de.stylextv.gsigns.util.async.AsyncUtil;

public class MapImage {
	
	private static ConcurrentHashMap<UUID, MapImage> images = new ConcurrentHashMap<>();
	
	private UUID id;
	
	private byte[] pixels;
	
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
	
	public static void loadImages() {
		
		
		// TODO what if image has just been created but hasn't been asigned to a frame yet?
		AsyncUtil.loopAsync(() -> collectGarbage(), 60000, 300000);
	}
	
	public static void saveImages() {
		
	}
	
	private static void collectGarbage() {
		images.forEach((id, image) -> {
			
			if(image.isInUse()) return;
			
			images.remove(id);
		});
	}
	
	public static MapImage pixelsToImage(byte[] pixels) {
		for(MapImage image : images.values()) {
			
			if(image.pixelsEqual(pixels)) return image;
		}
		
		UUID id = UUID.randomUUID();
		
		MapImage image = new MapImage(id, pixels);
		
		images.put(id, image);
		
		return image;
	}
	
	public static MapImage getImage(UUID id) {
		return images.get(id);
	}
	
	public static ConcurrentHashMap<UUID, MapImage> getImages() {
		return images;
	}
	
}
