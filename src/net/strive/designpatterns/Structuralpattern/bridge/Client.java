package net.strive.designpatterns.Structuralpattern.bridge;

public class Client {

	/**
	 * 
	 * 1.你不希望在抽象和它的实现部分之间有一个固定的绑定关系。
      例如这种情况可能是因为，在程序运行时刻实现部分应可以被选择或者切换。

     * 2.类的抽象以及它的实现都应该可以通过生成子类的方法加以扩充。
      这时Bridge模式使你可以对不同的抽象接口和实现部分进行组合，并分别对它们进行扩充。

    * 3.对一个抽象的实现部分的修改应对客户不产生影响，即客户的代码不必重新编译。

    * 4.正如在意图一节的第一个类图中所示的那样，有许多类要生成。
      这样一种类层次结构说明你必须将一个对象分解成两个部分。

     *	5.你想在多个对象间共享实现（可能使用引用计数），但同时要求客户并不知道这一点。
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Engine engine1500 = new Engine1500CC();
        Engine engine2200 = new Engine2200CC();
       
        Vehicle bus1500 = new Bus( engine1500 );
        Vehicle bus2200 = new Bus( engine2200 );
        bus1500.setEngine();
        bus2200.setEngine();
       
        Vehicle truck1500 = new Truck( engine1500 );
        Vehicle truck2200 = new Truck( engine2200 );
        truck1500.setEngine();
        truck2200.setEngine();
	}

}
