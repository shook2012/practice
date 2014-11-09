package net.strive.designpatterns.Structuralpattern.bridge;

public class Trouser extends Clothing {

	@Override
	public void personDressCloth(Person person) {
		System.out.println(person.getType()+"dress the trouser!");
	}

}
