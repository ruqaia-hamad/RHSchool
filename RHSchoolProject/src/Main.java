package src;

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

	public static void main(String[] args) throws Throwable {

		List<School> schoolList = new ArrayList<>();
		Set<String> emialSet = new HashSet<>();
		List<String> emailList = new ArrayList<>();
		List<Student> stdList = new ArrayList<>();
		List<Marks> marksList = new ArrayList<>();
		List<Course> courseList = new ArrayList<>();

		Stack<String> historyStack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		Scanner scn = new Scanner(System.in);

		HashMap<String, Double> studentFees = new HashMap<>();
		Map<String, Map<String, Double>> studentAmount = new HashMap<>();

		boolean isExit = true;
		boolean isCurrencyExit = true;
		boolean courseExit = true;
		boolean schoolExit = true;
		boolean exitMenu = true;
		boolean checkSwitch = true;
		boolean isUserExit = true;
		boolean checkMark = true;

		while (isUserExit) {
			Menu.welcomMenu();
			try {
				Validation validation = new Validation();
				validation.checkUsernameAndPassword();
				System.out.println("your login is seccessful");
				do {
					Menu.menu();
					String option = null;
					do {
						try {
							System.out.println("Please Enter your Choice: \n");
							option = sc.next();
							Integer.parseInt(option);
							checkSwitch = false;

						} catch (Exception e) {

							System.out.println("Please Enter Integer only ");
						}
					} while (checkSwitch);
					switch (option) {
					case "1":
						System.out.println("*  ENTER STUDENT DETAILS    *");
						while (schoolExit) {
							School schools = new School();
							schools.schoolEntry(historyStack);
							schools.finalize();

							courseExit = Boolean.TRUE;

							while (isExit) {

								Student students = new Student();
								students.checkage(historyStack);
								students.finalize();

								if (students.studAge > 5 && students.studAge <= 18) {
									students.studentEntry(historyStack, emailList);

									isCurrencyExit = Boolean.TRUE;

									while (isCurrencyExit) {

										CalculateFeesAmount fees = new CalculateFeesAmount();

										fees.CalculateCurrency();
										studentFees.put(fees.currencyName, fees.amountCal);
										studentAmount.put(students.getStudentName(), studentFees);
										System.out.println(
												"Do You want To Add Currency press 1 if  you want exit press 0");
										int exitcurrency = sc.nextInt();
										if (exitcurrency == 0)

											isCurrencyExit = false;

									}
									courseExit = Boolean.TRUE;

									while (courseExit) {
										Course studentCourse = new Course();
										Marks courseMarks = new Marks();
										studentCourse.courseEntry(historyStack);
										studentCourse.finalize();
										while (checkMark) {
											courseMarks.markEntry(historyStack);
											courseMarks.finalize();
											checkMark = false;
										}
										marksList.add(courseMarks);
										studentCourse.setMarksList(marksList);
										courseList.add(studentCourse);
										students.setCourseList(courseList);

										System.out
												.println("Do You want To Add course press 1 if  you want exit press 0");
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
								} else {
									System.out.println("Student cant be registerd");
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

							FileReading filer = new FileReading();
							filer.writeObject(historyStack);
						}

						break;
					case "2":

						Report rep = new Report();
						rep.printReport(schoolList, stdList, courseList, marksList);
						break;

					case "3":
						FileReading filer = new FileReading();
						filer.readFile();
						break;

					case "4":

						DuplicatedEmails depEmail = new DuplicatedEmails();
						depEmail.checkDuplicated(emailList, emialSet);
						break;
					case "5":

						CalculateFeesAmount calc = new CalculateFeesAmount();

						calc.printStudentFeesAmountReport(studentAmount);

						break;
					case "6":
						boolean isExitMenu = true;
						do {
							Menu.subMenu();
							int op = sc.nextInt();

							switch (op) {
							case 1:
								CalculateFactorialNumbers.calculateFactorial();
								break;
							case 2:
								FibonacciNumbers.fibonacciNumbers();
								break;
							case 3:
								isExitMenu = false;
							}
						} while (isExitMenu);

						break;
					case "7":
						Serialization.serilizationfunction();

						break;

					case "8":
						Menu.thankMenu();
						exitMenu = false;
						break;
					default:
						System.out.println("please Enter number between 1-8");
					}
				} while (exitMenu);

			} catch (Exception e) {

				System.out.println("Please login again " + e.getMessage());

			}
		}

		isUserExit = false;
	}

}
