package functionality;
import java.io.Serializable;

/**
 * Person is a Parent class to Employee and TeamLeader.
 * 
 * @author Kenneth Jensen
 * @author Florin Bordei
 * @author Teakosheen Joulak
 * @author Jimmi Børgesen
 * @version 1.0
 * @see Employee
 * @see TeamLeader
 */
public class Person implements Serializable {

	/* Fields */
	private String name, initials;

	/**
	 * This is the class constructor.<!-- -->As this class is meant as a parent class, it should not be instantiated.
	 * 
	 * @param name the name of the person.
	 * @param initials the initials of the person.<!-- -->This is not necessarily their exact initials, but more a like a 'code' to identify the person.
	 */
	public Person(String name, String initials) {
		this.name = name;
		this.initials = initials;
	}

	/**
	 * Method to get the name of the person.
	 * 
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set the name of the person.
	 * 
	 * @param name the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to get the persons initials
	 * 
	 * @return the initials
	 */
	public String getInitials() {
		return initials;
	}

	/**
	 * Method to set the initials
	 * 
	 * @param initials the initials to set
	 */
	public void setInitials(String initials) {
		this.initials = initials;
	}

	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = "";
		s += name + "/" + initials;
		return s;
	}

}
