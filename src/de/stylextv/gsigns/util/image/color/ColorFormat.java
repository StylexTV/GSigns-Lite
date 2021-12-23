package de.stylextv.gsigns.util.image.color;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ColorFormat {
	
	public static final ColorFormat RGB = new ColorFormat(2, 1, 0);
	
	public static final ColorFormat ARGB = new ColorFormat(2, 1, 0, 3);
	public static final ColorFormat RGBA = new ColorFormat(3, 2, 1, 0);
	
	private static final int INVALID_INDEX = -1;
	
	private HashMap<ColorComponent, Integer> indices;
	
	public ColorFormat(int redIndex, int greenIndex, int blueIndex, int alphaIndex) {
		this(redIndex, greenIndex, blueIndex);
		
		setIndex(ColorComponent.ALPHA, alphaIndex);
	}
	
	public ColorFormat(int redIndex, int greenIndex, int blueIndex) {
		setIndex(ColorComponent.RED, redIndex);
		setIndex(ColorComponent.GREEN, greenIndex);
		setIndex(ColorComponent.BLUE, blueIndex);
	}
	
	// TODO totalValues method to replace magic values
	
	public int length() {
		return components().size();
	}
	
	public ColorComponent getComponent(int index) {
		for(Entry<ColorComponent, Integer> e : indices.entrySet()) {
			
			int i = e.getValue();
			
			if(i == index) return e.getKey();
		}
		
		return null;
	}
	
	public Set<ColorComponent> components() {
		return indices.keySet();
	}
	
	public boolean hasTransparency() {
		return hasComponent(ColorComponent.ALPHA);
	}
	
	public boolean hasComponent(ColorComponent c) {
		return getIndex(c) != INVALID_INDEX;
	}
	
	public int getIndex(ColorComponent c) {
		return indices.getOrDefault(c, INVALID_INDEX);
	}
	
	private void setIndex(ColorComponent c, int index) {
		indices.put(c, index);
	}
	
}
