import java.util.Scanner;

public class CalculateFactorialNumbers {

	public static long factorialNumbers(int num) {

		if (num >= 1)
			return num * factorialNumbers(num - 1);
		else
			return 1;

	}

	public static void calculateFactorial() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your number: \n");
		int factroialNumber = sc.nextInt();
		long factorial = factorialNumbers(factroialNumber);

		System.out.println("The factorial of " + factroialNumber + " is :\t" + factorial + "\n");
	}

}
