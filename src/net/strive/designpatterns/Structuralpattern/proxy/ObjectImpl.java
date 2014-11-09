package net.strive.designpatterns.Structuralpattern.proxy;

public class ObjectImpl implements Object {

	@Override
	public void action() {
		System.out.println("==============");
		System.out.println("这是被代理者!");
		System.out.println("==============");
	}

}
