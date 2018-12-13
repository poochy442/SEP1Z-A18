import java.util.ArrayList;
import java.util.List;

public class Person {

	/* Fields */
	private String name, initials, email, tlfNumber;
	private Date birthday;

	/* Constructor */
	public Person(String name, String initials, int day, int month, int year) {
		this.name = name;
		this.initials = initials;
		this.birthday = new Date(day, month, year);
		this.email = "";
		this.tlfNumber = "";
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

	public String getTlfNumber() {
		return tlfNumber;
	}

	public void setTlfNumber(String tlfNumber) {
		this.tlfNumber = tlfNumber;
	}

	public Date getBirthday() {
		return birthday.copy();
	}

	public String toString() {
		String s = "";
		s += "Name: " + name + "/" + initials;
		if (tlfNumber != "") {
			s += ", mobil-nr: " + tlfNumber;
		}
		if (email != "") {
			s += ", e-mail: " + email;
		}
		return s;
	}

	// main() method for testing

	public static void main(String[] args) {
		Person Teako = new Person("Teakosheen", "TK", 1, 7, 1983);
		Person Kenneth = new Person("Kenneth", "KJ", 12, 11, 1997);
		Person Jimmi = new Person("Jimmi", "JC", 28, 01, 1982);

		List<Person> personList = new ArrayList<>();
		personList.add(Teako);
		personList.add(Kenneth);
		personList.add(Jimmi);

		Kenneth.setTlfNumber("22667902");
		Jimmi.setEmail("Jimmi.C.B@hotmail.com");
		Teako.setEmail("Teako@hotmail.com");
		Teako.setTlfNumber("12345678");

		for (Person p : personList) {
			System.out.println(p);
		}
	}

}
