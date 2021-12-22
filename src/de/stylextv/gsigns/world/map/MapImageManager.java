package de.stylextv.gsigns.world.map;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import de.stylextv.gsigns.util.async.AsyncUtil;
import de.stylextv.gsigns.world.map.io.file.MapImagesFile;

public class MapImageManager {
	
	private static ConcurrentHashMap<UUID, MapImage> images = new ConcurrentHashMap<>();
	
	private static boolean saved;
	
	public static void loadImages() {
		MapImagesFile file = new MapImagesFile();
		
		if(file.exists()) {
			
			List<MapImage> list = file.readImages();
			
			list.forEach((image) -> addImage(image));
		}
		
		file.close();
		
		saved = true;
		
		// TODO what if image has just been created but hasn't been asigned to a frame yet?
		AsyncUtil.loopAsync(() -> saveImages(), 300000, 900000);
		AsyncUtil.loopAsync(() -> collectGarbage(), 60000, 300000);
	}
	
	public static void saveImages() {
		if(saved) return;
		
		MapImagesFile file = new MapImagesFile();
		
		Collection<MapImage> c = images.values();
		
		file.writeImages(c);
		
		file.close();
		
		saved = true;
	}
	
	private static void collectGarbage() {
		images.forEach((id, image) -> {
			
			if(image.isInUse()) return;
			
			removeImage(image);
		});
	}
	
	private static void addImage(MapImage image) {
		UUID id = image.getID();
		
		images.put(id, image);
		
		saved = false;
	}
	
	private static void removeImage(MapImage image) {
		UUID id = image.getID();
		
		images.remove(id);
	}
	
	public static MapImage getImageByPixels(byte[] pixels) {
		for(MapImage image : images.values()) {
			
			if(image.pixelsEqual(pixels)) return image;
		}
		
		MapImage image = new MapImage(pixels);
		
		addImage(image);
		
		return image;
	}
	
	public static MapImage getImageByID(UUID id) {
		return images.get(id);
	}
	
}
