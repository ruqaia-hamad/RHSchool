package src;

import java.util.Scanner;
import java.util.*;

public class FibonacciNumbers {
	public static void fibonacciNumbers() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter series length: \n");
		int count = sc.nextInt();
		int num1 = 0;
		int num2 = 1;

		int num3;
		System.out.print(num1 + " " + num2);

		for (int i = 2; i < count; i++) {
			num3 = num1 + num2;

			if (num3 <= 100) {
				System.out.print(" " + num3);
				num1 = num2;
				num2 = num3;

			}
		}
		System.out.print("\n" + "\n");
	}

}
