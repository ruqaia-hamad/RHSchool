import java.util.ArrayList;
public class Student {

     private String studentName;
     private String stdEmail;
    
    public void setStudentName(String studentName)
    {
    	this.studentName = studentName;
    }
    String getStudentName()
    {
    	return studentName;
    }
    
    public void setStdEmail(String stdEmail)
    {
    	this.stdEmail = stdEmail;
    }
    String getStdEmail()
    {
    	return stdEmail;
    }
    
    
	ArrayList<Course> courseList=new ArrayList<>();
	
	void setCourseList(ArrayList<Course> courseList)
	{
	this.courseList = courseList;	
	}
	public ArrayList<Course> getCourseList()
	{
		return courseList;
	}
	
	Course CourseOfStudent = new Course();
	
	
      
       
        public Student() 
        {
        
        }


}
