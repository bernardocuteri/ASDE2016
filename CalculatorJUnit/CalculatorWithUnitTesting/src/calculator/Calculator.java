package calculator;

public class Calculator {
	
	public enum Operator{ADDITION, SUBTRACT, MULTIPLY, DIVIDE}
	
	public Calculator() {
		
	}
	
	public double performOperation(double a, double b, Operator operator) {
		switch(operator) {
			case ADDITION:
				return a+b;
			case SUBTRACT:
				return a-b;
			case MULTIPLY:
				return a*b;
			case DIVIDE:
				return a/b;
		}
		return 0;
	}

}
