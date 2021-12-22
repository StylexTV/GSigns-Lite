package de.stylextv.gsigns.io.resource.types;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import de.stylextv.gsigns.Constants;
import de.stylextv.gsigns.io.resource.StreamedResource;

public class StreamedFile extends StreamedResource {
	
	private static final String PLUGIN_FOLDER = "plugins/" + Constants.PLUGIN_ID + "/";
	
	private File file;
	
	public StreamedFile(String path) {
		this(path, true);
	}
	
	public StreamedFile(String path, boolean compress) {
		this(new File(PLUGIN_FOLDER + path), compress);
	}
	
	private StreamedFile(File f, boolean compress) {
		super(compress);
		
		this.file = f;
		
		f.getParentFile().mkdirs();
	}
	
	@Override
	protected InputStream inputStream() {
		try {
			
			return new FileInputStream(file);
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	protected OutputStream outputStream() {
		try {
			
			return new FileOutputStream(file);
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public boolean exists() {
		if(!file.exists()) return false;
		
		return super.exists();
	}
	
	public File getFile() {
		return file;
	}
	
}
