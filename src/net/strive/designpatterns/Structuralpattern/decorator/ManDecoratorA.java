package net.strive.designpatterns.Structuralpattern.decorator;

public class ManDecoratorA extends Decorator {
	
	public void eat()
	{
		super.eat();
		reEat();
		System.out.println("Class ManDecoratorA!");
	}
	
	public void reEat()
	{
		System.out.println("再一起吃饭...");
	}
}
