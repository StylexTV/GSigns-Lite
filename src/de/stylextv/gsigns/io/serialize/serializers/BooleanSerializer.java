package de.stylextv.gsigns.io.serialize.serializers;

import de.stylextv.gsigns.io.file.StreamedFile;
import de.stylextv.gsigns.io.serialize.Serializer;

public class BooleanSerializer extends Serializer<Boolean> {
	
	@Override
	public Boolean readFrom(StreamedFile file) {
		byte b = file.read();
		
		return b != 0;
	}
	
	@Override
	public void writeTo(StreamedFile file, Boolean b) {
		file.write((byte) (b ? 1 : 0));
	}
	
}
