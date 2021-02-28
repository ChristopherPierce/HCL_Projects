import java.io.IOException;
import java.util.Scanner;

public class VirtualKey {
	private Scanner sc = new Scanner(System.in);
	private FileHandlingHelper fhh;
	
	public VirtualKey(String dir) {
		try {
			fhh = new FileHandlingHelper(dir);
			this.DisplayWelcomeScreen();
		} catch (IOException e) {
			System.out.println("Application failed to start!");
			e.printStackTrace();
		}

	}
	
	private void DisplayWelcomeScreen() {
		System.out.println("Application Name: Virtual Key for Your Respositories");
		System.out.println("Developer Details: Chris Pierce\n");
		
		this.HandleUserInteraction();
	}
	
	private void HandleUserInteraction() {
		String options = "\n";
		options += "1: Display Current File Names\n";
		options += "2: Add/Delete/Search a File\n";
		options += "3: Close the Application";
		
		System.out.println(options);
		Integer choice = null;
		while(choice == null) {
			if(sc.hasNextInt()) choice = sc.nextInt();
			ClearScanner();
		}
		System.out.println();
		switch(choice) {
			case 1:
				System.out.println("File names in this folder:");
				fhh.list();
				this.HandleUserInteraction();
				break;
			case 2:
				this.HandleAdditionalOperations();
				break;
			case 3:
				System.out.println("Closing the application!");
				break;
			default:
				System.out.println("Invalid option, please try again!");
				this.HandleUserInteraction();
		}
	}
	
	private void HandleAdditionalOperations() {
		String options = "\n";
		options += "1: Add a File\n";
		options += "2: Delete a File\n";
		options += "3: Search a File\n";
		options += "4: Navigate Back to Main Context";
		
		System.out.println(options);
		Integer choice = null;
		while(choice == null) {
			if(sc.hasNextInt()) choice = sc.nextInt();
			ClearScanner();
		}
		System.out.println();
		switch(choice) {
			case 1:
				System.out.println("Enter the name of the file you would like to add:");
				String fileToAdd = "";
				while(fileToAdd.length()==0) fileToAdd = sc.nextLine();
				ClearScanner();
				try {
					if (fhh.add(fileToAdd))
						System.out.println("Successfully created the file!");
					else
						System.out.println("File already exists!");
				} catch (IOException e) {
					System.out.println("Failed to create the file!");
					e.printStackTrace();
				}
				this.HandleAdditionalOperations();
				break;
			case 2:
				System.out.println("Enter the name of the file you would like to delete:");
				String fileToDelete = "";
				while(fileToDelete.length()==0) fileToDelete = sc.nextLine();
				ClearScanner();
				try {
					if (fhh.delete(fileToDelete))
						System.out.println("Successfully deleted the file!");
					else
						System.out.println("File not found!");
				} catch (IOException e) {
					System.out.println("Failed to delete the file!");
					e.printStackTrace();
				}
				this.HandleAdditionalOperations();
				break;
			case 3:
				System.out.println("Enter the name of the file you would like to search:");
				String fileToSearch = "";
				while(fileToSearch.length()==0) fileToSearch = sc.nextLine();
				ClearScanner();
				try {
					if (fhh.search(fileToSearch))
						System.out.println("Successfully searched the file!");
					else
						System.out.println("File not found!");
				} catch (IOException e) {
					System.out.println("Failed to search the file!");
					e.printStackTrace();
				}
				this.HandleAdditionalOperations();
				break;
			case 4:
				this.HandleUserInteraction();
				break;
			default:
				System.out.println("Invalid option, please try again!");
				this.HandleAdditionalOperations();
		}
	}
	
	private void ClearScanner() {
		sc = new Scanner(System.in);
	}
}
