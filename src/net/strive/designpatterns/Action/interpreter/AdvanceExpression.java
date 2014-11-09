package net.strive.designpatterns.Action.interpreter;

public class AdvanceExpression extends Expression {

	@Override
	void Interpret(Context ctx) {
		System.out.println("这是高级解析器!");
	}

}
