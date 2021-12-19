package de.stylextv.gsigns.io.serialize.serializers;

import de.stylextv.gsigns.io.file.StreamedFile;
import de.stylextv.gsigns.io.serialize.Serializer;

public class StringSerializer extends Serializer<String> {
	
	@Override
	public String readFrom(StreamedFile file) {
		byte[] data = file.readAll();
		
		return new String(data);
	}
	
	@Override
	public void writeTo(StreamedFile file, String s) {
		byte[] data = s.getBytes();
		
		file.write(data);
	}
	
}
