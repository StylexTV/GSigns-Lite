package de.stylextv.gsigns.image.color.io.asset;

import java.util.List;

import de.stylextv.gsigns.image.color.ColorBubble;
import de.stylextv.gsigns.image.color.ColorSpace;
import de.stylextv.gsigns.image.color.io.ColorSpaceLocation;
import de.stylextv.gsigns.io.resource.types.StreamedAsset;
import de.stylextv.gsigns.io.serialize.Serializer;

public class ColorSpaceAsset extends StreamedAsset {
	
	private static final String FOLDER = "color_spaces/";
	
	public ColorSpaceAsset(ColorSpaceLocation l) {
		this(l.getPath());
	}
	
	public ColorSpaceAsset(String path) {
		super(FOLDER + path);
	}
	
	public ColorSpace readSpace() {
		ColorSpace s = new ColorSpace();
		
		while(!isEmpty()) {
			
			ColorBubble b = Serializer.COLOR_BUBBLE.readFrom(this);
			
			b.addToSpace(s);
		}
		
		return s;
	}
	
	public void writeSpace(ColorSpace s) {
		List<ColorBubble> bubbles = s.bubbles();
		
		bubbles.forEach((b) -> Serializer.COLOR_BUBBLE.writeTo(this, b));
	}
	
}
