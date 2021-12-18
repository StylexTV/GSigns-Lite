package de.stylextv.gsigns.io.types;

import java.nio.ByteBuffer;

import de.stylextv.gsigns.io.StreamedFile;

public class PrimitiveFile extends StreamedFile {
	
	public PrimitiveFile(String path) {
		super(path);
	}
	
	public String readString() {
		byte[] data = readAll();
		
		return new String(data);
	}
	
	public void writeString(String s) {
		byte[] data = s.getBytes();
		
		write(data);
	}
	
	public int readInt() {
		byte[] data = read(4);
		
		ByteBuffer buffer = ByteBuffer.wrap(data);
		
		return buffer.getInt();
	}
	
	public void writeInt(int i) {
		ByteBuffer buffer = ByteBuffer.allocate(4);
		
		buffer.putInt(i);
		
		byte[] data = buffer.array();
		
		write(data);
	}
	
}
