package Functionality;
import java.io.Serializable;

public class Person implements Serializable {

	/* Fields */
	private String name, initials;

	/* Constructor */
	public Person(String name, String initials) {
		this.name = name;
		this.initials = initials;
	}

	/* Methods */
	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String toString() {
		String s = "";
		s += name + "/" + initials;
		return s;
	}

}
