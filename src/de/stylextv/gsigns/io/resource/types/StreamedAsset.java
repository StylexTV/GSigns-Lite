package de.stylextv.gsigns.io.resource.types;

import java.io.InputStream;
import java.io.OutputStream;

import de.stylextv.gsigns.GSigns;
import de.stylextv.gsigns.io.resource.StreamedResource;

public class StreamedAsset extends StreamedResource {
	
	private static final String ASSETS_FOLDER = "assets/";
	
	private String path;
	
	public StreamedAsset(String path) {
		this(path, true);
	}
	
	public StreamedAsset(String path, boolean compress) {
		super(compress);
		
		this.path = path;
	}
	
	@Override
	protected InputStream inputStream() {
		String s = ASSETS_FOLDER + path;
		
		return GSigns.getInstance().getResource(s);
	}
	
	@Override
	protected OutputStream outputStream() {
		return null;
	}
	
	public String getPath() {
		return path;
	}
	
}
