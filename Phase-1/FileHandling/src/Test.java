import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the example Java File Handling project!");
		System.out.println("\nYou may use this program to read, write, and append to a file.");
		System.out.println("\nPlease enter the pathname for your file: (example: './test.txt')");
		String pathName = sc.nextLine().trim();
		System.out.println("\nCreating an instance of our 'FileHandlingHelper' class...");
		FileHandlingHelper fhh = new FileHandlingHelper(pathName);
		System.out.println("\nSuccessfully created a new instance and gained access to our file!");
		if(fhh.fileExists) {
			System.out.println("\nThis file already exists! Would you like to wipe it first?\nEnter '1' if yes or '2' if no.");
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice == 1) fhh.wipe();
		}
		Boolean userFinished = false;
		while(!userFinished) {
			System.out.println("\nWhat would you like to do? 1:read, 2:write, 3:append, 4:exit");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
				case 1:
					String out = "\n~OUTPUT~\n";
					out += fhh.read();
					System.out.println(out);
					break;
				case 2:
					System.out.println("\nPlease enter some data to write: ");
					String writeData = "";
					while(sc.hasNextLine()) {
						String line = sc.nextLine();
						if(line.isEmpty()) break;
						writeData += line + "\n";
					}
					fhh.write(writeData);
					break;
				case 3:
					System.out.println("\nPlease enter some data to append: ");
					String appendData = "";
					while(sc.hasNextLine()) {
						String line = sc.nextLine();
						if(line.isEmpty()) break;
						appendData += line + "\n";
					}
					fhh.append(appendData);
					break;
				case 4:
					userFinished = true;
					break;
			}
		}
		System.out.println("\nWould you like to delete the file before you go?\nEnter '1' if yes or '2' if no.");
		int choice = sc.nextInt();
		sc.nextLine();
		if(choice == 1) {
			fhh.delete();
			System.out.println("\nThe file has been deleted!");
		}
		System.out.println("\nThank you for testing this program, goodbye!");
		sc.close();
	}

}
