package de.stylextv.gsigns.image.color.voxel.scan.filters;

import de.stylextv.gsigns.image.color.voxel.ColorVoxel;
import de.stylextv.gsigns.image.color.voxel.scan.VoxelFilter;

public class VoxelColorFilter extends VoxelFilter {
	
	private byte color;
	
	public VoxelColorFilter(byte color) {
		this.color = color;
	}
	
	@Override
	public boolean test(ColorVoxel v) {
		byte color = v.getColor();
		
		return color == this.color;
	}
	
	public byte getColor() {
		return color;
	}
	
}
