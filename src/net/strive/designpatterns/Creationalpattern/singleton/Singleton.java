package net.strive.designpatterns.Creationalpattern.singleton;

public class Singleton {
	
	private static Singleton single;
	
	public static  Singleton getInstance()
	{
		if(single==null)
		{
			single= new Singleton();
		}
		return single;
	}
	
}
