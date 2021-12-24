package de.stylextv.gsigns.image.color.voxel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.bukkit.map.MapPalette;

import de.stylextv.gsigns.image.color.ColorSpace;
import de.stylextv.gsigns.image.color.direction.ColorDirection;
import de.stylextv.gsigns.util.image.color.ColorComponent;
import de.stylextv.gsigns.util.image.color.ColorUtil;

public class ColorVoxel {
	
	private int rgb;
	
	private int r;
	private int g;
	private int b;
	
	private ColorSpace space;
	
	private byte color;
	
	public ColorVoxel(int rgb) {
		this(rgb, null);
	}
	
	public ColorVoxel(int rgb, ColorSpace s) {
		this.rgb = rgb;
		this.space = s;
		
		this.r = ColorUtil.getComponent(rgb, ColorComponent.RED);
		this.g = ColorUtil.getComponent(rgb, ColorComponent.GREEN);
		this.b = ColorUtil.getComponent(rgb, ColorComponent.BLUE);
	}
	
	@SuppressWarnings("deprecation")
	public void updateColor() {
		color = MapPalette.matchColor(r, g, b);
	}
	
	public boolean isAtBoundary() {
		for(ColorVoxel v : neighbours()) {
			
			byte color = v.getColor();
			
			if(color != this.color) return true;
		}
		
		return false;
	}
	
	public List<ColorVoxel> neighbours() {
		List<ColorVoxel> voxels = new ArrayList<>();
		
		for(ColorDirection d : ColorDirection.values()) {
			
			ColorVoxel v = getAdjacent(d);
			
			if(v == null) continue;
			
			voxels.add(v);
		}
		
		return voxels;
	}
	
	public ColorVoxel getAdjacent(ColorDirection d) {
		int dr = d.getDeltaRed();
		int dg = d.getDeltaGreen();
		int db = d.getDeltaBlue();
		
		return getAdjacent(dr, dg, db);
	}
	
	public ColorVoxel getAdjacent(int dr, int dg, int db) {
		int r = this.r + dr;
		int g = this.g + dg;
		int b = this.b + db;
		
		return space.getVoxel(r, g, b);
	}
	
	public int getRGB() {
		return rgb;
	}
	
	public int getRed() {
		return r;
	}
	
	public int getGreen() {
		return g;
	}
	
	public int getBlue() {
		return b;
	}
	
	public ColorSpace getSpace() {
		return space;
	}
	
	public byte getColor() {
		return color;
	}
	
	public void setColor(byte color) {
		this.color = color;
	}
	
	public static int[] toRGBs(Collection<ColorVoxel> voxels) {
		Stream<ColorVoxel> stream = voxels.stream();
		
		IntStream mapped = stream.mapToInt((v) -> v.getRGB());
		
		return mapped.toArray();
	}
	
	public static List<ColorVoxel> fromRGBs(int[] rgbs) {
		IntStream stream = Arrays.stream(rgbs);
		
		Stream<ColorVoxel> mapped = stream.mapToObj((rgb) -> new ColorVoxel(rgb));
		
		return mapped.toList();
	}
	
}
