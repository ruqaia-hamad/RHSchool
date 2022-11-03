import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculateFeesAmount {

	Scanner scn = new Scanner(System.in);
	int currency = 0;
	String currencyName = "";
	double feesAmount = 0;
	double amountCal = 0;

	public void CalculateCurrency() {

		try {
			System.out.println("choose Currency:");
			System.out.println("1-KWD");
			System.out.println("2-AED");
			System.out.println("3-USD");
			System.out.println("4-INR");
			String currency1 = scn.next();
			int m = Integer.parseInt(currency1);
			System.out.println("Enter Student Fees Amount");
			feesAmount = scn.nextDouble();

			if (m == 1) {

				currencyName = "KWD";

				amountCal = feesAmount * 0.806846;
			} else if (m == 2) {
				currencyName = "AED";
				amountCal = feesAmount * 9.53789;
			} else if (m == 3) {
				currencyName = "USD";
				amountCal = feesAmount * 2.59704;
			} else if (m == 4) {
				currencyName = "INR ";
				amountCal = feesAmount * 214.796;
			}

		} catch (Exception e) {

			System.out.println("Enter number please" + "\n");
		}
	}

}
