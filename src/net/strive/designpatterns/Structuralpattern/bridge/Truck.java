package net.strive.designpatterns.Structuralpattern.bridge;

public class Truck extends Vehicle {

	public Truck(Engine engine)
	{
		super(engine);
	}
	
	@Override
	public void setEngine() {
		System.out.println("set Truck Engine");
		getEngine().setEngine();
	}

}
