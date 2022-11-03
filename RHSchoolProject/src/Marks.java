
public class Marks implements MarksInterface{
	private int cousrseMark;

	@Override
	public void stdMark(int mark) {
		if(mark>=90) {
			System.out.println("Student is : Excellent ");
		}
		else if(mark>=70 &&  mark<90) {
			System.out.println("Student is : very Good");
		}
		else if(mark>=60 &&  mark<70) {
			System.out.println("Student is : good");
		}
		else {
			System.out.println("Student is :Failed");
		}
		
	}
	public void setCousrseMark(int cousrseMark) {
	
			this.cousrseMark = cousrseMark;

	}

	public int getCousrseMark() {
		return cousrseMark;
	}
	
	protected void finalize() throws Throwable
    {
        try {
 
            System.out.println("Marks Finalize");
        }
        catch (Throwable e) {
 
            throw e;
        }
        finally {
 
          
 
            super.finalize();
        }
    }
}
