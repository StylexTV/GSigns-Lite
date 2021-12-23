package de.stylextv.gsigns.util.image.color;

public class ColorUtil {
	
	private static final int COMPONENT_LENGTH = 8;
	private static final int MAX_COMPONENT_VALUE = 255;
	
	public static int reformat(int color, ColorFormat from, ColorFormat to) {
		int i = 0;
		
		for(ColorComponent c : from.components()) {
			
			if(!to.hasComponent(c)) continue;
			
			int value = getComponent(color, from, c);
			
			i = setComponent(i, to, c, value);
		}
		
		return i;
	}
	
	public static int[] splitComponents(int color, ColorFormat f) {
		int l = f.length();
		
		int[] values = new int[l];
		
		for(int j = 0; j < l; j++) {
			
			int index = l - j - 1;
			
			int value = getComponent(color, index);
			
			values[j] = value;
		}
		
		return values;
	}
	
	public static int combineComponents(ColorFormat f, int... values) {
		int i = 0;
		
		int l = f.length();
		
		for(int j = 0; j < l; j++) {
			
			int index = l - j - 1;
			
			int value = values[j];
			
			i = setComponent(i, index, value);
		}
		
		return i;
	}
	
	public static int getComponent(int rgb, ColorComponent c) {
		return getComponent(rgb, ColorFormat.RGB, c);
	}
	
	public static int getComponent(int color, ColorFormat f, ColorComponent c) {
		int index = f.getIndex(c);
		
		return getComponent(color, index);
	}
	
	private static int getComponent(int color, int index) {
		int l = COMPONENT_LENGTH * index;
		
		int i = color >> l;
		
		return i & MAX_COMPONENT_VALUE;
	}
	
	public static int setComponent(int rgb, ColorComponent c, int value) {
		return setComponent(rgb, ColorFormat.RGB, c, value);
	}
	
	public static int setComponent(int color, ColorFormat f, ColorComponent c, int value) {
		int index = f.getIndex(c);
		
		return setComponent(color, index, value);
	}
	
	private static int setComponent(int color, int index, int value) {
		int l = COMPONENT_LENGTH * index;
		
		int i = value << l;
		
		int mask = MAX_COMPONENT_VALUE << l;
		
		color &= ~mask;
		
		return color | i;
	}
	
	// TODO isValidColor and isValidRGB methods
	
	public static boolean isValidComponent(int value) {
		return value >= 0 && value <= MAX_COMPONENT_VALUE;
	}
	
}
