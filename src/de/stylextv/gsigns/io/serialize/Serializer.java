package de.stylextv.gsigns.io.serialize;

import de.stylextv.gsigns.image.color.io.serialize.ColorBubbleSerializer;
import de.stylextv.gsigns.io.resource.StreamedResource;
import de.stylextv.gsigns.io.serialize.serializers.BooleanSerializer;
import de.stylextv.gsigns.io.serialize.serializers.CharSerializer;
import de.stylextv.gsigns.io.serialize.serializers.DoubleSerializer;
import de.stylextv.gsigns.io.serialize.serializers.FloatSerializer;
import de.stylextv.gsigns.io.serialize.serializers.IntegerSerializer;
import de.stylextv.gsigns.io.serialize.serializers.LongSerializer;
import de.stylextv.gsigns.io.serialize.serializers.ShortSerializer;
import de.stylextv.gsigns.io.serialize.serializers.StringSerializer;
import de.stylextv.gsigns.io.serialize.serializers.UUIDSerializer;
import de.stylextv.gsigns.io.serialize.serializers.list.types.BooleanListSerializer;
import de.stylextv.gsigns.io.serialize.serializers.list.types.DoubleListSerializer;
import de.stylextv.gsigns.io.serialize.serializers.list.types.FloatListSerializer;
import de.stylextv.gsigns.io.serialize.serializers.list.types.IntegerListSerializer;
import de.stylextv.gsigns.io.serialize.serializers.list.types.LongListSerializer;
import de.stylextv.gsigns.io.serialize.serializers.list.types.ShortListSerializer;
import de.stylextv.gsigns.io.serialize.serializers.list.types.UUIDListSerializer;
import de.stylextv.gsigns.world.map.io.serialize.MapImageSerializer;

public abstract class Serializer<T> {
	
	public static final MapImageSerializer MAP_IMAGE = new MapImageSerializer();
	
	public static final ColorBubbleSerializer COLOR_BUBBLE = new ColorBubbleSerializer();
	
	public static final StringSerializer STRING = new StringSerializer();
	public static final CharSerializer CHAR = new CharSerializer();
	
	public static final UUIDSerializer UUID = new UUIDSerializer();
	public static final UUIDListSerializer UUID_LIST = new UUIDListSerializer();
	
	public static final DoubleSerializer DOUBLE = new DoubleSerializer();
	public static final DoubleListSerializer DOUBLE_LIST = new DoubleListSerializer();
	
	public static final FloatSerializer FLOAT = new FloatSerializer();
	public static final FloatListSerializer FLOAT_LIST = new FloatListSerializer();
	
	public static final LongSerializer LONG = new LongSerializer();
	public static final LongListSerializer LONG_LIST = new LongListSerializer();
	
	public static final IntegerSerializer INTEGER = new IntegerSerializer();
	public static final IntegerListSerializer INTEGER_LIST = new IntegerListSerializer();
	
	public static final ShortSerializer SHORT = new ShortSerializer();
	public static final ShortListSerializer SHORT_LIST = new ShortListSerializer();
	
	public static final BooleanSerializer BOOLEAN = new BooleanSerializer();
	public static final BooleanListSerializer BOOLEAN_LIST = new BooleanListSerializer();
	
	public abstract T readFrom(StreamedResource r);
	public abstract void writeTo(StreamedResource r, T t);
	
}
