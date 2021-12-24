package de.stylextv.gsigns.image.color.io.serialize;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import de.stylextv.gsigns.image.color.ColorBubble;
import de.stylextv.gsigns.io.resource.StreamedResource;
import de.stylextv.gsigns.io.serialize.Serializer;

public class ColorBubbleSerializer extends Serializer<ColorBubble> {
	
	@Override
	public ColorBubble readFrom(StreamedResource r) {
		byte color = r.read();
		
		List<Integer> list = Serializer.INTEGER_LIST.readFrom(r);
		
		Stream<Integer> stream = list.stream();
		
		IntStream mapped = stream.mapToInt(i -> i);
		
		int[] rgbs = mapped.toArray();
		
		return new ColorBubble(color, rgbs);
	}
	
	// TODO voxel serializer?
	@Override
	public void writeTo(StreamedResource r, ColorBubble b) {
		byte color = b.getColor();
		
		r.write(color);
		
		int[] rgbs = b.getBoundaryRGBs();
		
		Serializer.INTEGER_LIST.writeTo(r, rgbs);
	}
	
}
