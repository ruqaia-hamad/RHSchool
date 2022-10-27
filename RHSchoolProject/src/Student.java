import java.util.ArrayList;
import java.util.List;

public class Student {

	private String studentName;
	private String stdEmail;

	private List<Course> courseList;

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

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	Course CourseOfStudent = new Course();

	

}
