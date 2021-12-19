package de.stylextv.gsigns.io.file.types;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import de.stylextv.gsigns.io.file.StreamedFile;
import de.stylextv.gsigns.io.serialize.Serializer;

public class CompressedFile extends StreamedFile {
	
	private static final int COMPRESSION_LEVEL = Deflater.BEST_COMPRESSION;
	
	private static final int FILE_VERSION = 0x9BA2F52;
	
	public CompressedFile(String path) {
		super(path);
	}
	
	@Override
	public void setInputStream(InputStream stream) {
		stream = new InflaterInputStream(stream);
		
		super.setInputStream(stream);
	}
	
	@Override
	public void setOutputStream(OutputStream stream) {
		Deflater deflater = new Deflater(COMPRESSION_LEVEL);
		
		stream = new DeflaterOutputStream(stream, deflater);
		
		super.setOutputStream(stream);
	}
	
	@Override
	public boolean exists() {
		if(!super.exists()) return false;
		
		int i = Serializer.INTEGER.readFrom(this);
		
		return i == FILE_VERSION;
	}
	
}
