package net.strive.designpatterns.Structuralpattern.decorator;

/**
 * 装饰模型
 * @author Administrator
 * 
 *  1.在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
 *  2.处理那些可以撤消的职责。
 *  3.当不能采用生成子类的方法进行扩充时。
 *
 */
public class Test {

	public static void main(String[] args) {
		Man man=new Man();
		ManDecoratorA ma=new ManDecoratorA();
		ManDecoratorB mb=new ManDecoratorB();
		
		ma.setPerson(man);
		
		mb.setPerson(ma);
		mb.eat();
	}

}
