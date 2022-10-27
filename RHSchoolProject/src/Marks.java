
public class Marks {
	private int cousrseMark;

	public void setCousrseMark(int cousrseMark) {
		if (cousrseMark > 0 && cousrseMark < 100) {
			this.cousrseMark = cousrseMark;
		} else {
			System.out.println("Please Enter Between 0 and 100 only");
		}
	}

	public int getCousrseMark() {
		return cousrseMark;
	}

}
