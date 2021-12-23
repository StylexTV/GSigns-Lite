package de.stylextv.gsigns.image.color;

import java.util.List;

import de.stylextv.gsigns.util.image.color.ColorFormat;
import de.stylextv.gsigns.util.image.color.ColorUtil;

public class ColorBubble {
	
	private byte color;
	
	private int rgb;
	
	private List<ColorVoxel> voxels;
	
	public ColorBubble(byte color, ColorSpace s) {
		
	}
	
	public ColorBubble(byte color, List<Integer> rgbs) {
		this(color, ColorVoxel.fromRGBs(rgbs));
	}
	
	public ColorBubble(byte color, List<ColorVoxel> voxels) {
		this.color = color;
		this.voxels = voxels;
		
		this.rgb = averageRGB();
	}
	
	private int averageRGB() {
		int i = 0;
		int j = 0;
		int k = 0;
		
		for(ColorVoxel v : voxels) {
			
			i += v.getRed();
			j += v.getGreen();
			k += v.getBlue();
		}
		
		float f = 1.0f / voxels.size();
		
		int r = Math.round(i * f);
		int g = Math.round(j * f);
		int b = Math.round(k * f);
		
		return ColorUtil.combineComponents(ColorFormat.RGB, r, g, b);
	}
	
	public byte getColor() {
		return color;
	}
	
	public int getCenterRGB() {
		return rgb;
	}
	
	public List<ColorVoxel> getBoundaryVoxels() {
		return voxels;
	}
	
}
