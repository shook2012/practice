package net.strive.designpatterns.Creationalpattern.builder;
/**
 * @author strive
 * 适用性
 *  1.当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时。
 *
 *  2.当构造过程必须允许被构造的对象有不同的表示时。
 *
 */
public class Test {

	public static void main(String[] args) {
		PersonDirector pd=new PersonDirector();
		Person person=pd.constructPerson(new ManBuilder());
		System.out.println(person.getHead());
		System.out.println(person.getBody());
		System.out.println(person.getFoot());
	}

}
