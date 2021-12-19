package de.stylextv.gsigns.io.serialize.serializers;

import java.util.UUID;

import de.stylextv.gsigns.io.file.StreamedFile;
import de.stylextv.gsigns.io.serialize.Serializer;

public class UUIDSerializer extends Serializer<UUID> {
	
	@Override
	public UUID readFrom(StreamedFile file) {
		long l1 = Serializer.LONG.readFrom(file);
		long l2 = Serializer.LONG.readFrom(file);
		
		return new UUID(l1, l2);
	}
	
	@Override
	public void writeTo(StreamedFile file, UUID id) {
		long l1 = id.getMostSignificantBits();
		long l2 = id.getLeastSignificantBits();
		
		Serializer.LONG.writeTo(file, l1);
		Serializer.LONG.writeTo(file, l2);
	}
	
}
