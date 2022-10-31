
import java.io.FileOutputStream;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

	}


	public static void main(String[] args) throws Exception {

		List<School> schoolList = new ArrayList<>();
		Set<String> emialSet = new HashSet<>();
		List<String> emailList = new ArrayList<>();
		List<Student> stdList = new ArrayList<>();
		List<Marks> marksList = new ArrayList<>();
		List<Course> courseList = new ArrayList<>();

		Stack<String> historyStack = new Stack<>();
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
		boolean checkSwitch=true;
		boolean isUserExit = true;
		boolean checkMark=true;
//		String teacherName = "Ruqaia";
//		int password = 1234;
		
		FileOutputStream fout;
		ObjectOutputStream out = null;
		File file = new File("C:\\Users\\user015\\eclipse-workspace\\RHNewCode\\School\\history.txt");
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		while (isUserExit) {
			System.out.println("\t\t+++++++++++++++++++++++++++++");
			System.out.println("\t\t+ WELCOME TO THE SYSTEM     +");
			System.out.println("\t\t+++++++++++++++++++++++++++++\n");
			try {
				Validation validation=new Validation();
			System.out.println("\n PLEASE ENTER USERNAME TO LOGIN : \t");
			String username = scn.next();
			validation.validateUsername(username);
			System.out.println("\n PLEASE ENTER PASSWORD: \t");
			String password = sc.next();
			validation.validatePassword(password);


				System.out.println("your login is seccessful");
				do {

					System.out.println("\t\t+++++++++++++++++++++++++++++");
					System.out.println("\t\t+ WELCOME TO THE SYSTEM     +");
					System.out.println("\t\t+++++++++++++++++++++++++++++\n");
					System.out.println("Please Choose Number From Menu: \n");
					System.out.println("================================");
					System.out.println("|  [1] Enter Student Details    |");
					System.out.println("|  [2] Print Report             |");
					System.out.println("|  [3] Show History             |");
					System.out.println("|  [4] Print duplicated Emails  |");
					System.out.println("|  [5] Student Fees             |");
					System.out.println("|  [6] Sub Menu                 |");
					System.out.println("|  [7] Serialization for Student|");
					System.out.println("|  [8] Exit from program        |");
					System.out.println("================================");
				String option=null;
				do {
					try {
					System.out.println("Please Enter your Choice: \n");
					 option=sc.next();
					 Integer.parseInt( option);
					 checkSwitch=false;
					
					}catch(Exception e) {

						System.out.println("Please Enter Integer only ");
					}
				}
				while( checkSwitch);
					switch (option) {
					case "1":
						System.out.println("*  ENTER STUDENT DETAILS    *");
						while (schoolExit) {

						

							School schools = new School();
							System.out.println("Enter School Name");
							String enterSchool = scn.next();
							schools.setSchoolName(enterSchool);

							historyStack.push(enterSchool);
							try {
								if(!enterSchool.matches("^[a-zA-Z]*$")) {
									
									throw new Exception("Please Enter valid name");
								
								}
							}catch(Exception e) {
					
								System.out.println(e.getMessage());
								break;

							}
				
							courseExit = Boolean.TRUE;
							while (isExit) {
								Student students = new Student();
								
								System.out.println("Enter Student Name");
								String stdName = scn.next();
								students.setStudentName(stdName);
								historyStack.push(stdName);
								try {
									if(!stdName.matches("^[a-zA-Z]*$")) {
										
										throw new Exception("Please Enter valid name");
									
									}
								}catch(Exception e) {
						
									System.out.println(e.getMessage());
									continue;

								}
								
								System.out.println("Enter Student Email");
								String stdEmail = scn.next();
								students.setStdEmail(stdEmail);
								historyStack.push(stdEmail);
								emailList.add(stdEmail);
								try {
									if(!stdEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
										
										throw new Exception("Please Enter valid Email");
									
									}
								}catch(Exception e) {
						
									System.out.println(e.getMessage());
									continue;
								}

								isCurrencyExit = Boolean.TRUE;

								while (isCurrencyExit) {
									try {
									System.out.println("choose Currency:");
									System.out.println("1-KWD");
									System.out.println("2-AED");
									System.out.println("3-USD");
									System.out.println("4-INR");
									String currency1 = scn.next();
									int m=Integer.parseInt(currency1);
									System.out.println("Enter Student Fees Amount");
									feesAmount = scn.nextDouble();

									if (m== 1) {

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
								
								}catch(Exception e) {
										
										System.out.println("Enter number please"+"\n");
										continue;
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
									while(checkMark) {
									System.out.println("Enter Mark for Course :");
									int addCourseMark = sc.nextInt();
									try {
										if(!(addCourseMark>=0 && addCourseMark<=100)) {
											throw new Exception("Enter mark between 0 and 100");
										}
										
									}catch(Exception e) {

										System.out.println( e.getMessage());
										continue;
										
									}
									String addMark = Integer.toString(addCourseMark);
									historyStack.push(addMark);
									courseMarks.setCousrseMark(addCourseMark);
									checkMark=false;
									}
									marksList.add(courseMarks);
									studentCourse.setMarksList(marksList);
									courseList.add(studentCourse);
									students.setCourseList(courseList);

									System.out.println("Do You want To Add course press 1 if  you want exit press 0");
									int exitoutput = sc.nextInt();
									if (exitoutput == 0)

										courseExit = false;
								}

								schoolList.add(schools);
								stdList.add(students);
								schools.setStdList(stdList);
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

						try {
							oos = new ObjectOutputStream(new FileOutputStream(file));
							StringBuilder st = new StringBuilder();
							while (!historyStack.isEmpty()) {
								String s = historyStack.pop();
								st.append(s);
							}
							oos.writeObject(st);
							/*
							 * while (historyStack.empty() == false) {
							 * System.out.println(historyStack.pop()); }
							 */
							oos.close();
						} catch (IOException exception) {
							System.out.println("An unexpected error is occurred");
							exception.printStackTrace();
						}

						break;
					case "2":

						System.out.println("*  YOUR REPORT  *");

						for (School h : schoolList) {
							System.out.println("\tSchool Name: " + h.getSchoolName());
							for (Student s : h.getStdList()) {
								System.out.println("\t Student Name: " + s.getStudentName());
								System.out.println("\t Student Email: " + s.getStdEmail());
								for (Course c : s.getCourseList()) {
									for (Marks m : c.getMarksList()) {
										System.out.println("\nCourse Name: " + c.getCourseName() + " \tCourse Marks"
												+ m.getCousrseMark());
									}
								}
							}
						}
						break;

					case "3":
						try {
							if (file.isFile()) {
								ois = new ObjectInputStream(new FileInputStream(file));
								StringBuilder sb = (StringBuilder) new StringBuilder(ois.readObject().toString());
								ois.close();

								System.out.println(sb.toString() + "\n");

							}
						} catch (IOException exception) {
							System.out.println("An unexpected error is occurred.");
							exception.printStackTrace();
						}

						break;

					case "4":

						for (String emails : emailList) {
							if (emialSet.add(emails) == false) {
								System.out.println("The duplicated emails are : " + emails);

							}

						}
						break;
					case "5":
						for (String stdName : studentAmount.keySet()) {
							Map<String, Double> map2 = studentAmount.get(stdName);
							for (String currenyKey : map2.keySet()) {
								System.out.println("Name of Student: " + stdName + " Currency: " + currenyKey
										+ " Amount: " + map2.get(currenyKey));
							}
						}
						break;
					case "6":
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
 
								System.out
										.println("The factorial of " + factroialNumber + " is :\t" + factorial + "\n");
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
					case "7":
						try {
					Student std=new Student("Ruqaia","ruq7771@gmail.com");
					Student std1=new Student("Amaal","amal@gmail.com");
					Student std2=new Student("Noor","noor@gmail.com");
					fout=new FileOutputStream("C:\\Users\\user015\\eclipse-workspace\\RHNewCode\\School\\school.txt");
				    out=new ObjectOutputStream(fout);
					out.writeObject(std);
					out.writeObject(std1);
					out.writeObject(std2);
					out.flush();
					out.close();
					System.out.println("Serialization");
						}catch(Exception e){
							System.out.println(e);
							
						}
						
						try {
						ObjectInputStream in=new ObjectInputStream(new FileInputStream("C:\\\\Users\\\\user015\\\\eclipse-workspace\\\\RHNewCode\\\\School\\\\school.txt"));
						Student stdu1=(Student)in.readObject();
						Student stdu2=(Student)in.readObject();
						Student stdu3=(Student)in.readObject();
						System.out.println(stdu1.getStudentName()+"\t"+stdu1.getStdEmail());
						System.out.println(stdu2.getStudentName()+"\t"+stdu2.getStdEmail());
						System.out.println(stdu3.getStudentName()+"\t"+stdu3.getStdEmail());
						in.close();
						}catch(Exception e) {
							System.out.println(e);
						}
						
						break;

					case "8":
						System.out.println("+++++++++++++++++++++++++++++");
						System.out.println("+        THANK YOU          +");
						System.out.println("+++++++++++++++++++++++++++++");
						exitMenu = false;
						break;
						default:
							System.out.println("please Enter number between 1-8");
					}
				} while (exitMenu);

			}catch(Exception e) {

			System.out.println("Please login again " + e.getMessage());

		}}
		

		isUserExit = false;
	}

}
