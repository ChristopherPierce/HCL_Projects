import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the 'Validation of an Email ID Project'!\n");
		
		System.out.println("Creating a list of our employees...");
		Employees employees = new Employees();
		
		System.out.println("Proceeding to add three employees (Alfa, Bravo, Charlie) to our list of employees...");
		employees.addEmployee("alfa@example.com", "Alfa", "dev.");
		employees.addEmployee("bravo@example.com", "Bravo", "dev.");
		employees.addEmployee("charlie@example.com", "Charlie", "dev.");
		System.out.println("Successfully added our employees to the list!\n");
		System.out.println("Up next, we shall find an employee by their email ID and grab their info...");
		
		Boolean userFinished = false;
		while(!userFinished) {
			System.out.println("Please enter a valid employee's email to search for: (example: bravo@example.com)");
			String email = "";
			
			Boolean userEnteredValidEmail = false;
			while(!userEnteredValidEmail) {
				email = sc.nextLine().trim();
				System.out.println();
				if(Employee.validateEmail(email)) {
					userEnteredValidEmail = true;
				} else {
					System.out.println("You entered an invalid email address, please try again!");
				}
			}
			
			Employee emp = employees.findEmployeeByEmail(email);
			if(emp == null) {
				System.out.println("404 not found! This employee does not exist in the database :(");
			} else {
				System.out.println("We successfully found the target employee! Printing their info...\n");
				System.out.println(emp.toString());
			}
			
			System.out.println("\nWould you like to perform another employee search? Enter '1' if yes or '2' if no.");
			int finished = sc.nextInt();
			if(finished != 1) {
				userFinished = true;
			}
			sc.nextLine();
			System.out.println();
		}
		
		System.out.println("Thank you for testing this Java program!");
		sc.close();
	}

}
