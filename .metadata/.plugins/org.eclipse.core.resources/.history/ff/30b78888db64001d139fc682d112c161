import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void serilizationfunction() {
		try {
			FileOutputStream fout;
			ObjectOutputStream out = null;
			Student std = new Student("Ruqaia", "ruq7771@gmail.com");
			Student std1 = new Student("Amaal", "amal@gmail.com");
			Student std2 = new Student("Noor", "noor@gmail.com");
			fout = new FileOutputStream("C:\\Users\\user015\\eclipse-workspace\\RHNewCode\\School\\school.txt");
			out = new ObjectOutputStream(fout);
			out.writeObject(std);
			out.writeObject(std1);
			out.writeObject(std2);
			out.flush();
			out.close();
			System.out.println("Serialization");
		} catch (Exception e) {
			System.out.println(e);

		}

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"C:\\\\Users\\\\user015\\\\eclipse-workspace\\\\RHNewCode\\\\School\\\\school.txt"));
			Student stdu1 = (Student) in.readObject();
			Student stdu2 = (Student) in.readObject();
			Student stdu3 = (Student) in.readObject();
			System.out.println(stdu1.getStudentName() + "\t" + stdu1.getStdEmail());
			System.out.println(stdu2.getStudentName() + "\t" + stdu2.getStdEmail());
			System.out.println(stdu3.getStudentName() + "\t" + stdu3.getStdEmail());
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
