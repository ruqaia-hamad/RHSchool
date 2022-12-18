package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class School {

	private String schoolName;
	private String schoolId;
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	private List<Student> stdList;

	void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	String getSchoolName() {
		return schoolName;
	}

	public void setStdList(List<Student> stdList) {
		this.stdList = stdList;
	}

	public List<Student> getStdList() {
		return stdList;
	}

	protected void finalize() throws Throwable {
		try {

			System.out.println("School Finalize");
		} catch (Throwable e) {

			throw e;
		} finally {

			super.finalize();
		}
	}

	public void schoolEntry(Stack<String> historyStack) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter School ID");
		String enterSchoolId = scn.next();
		setSchoolId(enterSchoolId);
		System.out.println("Enter School Name");
		String enterSchool = scn.next();
		setSchoolName(enterSchool);

		historyStack.push(enterSchool);
		try {
			if (!enterSchool.matches("^[a-zA-Z]*$")) {

				throw new Exception("Please Enter valid name");

			}
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}

}
