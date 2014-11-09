package net.strive.designpatterns.Structuralpattern.bridge;

public class Jacket extends Clothing {

	@Override
	public void personDressCloth(Person person) {
		System.out.println(person.getType()+"dress the jacket!");
	}

}
