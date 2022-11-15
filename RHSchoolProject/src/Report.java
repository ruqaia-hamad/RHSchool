package src;

import java.util.List;

public class Report {
	
	public void printReport(List<School> schoolList ,List<Student> stdList ,List<Course>   courseList,	List<Marks> marksList ) {
		System.out.println("*  YOUR REPORT  *");

		for (School h : schoolList) {
			System.out.println("\tSchool Name: " + h.getSchoolName());
			for (Student s : h.getStdList()) {
				System.out.println("\t Student Age: " + s.getstdAge());
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
	}

}
