
public class Test {

	public Test() {}
	
	public static void main(String[] args) {
		System.out.println("Attempting to create sample product database...");
		CreateSampleDB sampleDB = new CreateSampleDB();
		System.out.println("Succesfully created sample product database!");
		
		System.out.println("Starting our web application...");
		WebApp2 servlet = new WebApp2();
		System.out.println("http://localhost:8080/AddingANewProductInTheDatabase/WebApp2");
		//System.out.println("test");
	}

}
