package de.stylextv.gsigns.world.map.io.serialize;

import java.util.UUID;

import de.stylextv.gsigns.io.resource.StreamedResource;
import de.stylextv.gsigns.io.serialize.Serializer;
import de.stylextv.gsigns.world.map.MapImage;

public class MapImageSerializer extends Serializer<MapImage> {
	
	@Override
	public MapImage readFrom(StreamedResource r) {
		UUID id = Serializer.UUID.readFrom(r);
		
		byte[] pixels = r.read(MapImage.SIZE_IN_PIXELS);
		
		return new MapImage(id, pixels);
	}
	
	@Override
	public void writeTo(StreamedResource r, MapImage image) {
		UUID id = image.getID();
		
		Serializer.UUID.writeTo(r, id);
		
		byte[] pixels = image.getPixels();
		
		r.write(pixels);
	}
	
}
