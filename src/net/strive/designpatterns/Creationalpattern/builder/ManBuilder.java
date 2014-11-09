package net.strive.designpatterns.Creationalpattern.builder;

public class ManBuilder implements PersonBuilder {
	Person person;
	public ManBuilder()
	{
		person=new Man();
	}
	public void buildBody() {
		person.setBody("build man's body...");
	}

	public void buildFoot() {
		person.setFoot("build man's foot...");

	}

	public void buildHead() {
		person.setHead("build man's head...");

	}

	public Person buildPerson() {
		return person;
	}

}
