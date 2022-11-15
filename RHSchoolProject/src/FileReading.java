package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

public class FileReading {
	File file = new File("C:\\Users\\user015\\eclipse-workspace\\RHNewCode\\School\\history.txt");
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
public void writeObject(Stack<String> historyStack)   {

	try {
		oos = new ObjectOutputStream(new FileOutputStream(file));
		StringBuilder st = new StringBuilder();
		while (!historyStack.isEmpty()) {
			String s = historyStack.pop();
			st.append(s);
		}
		oos.writeObject(st);

		oos.close();
	} catch (IOException exception) {
		System.out.println("An unexpected error is occurred");
		exception.printStackTrace();
	}

}
public void readFile() throws Throwable {
	
	try {
		if (file.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			StringBuilder sb = (StringBuilder) new StringBuilder(ois.readObject().toString());
			ois.close();

			System.out.println(sb.toString() + "\n");

		}
	} catch (IOException exception) {
		System.out.println("An unexpected error is occurred.");
		exception.printStackTrace();
	}
}


}

