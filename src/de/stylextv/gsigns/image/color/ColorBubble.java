package de.stylextv.gsigns.image.color;

import java.util.List;
import java.util.function.Predicate;

import de.stylextv.gsigns.image.color.voxel.ColorVoxel;
import de.stylextv.gsigns.image.color.voxel.scan.VoxelFilter;
import de.stylextv.gsigns.util.image.color.ColorFormat;
import de.stylextv.gsigns.util.image.color.ColorUtil;

public class ColorBubble {
	
	private byte color;
	
	private int rgb;
	
	private List<ColorVoxel> voxels;
	
	public ColorBubble(byte color, int[] rgbs) {
		this(color, ColorVoxel.fromRGBs(rgbs));
	}
	
	public ColorBubble(byte color, List<ColorVoxel> voxels) {
		this.color = color;
		this.voxels = voxels;
		
		this.rgb = averageRGB();
	}
	
	public void addToSpace(ColorSpace s) {
		drawBoundary(s);
		fillBoundary(s);
	}
	
	private void drawBoundary(ColorSpace s) {
		int[] rgbs = ColorVoxel.toRGBs(voxels);
		
		VoxelFilter f = VoxelFilter.withRGB(rgbs);
		
		List<ColorVoxel> list = s.scanVoxels(f);
		
		list.forEach((v) -> v.setColor(color));
	}
	
	private void fillBoundary(ColorSpace s) {
		s.fill(rgb, color);
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
	
	public int[] getBoundaryRGBs() {
		List<ColorVoxel> voxels = getBoundaryVoxels();
		
		return ColorVoxel.toRGBs(voxels);
	}
	
	public List<ColorVoxel> getBoundaryVoxels() {
		return voxels;
	}
	
	public static ColorBubble fromSpace(ColorSpace s, byte color) {
		Predicate<ColorVoxel> p = VoxelFilter.withColor(color);
		
		p = p.and(VoxelFilter.AT_BOUNDARY);
		
		List<ColorVoxel> voxels = s.scanVoxels(p);
		
		return new ColorBubble(color, voxels);
	}
	
}
