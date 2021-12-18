package de.stylextv.gsigns.command.argument;

public class ArgumentList {
	
	private String[] args;
	
	public ArgumentList() {
		this(new String[0]);
	}
	
	public ArgumentList(String[] args) {
		this.args = args;
	}
	
	public boolean isNumeric(int i) {
		String s = get(i);
		
		return ArgumentHelper.isNumeric(s);
	}
	
	public boolean isInt(int i) {
		String s = get(i);
		
		return ArgumentHelper.isInt(s);
	}
	
	public float getFloat(int i) {
		String s = get(i);
		
		return ArgumentHelper.toFloat(s);
	}
	
	public int getInt(int i) {
		String s = get(i);
		
		return ArgumentHelper.toInt(s);
	}
	
	public String get(int i) {
		return args[i];
	}
	
	public boolean hasAtLeast(int l) {
		return length() >= l;
	}
	
	public boolean hasAtMost(int l) {
		return length() <= l;
	}
	
	public boolean hasMoreThan(int l) {
		return length() > l;
	}
	
	public boolean hasLessThan(int l) {
		return length() < l;
	}
	
	public boolean hasExactly(int l) {
		return length() == l;
	}
	
	public int length() {
		return args.length;
	}
	
	public String[] getArguments() {
		return args;
	}
	
}
