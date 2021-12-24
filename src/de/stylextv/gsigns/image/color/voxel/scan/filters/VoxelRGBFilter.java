package de.stylextv.gsigns.image.color.voxel.scan.filters;

import de.stylextv.gsigns.image.color.voxel.ColorVoxel;
import de.stylextv.gsigns.image.color.voxel.scan.VoxelFilter;

public class VoxelRGBFilter extends VoxelFilter {
	
	private int[] rgbs;
	
	public VoxelRGBFilter(int[] rgbs) {
		this.rgbs = rgbs;
	}
	
	@Override
	public boolean test(ColorVoxel v) {
		int rgb = v.getRGB();
		
		return test(rgb);
	}
	
	public boolean test(int rgb) {
		for(int i : rgbs) {
			
			if(i == rgb) return true;
		}
		
		return false;
	}
	
	public int[] getRGBs() {
		return rgbs;
	}
	
}
