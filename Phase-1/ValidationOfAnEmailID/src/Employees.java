import java.util.ArrayList;

public class Employees {
	
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
	public Employees() {}
	
	public void addEmployee(String email, String name, String position) {
		Employee emp = new Employee(email, name, position);
		employeeList.add(emp);
	}
	
	public Employee findEmployeeByEmail(String email) {
		for(Employee emp : employeeList) {
			if(emp.getEmail().equals(email)) return emp;
		}
		
		return null;
	}
}
