import java.util.Scanner;

public class Validation {

	public void validateUsername(String username) throws IllegalArgumentException {
		String teacherName = "Ruqaia";

		if (!username.matches(teacherName)) {
			throw new IllegalArgumentException("Invalid username.");
		}
	}

	public void validatePassword(String password) throws IllegalArgumentException {
		String userPassword = "1234";

		if (!password.matches(userPassword)) {
			throw new IllegalArgumentException("Invalid password");
		}

	
}
public void checkUsernameAndPassword() {
	Scanner scn=new Scanner(System.in);
	System.out.println("\n PLEASE ENTER USERNAME TO LOGIN : \t");
	String username = scn.next();
	validateUsername(username);
	System.out.println("\n PLEASE ENTER PASSWORD: \t");
	String password = scn.next();
	validatePassword(password);
}
}