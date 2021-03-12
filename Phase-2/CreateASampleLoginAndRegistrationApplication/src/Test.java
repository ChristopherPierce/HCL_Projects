
public class Test {

	public Test() {}
	
	public static void main(String[] args) {
		System.out.println("Attempting to create sample user registration database...");
		CreateSampleDB sampleDB = new CreateSampleDB();
		System.out.println("Succesfully created sample user registration database!");
		
		System.out.println("Starting our web application...");
		WebApp3 servlet = new WebApp3();
		System.out.println("http://localhost:8080/CreateASampleLoginAndRegistrationApplication/WebApp3");
		//System.out.println("test");
	}

}
