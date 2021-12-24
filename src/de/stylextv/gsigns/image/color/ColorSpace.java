package de.stylextv.gsigns.image.color;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import de.stylextv.gsigns.context.server.ServerContext;
import de.stylextv.gsigns.context.server.specification.types.MinecraftVersion;
import de.stylextv.gsigns.image.color.io.ColorSpaceLocation;
import de.stylextv.gsigns.image.color.io.asset.ColorSpaceAsset;
import de.stylextv.gsigns.image.color.voxel.ColorVoxel;
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
	
	public void update() {
		for(ColorVoxel v : voxels) {
			
			v.updateColor();
		}
	}
	
	public void fill(int rgb, byte color) {
		List<ColorVoxel> list = new ArrayList<>();
		
		ColorVoxel start = getVoxel(rgb);
		
		list.add(start);
		
		while(!list.isEmpty()) {
			
			start = list.remove(0);
			
			start.setColor(color);
			
			List<ColorVoxel> neighbours = start.neighbours();
			
			neighbours.forEach((v) -> {
				
				if(v.getColor() == color) return;
				
				list.add(v);
			});
		}
	}
	
	public List<ColorBubble> bubbles() {
		HashSet<Byte> colors = colors();
		
		Stream<Byte> stream = colors.stream();
		
		Stream<ColorBubble> mapped = stream.map((color) -> ColorBubble.fromSpace(this, color));
		
		return mapped.toList();
	}
	
	private HashSet<Byte> colors() {
		HashSet<Byte> colors = new HashSet<>();
		
		for(ColorVoxel v : voxels) {
			
			byte color = v.getColor();
			
			colors.add(color);
		}
		
		return colors;
	}
	
	public List<ColorVoxel> scanVoxels(Predicate<ColorVoxel> p) {
		Stream<ColorVoxel> stream = Stream.of(voxels);
		
		stream.filter(p);
		
		return stream.toList();
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
