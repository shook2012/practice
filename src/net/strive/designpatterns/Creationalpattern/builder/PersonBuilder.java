package net.strive.designpatterns.Creationalpattern.builder;

public interface PersonBuilder {
	void buildHead();
	void buildBody();
	void buildFoot();
	Person buildPerson();
	
}
