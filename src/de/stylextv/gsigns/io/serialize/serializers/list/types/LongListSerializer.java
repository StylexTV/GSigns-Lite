package de.stylextv.gsigns.io.serialize.serializers.list.types;

import de.stylextv.gsigns.io.serialize.Serializer;
import de.stylextv.gsigns.io.serialize.serializers.list.ListSerializer;

public class LongListSerializer extends ListSerializer<Long, Serializer<Long>> {
	
	public LongListSerializer() {
		super(Serializer.LONG);
	}
	
}
