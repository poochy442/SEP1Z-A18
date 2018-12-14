
public class Person {

	/* Fields */
	private String name, initials, email;

	/* Constructor */
	public Person(String name, String initials, String email) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		String s = "";
		s += name + "/" + initials;
		return s;
	}

}
