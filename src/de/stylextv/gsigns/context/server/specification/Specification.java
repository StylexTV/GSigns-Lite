package de.stylextv.gsigns.context.server.specification;

public class Specification {
	
	private String name;
	
	private String label;
	
	public Specification(String name) {
		this(name, name);
	}
	
	public Specification(String name, String label) {
		this.name = name;
		this.label = label.toLowerCase();
	}
	
	public boolean matches(String s) {
		s = s.toLowerCase();
		
		return s.contains(label);
	}
	
	@Override
	public String toString() {
		return name.toUpperCase();
	}
	
	public String getName() {
		return name;
	}
	
	public String getLabel() {
		return label;
	}
	
}
