package de.stylextv.gsigns.io.serialize.serializers;

import java.nio.ByteBuffer;

import de.stylextv.gsigns.io.file.StreamedFile;
import de.stylextv.gsigns.io.serialize.Serializer;

public class FloatSerializer extends Serializer<Float> {
	
	private static final int SIZE_IN_BYTES = 4;
	
	@Override
	public Float readFrom(StreamedFile file) {
		byte[] data = file.read(SIZE_IN_BYTES);
		
		ByteBuffer buffer = ByteBuffer.wrap(data);
		
		return buffer.getFloat();
	}
	
	@Override
	public void writeTo(StreamedFile file, Float f) {
		ByteBuffer buffer = ByteBuffer.allocate(SIZE_IN_BYTES);
		
		buffer.putFloat(f);
		
		byte[] data = buffer.array();
		
		file.write(data);
	}
	
}
