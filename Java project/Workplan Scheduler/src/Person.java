
public class Person {

	/* Fields */
	private String name, initials;

	/* Constructor */
	public Person(String name, String initials, int day, int month, int year) {
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
		s += "Name: " + name + "/" + initials;
		return s;
	}

}
