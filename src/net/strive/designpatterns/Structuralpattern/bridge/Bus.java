package net.strive.designpatterns.Structuralpattern.bridge;

public class Bus extends Vehicle {

	public Bus(Engine engine)
	{
		super(engine);
	}
	@Override
	public void setEngine() {
		System.out.println("set Bus Engine!");
		getEngine().setEngine();
	}
	
	

}
