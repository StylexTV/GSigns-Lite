package de.stylextv.gsigns.image.color;

import java.util.HashSet;
import java.util.List;

import de.stylextv.gsigns.context.server.ServerContext;
import de.stylextv.gsigns.context.server.specification.types.MinecraftVersion;
import de.stylextv.gsigns.image.color.io.ColorSpaceLocation;
import de.stylextv.gsigns.image.color.io.asset.ColorSpaceAsset;
import de.stylextv.gsigns.util.image.color.ColorFormat;
import de.stylextv.gsigns.util.image.color.ColorUtil;

public class ColorSpace {
	
	private static ColorSpace space;
	
	private ColorVoxel[] voxels = new ColorVoxel[16777216];
	
	public ColorSpace() {
		for(int i = 0; i < voxels.length; i++) {
			
			voxels[i] = new ColorVoxel(i, this);
		}
	}
	
	// TODO addBubble
	
	private List<ColorBubble> bubbles() {
		
	}
	
	private List<ColorVoxel> voxels() {
		
	}
	
	private HashSet<Byte> colors() {
		HashSet<Byte> colors = new HashSet<>();
		
		for(ColorVoxel v : voxels) {
			
			byte color = v.getColor();
			
			colors.add(color);
		}
		
		return colors;
	}
	
	public byte getColor(int rgb) {
		ColorVoxel v = getVoxel(rgb);
		
		return v.getColor();
	}
	
	public ColorVoxel getVoxel(int r, int g, int b) {
		boolean valid = ColorUtil.isValidComponent(r) && ColorUtil.isValidComponent(g) && ColorUtil.isValidComponent(b);
		
		if(!valid) return null;
		
		int rgb = ColorUtil.combineComponents(ColorFormat.RGB, r, g, b);
		
		return getVoxel(rgb);
	}
	
	public ColorVoxel getVoxel(int rgb) {
		return voxels[rgb];
	}
	
	public static ColorSpace getSpace() {
		if(space == null) {
			
			MinecraftVersion v = ServerContext.getMinecraftVersion();
			
			ColorSpaceLocation l = ColorSpaceLocation.fromVersion(v);
			
			ColorSpaceAsset a = new ColorSpaceAsset(l);
			
			space = a.readSpace();
		}
		
		return space;
	}
	
}
