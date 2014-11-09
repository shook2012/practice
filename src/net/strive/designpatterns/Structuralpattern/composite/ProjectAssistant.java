package net.strive.designpatterns.Structuralpattern.composite;

public class ProjectAssistant extends Employer {
	
	public ProjectAssistant(String name)
	{
		setName(name);
		employers=null;
	}
	@Override
	public void add(Employer employer) {

	}

	@Override
	public void delete(Employer employer) {

	}

}
