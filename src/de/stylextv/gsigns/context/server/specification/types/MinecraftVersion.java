package de.stylextv.gsigns.context.server.specification.types;

import java.util.ArrayList;
import java.util.List;

import de.stylextv.gsigns.context.server.specification.Specification;

public class MinecraftVersion extends Specification {
	
	private static List<MinecraftVersion> versions = new ArrayList<>();
	
	public static final MinecraftVersion RELEASE_1_19 = new MinecraftVersion(45, Type.RELEASE, "1.19");
	
	public static final MinecraftVersion RELEASE_1_18_1 = new MinecraftVersion(44, Type.RELEASE, "1.18.1");
	public static final MinecraftVersion RELEASE_1_18 = new MinecraftVersion(43, Type.RELEASE, "1.18");
	
	public static final MinecraftVersion RELEASE_1_17_1 = new MinecraftVersion(42, Type.RELEASE, "1.17.1");
	public static final MinecraftVersion RELEASE_1_17 = new MinecraftVersion(41, Type.RELEASE, "1.17");
	
	public static final MinecraftVersion RELEASE_1_16_5 = new MinecraftVersion(40, Type.RELEASE, "1.16.5");
	public static final MinecraftVersion RELEASE_1_16_4 = new MinecraftVersion(39, Type.RELEASE, "1.16.4");
	public static final MinecraftVersion RELEASE_1_16_3 = new MinecraftVersion(38, Type.RELEASE, "1.16.3");
	public static final MinecraftVersion RELEASE_1_16_2 = new MinecraftVersion(37, Type.RELEASE, "1.16.2");
	public static final MinecraftVersion RELEASE_1_16_1 = new MinecraftVersion(36, Type.RELEASE, "1.16.1");
	public static final MinecraftVersion RELEASE_1_16 = new MinecraftVersion(35, Type.RELEASE, "1.16");
	
	public static final MinecraftVersion RELEASE_1_15_2 = new MinecraftVersion(34, Type.RELEASE, "1.15.2");
	public static final MinecraftVersion RELEASE_1_15_1 = new MinecraftVersion(33, Type.RELEASE, "1.15.1");
	public static final MinecraftVersion RELEASE_1_15 = new MinecraftVersion(32, Type.RELEASE, "1.15");
	
	public static final MinecraftVersion RELEASE_1_14_4 = new MinecraftVersion(31, Type.RELEASE, "1.14.4");
	public static final MinecraftVersion RELEASE_1_14_3 = new MinecraftVersion(30, Type.RELEASE, "1.14.3");
	public static final MinecraftVersion RELEASE_1_14_2 = new MinecraftVersion(29, Type.RELEASE, "1.14.2");
	public static final MinecraftVersion RELEASE_1_14_1 = new MinecraftVersion(28, Type.RELEASE, "1.14.1");
	public static final MinecraftVersion RELEASE_1_14 = new MinecraftVersion(27, Type.RELEASE, "1.14");
	
	public static final MinecraftVersion RELEASE_1_13_2 = new MinecraftVersion(26, Type.RELEASE, "1.13.2");
	public static final MinecraftVersion RELEASE_1_13_1 = new MinecraftVersion(25, Type.RELEASE, "1.13.1");
	public static final MinecraftVersion RELEASE_1_13 = new MinecraftVersion(24, Type.RELEASE, "1.13");
	
	public static final MinecraftVersion RELEASE_1_12_2 = new MinecraftVersion(23, Type.RELEASE, "1.12.2");
	public static final MinecraftVersion RELEASE_1_12_1 = new MinecraftVersion(22, Type.RELEASE, "1.12.1");
	public static final MinecraftVersion RELEASE_1_12 = new MinecraftVersion(21, Type.RELEASE, "1.12");
	
	public static final MinecraftVersion RELEASE_1_11_2 = new MinecraftVersion(20, Type.RELEASE, "1.11.2");
	public static final MinecraftVersion RELEASE_1_11_1 = new MinecraftVersion(19, Type.RELEASE, "1.11.1");
	public static final MinecraftVersion RELEASE_1_11 = new MinecraftVersion(18, Type.RELEASE, "1.11");
	
	public static final MinecraftVersion RELEASE_1_10_2 = new MinecraftVersion(17, Type.RELEASE, "1.10.2");
	public static final MinecraftVersion RELEASE_1_10_1 = new MinecraftVersion(16, Type.RELEASE, "1.10.1");
	public static final MinecraftVersion RELEASE_1_10 = new MinecraftVersion(15, Type.RELEASE, "1.10");
	
	public static final MinecraftVersion RELEASE_1_9_4 = new MinecraftVersion(14, Type.RELEASE, "1.9.4");
	public static final MinecraftVersion RELEASE_1_9_3 = new MinecraftVersion(13, Type.RELEASE, "1.9.3");
	public static final MinecraftVersion RELEASE_1_9_2 = new MinecraftVersion(12, Type.RELEASE, "1.9.2");
	public static final MinecraftVersion RELEASE_1_9_1 = new MinecraftVersion(11, Type.RELEASE, "1.9.1");
	public static final MinecraftVersion RELEASE_1_9 = new MinecraftVersion(10, Type.RELEASE, "1.9");
	
	public static final MinecraftVersion RELEASE_1_8_9 = new MinecraftVersion(9, Type.RELEASE, "1.8.9");
	public static final MinecraftVersion RELEASE_1_8_8 = new MinecraftVersion(8, Type.RELEASE, "1.8.8");
	public static final MinecraftVersion RELEASE_1_8_7 = new MinecraftVersion(7, Type.RELEASE, "1.8.7");
	public static final MinecraftVersion RELEASE_1_8_6 = new MinecraftVersion(6, Type.RELEASE, "1.8.6");
	public static final MinecraftVersion RELEASE_1_8_5 = new MinecraftVersion(5, Type.RELEASE, "1.8.5");
	public static final MinecraftVersion RELEASE_1_8_4 = new MinecraftVersion(4, Type.RELEASE, "1.8.4");
	public static final MinecraftVersion RELEASE_1_8_3 = new MinecraftVersion(3, Type.RELEASE, "1.8.3");
	public static final MinecraftVersion RELEASE_1_8_2 = new MinecraftVersion(2, Type.RELEASE, "1.8.2");
	public static final MinecraftVersion RELEASE_1_8_1 = new MinecraftVersion(1, Type.RELEASE, "1.8.1");
	public static final MinecraftVersion RELEASE_1_8 = new MinecraftVersion(0, Type.RELEASE, "1.8");
	
	public static final MinecraftVersion UNKNOWN = new MinecraftVersion("Unknown");
	
	private int id;
	
	private Type type;
	
	public MinecraftVersion(String name) {
		this(Integer.MAX_VALUE, name, name);
	}
	
	public MinecraftVersion(int id, Type type, String label) {
		this(id, type.toString() + " " + label, label);
		
		this.type = type;
	}
	
	public MinecraftVersion(int id, String name, String label) {
		super(name, label);
		
		this.id = id;
		
		versions.add(this);
	}
	
	public boolean isNewerOrEqual(MinecraftVersion v) {
		return compareTo(v) >= 0;
	}
	
	public boolean isOlderOrEqual(MinecraftVersion v) {
		return compareTo(v) <= 0;
	}
	
	public boolean isNewerThan(MinecraftVersion v) {
		return compareTo(v) > 0;
	}
	
	public boolean isOlderThan(MinecraftVersion v) {
		return compareTo(v) < 0;
	}
	
	private int compareTo(MinecraftVersion v) {
		int i = v.getID();
		
		return Integer.compare(id, i);
	}
	
	public int getID() {
		return id;
	}
	
	public Type getType() {
		return type;
	}
	
	public static MinecraftVersion fromString(String s) {
		for(MinecraftVersion version : versions) {
			
			if(version.matches(s)) return version;
		}
		
		return UNKNOWN;
	}
	
	public static List<MinecraftVersion> getVersions() {
		return versions;
	}
	
	public enum Type {
		
		RELEASE, ALPHA, BETA, CLASSIC;
		
	}
	
}
