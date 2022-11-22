package api;

import java.io.Serializable;
import java.util.Date;

public class Registered implements Serializable{
	private String age;
	private Date date;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
