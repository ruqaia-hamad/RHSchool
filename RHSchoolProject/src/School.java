import java.util.ArrayList;

public class School {

	String schoolName;
	 
	 void setSchoolName(String schoolName) {
		 this.schoolName=schoolName;
	 }
	 
	 String getSchoolName() {
		 return schoolName;
	 }
	
	public School() {
		// TODO Auto-generated constructor stub
	}


ArrayList<Student> stdList=new ArrayList<>();
	
	void setStdList(ArrayList<Student> stdList)
	{
	this.stdList = stdList;	
	}
	public ArrayList<Student> getStdList()
	{
		return stdList;
	}
	

}
