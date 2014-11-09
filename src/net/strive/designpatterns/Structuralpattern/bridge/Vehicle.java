package net.strive.designpatterns.Structuralpattern.bridge;

/**
*
* 汽车类（Vehicle），假设有2个子类，卡车类（Truck）与公交车类（Bus），
* 它们有[设置引擎]这个动作行为，通过不同引擎规格的设置，
* 可以将它们设置为比如为1500cc（Car1500），和2000cc（Car2000）的车。
* 这样，不管是1500cc的卡车还是2000cc的卡车，又或是1500cc的公交车还是2000cc的公交车，它们都可以是汽车类的子类，而且：
* - 存在相对并列的子类属性。汽车的种类，与汽车引擎规格是汽车的2个并列的属性，没有概念上的重复。
* - 存在概念上的交叉。不管是卡车还是公交车，都有1500cc与2000cc引擎规格的车。
* - 可变性。除了卡车，公交车之外，可能还有救火车；除了有1500cc与2000cc引擎规格的车之外，还可能有2500cc的车等等。
*
* @author strive
*/
public abstract class Vehicle {
	private Engine engine;
	Vehicle(Engine engine)
	{
		this.setEngine(engine);
	}
	
	public abstract void setEngine();
	
	public void setEngine(Engine engine)
	{
		this.engine=engine;
	}
	public Engine getEngine()
	{
		return engine;
	}
}
