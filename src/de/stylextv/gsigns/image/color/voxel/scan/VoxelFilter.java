package de.stylextv.gsigns.image.color.voxel.scan;

import java.util.function.Predicate;

import de.stylextv.gsigns.image.color.voxel.ColorVoxel;
import de.stylextv.gsigns.image.color.voxel.scan.filters.VoxelColorFilter;
import de.stylextv.gsigns.image.color.voxel.scan.filters.VoxelRGBFilter;
import de.stylextv.gsigns.world.scan.ScanFilter;

public class VoxelFilter extends ScanFilter<ColorVoxel> {
	
	public static final VoxelFilter AT_BOUNDARY = new VoxelFilter((v) -> {
		return v.isAtBoundary();
	});
	
	public VoxelFilter() {}
	
	public VoxelFilter(Predicate<ColorVoxel> predicate) {
		super(predicate);
	}
	
	public static VoxelFilter withRGB(int[] rgbs) {
		return new VoxelRGBFilter(rgbs);
	}
	
	public static VoxelFilter withColor(byte color) {
		return new VoxelColorFilter(color);
	}
	
}
