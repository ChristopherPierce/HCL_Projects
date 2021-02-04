import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
	
	private String email = "";
	private String name = "";
	private String position = "";
	
	public Employee() {}
	
	public Employee(String email, String name, String position) {
		this.email = email;
		this.name = name;
		this.position = position;
	}
	
	public String getEmail() {
		return email;
	}
	
	public static Boolean validateEmail(String email) {
		String regexToValidateEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		//Java email validation permitted by RFC 5322
		//Special thanks to:
		//	"https://howtodoinjava.com/java/regex/java-regex-validate-email-address/"
		//for the regex pattern!
		
		Pattern pattern = Pattern.compile(regexToValidateEmail);
	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();

	}
	
	public String toString() {
		String out = "~Employee Details~";
		out += "\nEmail: " + email;
		out += "\nName: " + name;
		out += "\nPosition: " + position;
		return out;
	}

}
