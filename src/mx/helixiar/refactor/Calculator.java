package mx.helixiar.refactor;

public class Calculator {

	public int addNumbers(int num1, int num2) {
		for (int i = 0; i < num2; i++) {
			num1++;
		}
		return num1;
	}
	
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		int sum = calculator.addNumbers(5, 7);
		System.out.println("Sum: " + sum);
	}
}
