import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable,StudentInterface{

	private String studentName;
	private String stdEmail;
	private int stdAge;
	private List<Course> courseList;
	@Override
	public void stdAge(int age) {
		if(age>18) {
			System.out.println("Student overage ");
		}
		else if(age<6) {
			System.out.println("Student uderage");
		}
		else {
			System.out.println("Student age allegeable complete  registration. ");
		}
		
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	String getStudentName() {
		return studentName;
	}

	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}

	String getStdEmail() {
		return stdEmail;
	}
	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}

	int getstdAge() {
		return stdAge;
	}


	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<Course> getCourseList() {
		return courseList;
	}
	
	
	public Student() {
		this.studentName=studentName;
		this.stdEmail=stdEmail;
	}
	

	public Student(String studentName, String stdEmail) {
		this.studentName=studentName;
		this.stdEmail=stdEmail;
	}




	

}
