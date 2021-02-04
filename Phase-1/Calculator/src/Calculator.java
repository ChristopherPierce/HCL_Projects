import java.util.Scanner;

public class Calculator {
	private double result = 0;
	
	Calculator() {
		System.out.println("Welcome to the Simple Java Calculator!");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nPlease enter the 1st number: ");
		result = sc.nextDouble();
		
		Boolean userFinished = false;
		while(!userFinished) {
			System.out.println("\nWhich opperation would you like to perform?\n1:addition, 2:subtraction, 3:multiplication, or 4:division.");
			int opperation = sc.nextInt();
			System.out.println("\nPlease enter another number: ");
			double num = sc.nextDouble();
			
			switch(opperation) {
				case 1: result += num;
						break;
				case 2: result -= num;
						break;
				case 3: result *= num;
						break;
				case 4: result /= num;
						break;
			}
			
			
			System.out.println("\nAre you finished calculating? Enter '1' if yes or '2' if no.");
			int finished = sc.nextInt();
			if(finished == 1) {
				userFinished = true;
			}
				
		}
		sc.close();
	}
	
	void printResult() {
		System.out.println("\nThe result is: " + result);
	}
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.printResult();
	}
}