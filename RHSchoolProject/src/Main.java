
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {
	public static long factorialNumbers(int num) {
//		System.out.println("Factorial of: "+ num);
		if (num >= 1)
			return num * factorialNumbers(num - 1);
		else
			return 1;
	}

	public Main() {
// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		ArrayList<School> schoolList = new ArrayList<>();
		Set<String> emialSet = new HashSet<>();
		ArrayList<String> emailList = new ArrayList<>();
//   ArrayList<Student> stdList=new ArrayList<>();

		Stack<String> historyStack = new Stack<String>();
		Scanner sc = new Scanner(System.in);
		Scanner scn = new Scanner(System.in);
		int currency = 0;
		String currencyName = "";
		HashMap<String, Double> studentFees = new HashMap<String, Double>();
		HashMap<String, HashMap<String, Double>> studentAmount = new HashMap<String, HashMap<String, Double>>();
		double feesAmount = 0;
		double amountCal = 0;
//		double amount=0;
		boolean isExit = true;
		boolean isCurrencyExit = true;
		boolean courseExit = true;
		boolean schoolExit = true;
		boolean exitMenu = true;
		boolean isUserExit = true;
		String teacherName = "Ruqaia";
		int password = 1234;

		while (isUserExit) {
			System.out.println("\t\t+++++++++++++++++++++++++++++");
			System.out.println("\t\t+ WELCOME TO THE SYSTEM     +");
			System.out.println("\t\t+                           +");
			System.out.println("\t\t+++++++++++++++++++++++++++++\n");
			System.out.println("\n PLEASE ENTER USERNAME TO LOGIN : \t");
			String username = scn.next();

//			System.out.println("\n PLEASE ENTER PASSWORD: \t");
			int loginpass = sc.nextInt();
			boolean checkUserName = username.equals(teacherName);
			if (checkUserName == true && loginpass == password) {

				System.out.println("your login is seccessful");
				do {

					System.out.println("\t\t+++++++++++++++++++++++++++++");
					System.out.println("\t\t+ WELCOME TO THE SYSTEM     +");
					System.out.println("\t\t+++++++++++++++++++++++++++++\n");
					System.out.println("Please Choose Number From Menu: \n");
					System.out.println("================================");
					System.out.println("|  [1] Enter Student Details   |");
					System.out.println("|  [2] Print Report            |");
					System.out.println("|  [3] Show History            |");
					System.out.println("|  [4] Print duplicated Emails |");
					System.out.println("|  [5] Student Fees            |");
					System.out.println("|  [6] Sub Menu                |");
					System.out.println("|  [7] Exit from program       |");
					System.out.println("================================");
					System.out.println("Please Enter your Choice: \n");
					int option = sc.nextInt();

					switch (option) {
					case 1:
						while (schoolExit) {

							System.out.println("*  ENTER STUDENT DETAILS    *");

							School schools = new School();
							System.out.println("Enter School Name");
							String enterSchool = scn.next();
							schools.setSchoolName(enterSchool);

							historyStack.push(enterSchool);

							courseExit = Boolean.TRUE;
							while (isExit) {
								Student students = new Student();
								System.out.println("Enter Student Name");
								String stdName = scn.next();
								students.setStudentName(stdName);
								historyStack.push(stdName);
								System.out.println("Enter Student Email");
								String stdEmail = scn.next();
								students.setStdEmail(stdEmail);
								historyStack.push(stdEmail);
								emailList.add(stdEmail);

								isCurrencyExit = Boolean.TRUE;

								while (isCurrencyExit) {
									System.out.println(
											"choose Currency:\n" + "1-KWD \n" + " 2-AED \n" + " 3-USD \n" + " INR \n");
									currency = scn.nextInt();
									System.out.println("Enter Student Fees Amount");
									feesAmount = scn.nextDouble();

									if (currency == 1) {

										currencyName = "KWD";

										amountCal = feesAmount * 0.806846;
									} else if (currency == 2) {
										currencyName = "AED";
										amountCal = feesAmount * 9.53789;
									} else if (currency == 3) {
										currencyName = "USD";
										amountCal = feesAmount * 2.59704;
									} else if (currency == 4) {
										currencyName = "INR ";
										amountCal = feesAmount * 214.796;
									}
									studentFees.put(currencyName, amountCal);
									studentAmount.put(students.getStudentName(), studentFees);
									System.out.println("Do You want To Add Currency press 1 if  you want exit press 0");
									int exitcurrency = sc.nextInt();
									if (exitcurrency == 0)

										isCurrencyExit = false;

								}
								courseExit = Boolean.TRUE;

								while (courseExit) {
									Course studentCourse = new Course();
									Marks courseMarks = new Marks();
									System.out.println("Enter Course Name \n");
									String addCourseName = scn.next();
									historyStack.push(addCourseName);
									studentCourse.setCourseName(addCourseName);
									System.out.println("Enter Mark for Course :");
									int addCourseMark = sc.nextInt();
									String addMark = Integer.toString(addCourseMark);
									historyStack.push(addMark);
									courseMarks.setCousrseMark(addCourseMark);
									studentCourse.marksList.add(courseMarks);
									students.courseList.add(studentCourse);

									System.out.println("Do You want To Add course press 1 if  you want exit press 0");
									int exitoutput = sc.nextInt();
									if (exitoutput == 0)

										courseExit = false;
								}
								schoolList.add(schools);
								schools.stdList.add(students);

								System.out.println("If You want To Add Student press 1 ");
								int exitStudentOutput = sc.nextInt();
								if (exitStudentOutput == 0) {
									isExit = false;
								}
							}

							System.out.println("If you want To Add School press 1 ");
							int exitoutterloop = sc.nextInt();
							if (exitoutterloop == 1) {
								schoolExit = true;
								isExit = true;
								courseExit = true;

							} else {
								schoolExit = false;
								isExit = false;
								courseExit = false;
							}

						}

						break;

					case 2:

						System.out.println("*  YOUR REPORT  *");

						for (School h : schoolList) {
							System.out.println("\tSchool Name: " + h.getSchoolName());
							for (Student s : h.stdList) {
								System.out.println("\t Student Name: " + s.getStudentName());
								System.out.println("\t Student Email: " + s.getStdEmail());
								for (Course c : s.courseList) {
									for (Marks m : c.getMarksList()) {
										System.out.println("\nCourse Name: " + c.getCourseName() + " \tCourse Marks"
												+ m.getCousrseMark());
									}
								}
							}
						}
						break;

					case 3:

						while (historyStack.empty() == false) {
							System.out.println(historyStack.pop());
						}

						break;

					case 4:

						for (String emails : emailList) {
							if (emialSet.add(emails) == false) {
								System.out.println("The duplicated emails are : " + emails);

							}

						}
						break;
					case 5:
						for (String stdName : studentAmount.keySet()) {
							Map<String, Double> map2 = studentAmount.get(stdName);
							for (String currenyKey : map2.keySet()) {
								System.out.println("Name of Student: " + stdName + " Currency: " + currenyKey
										+ " Amount: " + map2.get(currenyKey));
							}
						}
						break;
					case 6:
						boolean isExitMenu = true;
						do {
							System.out.println("Please Choose Number From Menu: \n");
							System.out.println("================================");
							System.out.println("|  [1] Calculate Factorial     |");
							System.out.println("|  [2] Print Fibonacci         |");
							System.out.println("|  [3] Go Back To Menu         |");
							System.out.println("================================");
							System.out.println("Please Enter your Choice: \n");
							int op = sc.nextInt();

							switch (op) {
							case 1:

								System.out.println("Please Enter your number: \n");
								int factroialNumber = sc.nextInt();
								long factorial = factorialNumbers(factroialNumber);

								System.out.println("The factorial of " + factroialNumber + " is :\t" + factorial + "\n");
								break;
							case 2:
								
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
							case 3:
								isExitMenu = false;
							}
						} while (isExitMenu);

						break;

					case 7:
						System.out.println("+++++++++++++++++++++++++++++");
						System.out.println("+        THANK YOU          +");
						System.out.println("+++++++++++++++++++++++++++++");
						exitMenu = false;
						break;
					}
				} while (exitMenu);

			}

			System.out.println("Please logi again");

		}

		isUserExit = false;
	}

}
