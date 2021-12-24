package de.stylextv.gsigns.io.serialize.serializers.list.types;

import de.stylextv.gsigns.io.serialize.Serializer;
import de.stylextv.gsigns.io.serialize.serializers.list.ListSerializer;

public class FloatListSerializer extends ListSerializer<Float, Serializer<Float>> {
	
	public FloatListSerializer() {
		super(Serializer.FLOAT);
	}
	
}
