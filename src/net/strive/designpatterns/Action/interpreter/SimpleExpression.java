package net.strive.designpatterns.Action.interpreter;

public class SimpleExpression extends Expression {

	@Override
	void Interpret(Context ctx) {
		System.out.println("这是普通解析器!");
	}

}
