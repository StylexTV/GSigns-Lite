package de.stylextv.gsigns.world.map.io.file;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.stylextv.gsigns.io.resource.types.StreamedFile;
import de.stylextv.gsigns.io.serialize.Serializer;
import de.stylextv.gsigns.world.map.MapImage;

public class MapImagesFile extends StreamedFile {
	
	private static final String PATH = "images.dat";
	
	public MapImagesFile() {
		super(PATH);
	}
	
	public List<MapImage> readImages() {
		ArrayList<MapImage> images = new ArrayList<>();
		
		while(!isEmpty()) {
			
			MapImage image = Serializer.MAP_IMAGE.readFrom(this);
			
			images.add(image);
		}
		
		return images;
	}
	
	public void writeImages(Collection<MapImage> images) {
		images.forEach((image) -> {
			
			Serializer.MAP_IMAGE.writeTo(this, image);
		});
	}
	
}
