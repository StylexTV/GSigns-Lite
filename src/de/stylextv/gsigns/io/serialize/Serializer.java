package de.stylextv.gsigns.io.serialize;

import de.stylextv.gsigns.io.file.StreamedFile;
import de.stylextv.gsigns.io.serialize.serializers.BooleanSerializer;
import de.stylextv.gsigns.io.serialize.serializers.CharSerializer;
import de.stylextv.gsigns.io.serialize.serializers.DoubleSerializer;
import de.stylextv.gsigns.io.serialize.serializers.FloatSerializer;
import de.stylextv.gsigns.io.serialize.serializers.IntegerSerializer;
import de.stylextv.gsigns.io.serialize.serializers.LongSerializer;
import de.stylextv.gsigns.io.serialize.serializers.ShortSerializer;
import de.stylextv.gsigns.io.serialize.serializers.StringSerializer;
import de.stylextv.gsigns.io.serialize.serializers.UUIDSerializer;
import de.stylextv.gsigns.world.map.io.serialize.MapImageSerializer;

public abstract class Serializer<T> {
	
	public static final MapImageSerializer MAP_IMAGE = new MapImageSerializer();
	
	public static final StringSerializer STRING = new StringSerializer();
	public static final CharSerializer CHAR = new CharSerializer();
	
	public static final UUIDSerializer UUID = new UUIDSerializer();
	
	public static final DoubleSerializer DOUBLE = new DoubleSerializer();
	public static final FloatSerializer FLOAT = new FloatSerializer();
	
	public static final LongSerializer LONG = new LongSerializer();
	public static final IntegerSerializer INTEGER = new IntegerSerializer();
	public static final ShortSerializer SHORT = new ShortSerializer();
	
	public static final BooleanSerializer BOOLEAN = new BooleanSerializer();
	
	public abstract T readFrom(StreamedFile file);
	public abstract void writeTo(StreamedFile file, T t);
	
}
