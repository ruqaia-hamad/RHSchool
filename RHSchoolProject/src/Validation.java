
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
}
