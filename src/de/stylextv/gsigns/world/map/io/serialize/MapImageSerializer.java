package de.stylextv.gsigns.world.map.io.serialize;

import java.util.UUID;

import de.stylextv.gsigns.io.file.StreamedFile;
import de.stylextv.gsigns.io.serialize.Serializer;
import de.stylextv.gsigns.world.map.MapImage;

public class MapImageSerializer extends Serializer<MapImage> {
	
	@Override
	public MapImage readFrom(StreamedFile file) {
		UUID id = Serializer.UUID.readFrom(file);
		
		byte[] pixels = file.read(MapImage.SIZE_IN_PIXELS);
		
		return new MapImage(id, pixels);
	}
	
	@Override
	public void writeTo(StreamedFile file, MapImage image) {
		UUID id = image.getID();
		
		Serializer.UUID.writeTo(file, id);
		
		byte[] pixels = image.getPixels();
		
		file.write(pixels);
	}
	
}
