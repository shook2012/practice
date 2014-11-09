package net.strive.designpatterns.Action.strategy;
/**
 * 策略模式
 * 适用性
 * @author strive
 *     1.许多相关的类仅仅是行为有异。“策略”提供了一种用多个行为中的一个行为来配置一个类的方法。
 * 
 *     2.需要使用一个算法的不同变体。
 * 
 *     3.算法使用客户不应该知道的数据。可使用策略模式以避免暴露复杂的、与算法相关的数据结构。
 * 
 *     4.一个类定义了多种行为,并且这些行为在这个类的操作中以多个条件语句的形式出现。
 *       将相关的条件分支移入它们各自的Strategy类中以代替这些条件语句。
 * 
 *
 */
public class Test {

	public static void main(String[] args) {
        Context ctx = new Context(new StrategyImplA());
        ctx.doMethod();
        
        ctx = new Context(new StrategyImplB());
        ctx.doMethod();
        
        ctx = new Context(new StrategyImplC());
        ctx.doMethod();


	}

}
