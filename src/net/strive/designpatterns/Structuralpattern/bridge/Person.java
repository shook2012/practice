package net.strive.designpatterns.Structuralpattern.bridge;

public abstract class Person {
	
	private Clothing clothing;
	
	private String type;
	
	public Clothing getClothing()
	{
		return clothing;
	}
	public void setClothing()
	{
//		this.clothing=ClothingFactory.getClothing();
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public abstract void dress();
}
