package de.stylextv.gsigns.io.serialize.serializers;

import java.nio.ByteBuffer;

import de.stylextv.gsigns.io.file.StreamedFile;
import de.stylextv.gsigns.io.serialize.Serializer;

public class IntegerSerializer extends Serializer<Integer> {
	
	private static final int SIZE_IN_BYTES = 4;
	
	@Override
	public Integer readFrom(StreamedFile file) {
		byte[] data = file.read(SIZE_IN_BYTES);
		
		ByteBuffer buffer = ByteBuffer.wrap(data);
		
		return buffer.getInt();
	}
	
	@Override
	public void writeTo(StreamedFile file, Integer i) {
		ByteBuffer buffer = ByteBuffer.allocate(SIZE_IN_BYTES);
		
		buffer.putInt(i);
		
		byte[] data = buffer.array();
		
		file.write(data);
	}
	
}
