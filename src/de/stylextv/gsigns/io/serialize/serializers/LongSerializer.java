package de.stylextv.gsigns.io.serialize.serializers;

import java.nio.ByteBuffer;

import de.stylextv.gsigns.io.file.StreamedFile;
import de.stylextv.gsigns.io.serialize.Serializer;

public class LongSerializer extends Serializer<Long> {
	
	private static final int SIZE_IN_BYTES = 8;
	
	@Override
	public Long readFrom(StreamedFile file) {
		byte[] data = file.read(SIZE_IN_BYTES);
		
		ByteBuffer buffer = ByteBuffer.wrap(data);
		
		return buffer.getLong();
	}
	
	@Override
	public void writeTo(StreamedFile file, Long l) {
		ByteBuffer buffer = ByteBuffer.allocate(SIZE_IN_BYTES);
		
		buffer.putLong(l);
		
		byte[] data = buffer.array();
		
		file.write(data);
	}
	
}
