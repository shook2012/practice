package net.strive.designpatterns.Creationalpattern.factoryMethod;

public class StudentWorkFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		return new StudentWork();
	}

}
