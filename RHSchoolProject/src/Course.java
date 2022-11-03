
import java.util.List;

public class Course {
	private String courseName;
	private List<Marks> marksList;

	void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	String getCourseName() {
		return courseName;
	}

	public void setMarksList(List<Marks> marksList) {
		this.marksList = marksList;
	}

	public List<Marks> getMarksList() {
		return marksList;

	}
	protected void finalize() throws Throwable
    {
        try {
 
            System.out.println("Course Finalize");
        }
        catch (Throwable e) {
 
            throw e;
        }
        finally {
 
          
 
            super.finalize();
        }
    }

}
