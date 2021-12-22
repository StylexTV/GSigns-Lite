package de.stylextv.gsigns.io.serialize.serializers;

import java.nio.ByteBuffer;

import de.stylextv.gsigns.io.resource.StreamedResource;
import de.stylextv.gsigns.io.serialize.Serializer;

public class ShortSerializer extends Serializer<Short> {
	
	private static final int SIZE_IN_BYTES = 2;
	
	@Override
	public Short readFrom(StreamedResource r) {
		byte[] data = r.read(SIZE_IN_BYTES);
		
		ByteBuffer buffer = ByteBuffer.wrap(data);
		
		return buffer.getShort();
	}
	
	@Override
	public void writeTo(StreamedResource r, Short s) {
		ByteBuffer buffer = ByteBuffer.allocate(SIZE_IN_BYTES);
		
		buffer.putShort(s);
		
		byte[] data = buffer.array();
		
		r.write(data);
	}
	
}
