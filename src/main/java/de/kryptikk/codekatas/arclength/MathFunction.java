package de.kryptikk.codekatas.arclength;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MathFunction {

	private Expression e;

	public MathFunction(String func) {
		this.e = new ExpressionBuilder(func)
				.variables("x")
				.build();
	}

	public double calc(double x) {
		this.e.setVariable("x", x);
		return e.evaluate();
	}
}
