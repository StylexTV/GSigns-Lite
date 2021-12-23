package de.stylextv.gsigns.image.color.io.asset;

import de.stylextv.gsigns.image.color.ColorSpace;
import de.stylextv.gsigns.image.color.io.ColorSpaceLocation;
import de.stylextv.gsigns.io.resource.types.StreamedAsset;

public class ColorSpaceAsset extends StreamedAsset {
	
	private static final String FOLDER = "color_spaces/";
	
	public ColorSpaceAsset(ColorSpaceLocation l) {
		this(l.getPath());
	}
	
	public ColorSpaceAsset(String path) {
		super(FOLDER + path);
	}
	
	public ColorSpace readSpace() {
		
	}
	
	public void writeSpace(ColorSpace s) {
		
	}
	
}
