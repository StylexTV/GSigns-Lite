package de.stylextv.gsigns.io.serialize.serializers;

import java.nio.ByteBuffer;

import de.stylextv.gsigns.io.file.StreamedFile;
import de.stylextv.gsigns.io.serialize.Serializer;

public class CharSerializer extends Serializer<Character> {
	
	private static final int SIZE_IN_BYTES = 2;
	
	@Override
	public Character readFrom(StreamedFile file) {
		byte[] data = file.read(SIZE_IN_BYTES);
		
		ByteBuffer buffer = ByteBuffer.wrap(data);
		
		return buffer.getChar();
	}
	
	@Override
	public void writeTo(StreamedFile file, Character c) {
		ByteBuffer buffer = ByteBuffer.allocate(SIZE_IN_BYTES);
		
		buffer.putChar(c);
		
		byte[] data = buffer.array();
		
		file.write(data);
	}
	
}
