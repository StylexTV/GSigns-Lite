package de.stylextv.gsigns.io.serialize.serializers;

import java.nio.ByteBuffer;

import de.stylextv.gsigns.io.file.StreamedFile;
import de.stylextv.gsigns.io.serialize.Serializer;

public class DoubleSerializer extends Serializer<Double> {
	
	private static final int SIZE_IN_BYTES = 8;
	
	@Override
	public Double readFrom(StreamedFile file) {
		byte[] data = file.read(SIZE_IN_BYTES);
		
		ByteBuffer buffer = ByteBuffer.wrap(data);
		
		return buffer.getDouble();
	}
	
	@Override
	public void writeTo(StreamedFile file, Double d) {
		ByteBuffer buffer = ByteBuffer.allocate(SIZE_IN_BYTES);
		
		buffer.putDouble(d);
		
		byte[] data = buffer.array();
		
		file.write(data);
	}
	
}
