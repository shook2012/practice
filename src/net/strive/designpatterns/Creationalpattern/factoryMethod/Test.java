package net.strive.designpatterns.Creationalpattern.factoryMethod;

/**
 * @author strive
 * @description:
 * 适用性
 * 1.当一个类不知道它所必须创建的对象的类的时候。
 *
 * 2.当一个类希望由它的子类来指定它所创建的对象的时候。
 *
 * 3.当类将创建对象的职责委托给多个帮助子类中的某一个，并且你希望将哪一个帮助子类是代理者这一信息局部化的时候。
 *
 */
public class Test {

	public static void main(String[] args) {
		IWorkFactory studentWorkFactory=new StudentWorkFactory();
		studentWorkFactory.getWork().doWork();
		IWorkFactory teacherWorkFactory=new TeacherWorkFactory();
		teacherWorkFactory.getWork().doWork();
	}

}
