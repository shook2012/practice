package net.strive.designpatterns.Structuralpattern.bridge;

public class Man extends Person {

	public Man()
	{	
		setType("Man..");
	}
	public void dress() {
		Clothing clothing=getClothing();
		clothing.personDressCloth(this);
	}

}
