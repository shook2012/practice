package net.strive.game.tank;

public class Scope {
	
	private int min;
	private int max;
	private String name;
	
	public Scope(int min, int max, String name) {
		this.min = min;
		this.max = max;
		this.name = name;
	}
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
