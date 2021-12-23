package de.stylextv.gsigns.image.color.direction;

public enum ColorDirection {
	
	RIGHT(1, 0, 0), LEFT(-1, 0, 0), FRONT(0, 0, -1), BACK(0, 0, 1), UP(0, 1, 0), DOWN(0, -1, 0);
	
	private int dr;
	private int dg;
	private int db;
	
	private ColorDirection(int dr, int dg, int db) {
		this.dr = dr;
		this.dg = dg;
		this.db = db;
	}
	
	public int getDeltaRed() {
		return dr;
	}
	
	public int getDeltaGreen() {
		return dg;
	}
	
	public int getDeltaBlue() {
		return db;
	}
	
}
