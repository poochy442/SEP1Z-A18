package functionality;

import java.io.Serializable;

/**
 * Assignment is the Class that handles a single assignment.<!-- -->It keeps track of whether the given assignment is a vacation, and if it is not, it keeps track of the test needing to be performed.
 * 
 * @author Kenneth Jensen
 * @author Florin Bordei
 * @author Teakosheen Joulak
 * @author Jimmi Børgesen
 * @version 1.0
 */
public class Assignment implements Serializable {

	private Date date;
	private String test;
	private Boolean vacation;

	/**
	 * This is the class constructor.
	 * 
	 * @param date a Date Object giving the day, month and year of the assignment.
	 */
	public Assignment(Date date) {
		this.date = date.copy();
		vacation = false;
	}

	/**
	 * This is the class constructor, specifying the String field 'test' to set for
	 * this.
	 * 
	 * @param date a Date Object giving the day, month and year of the assignment.
	 * 
	 * @param test the test of the assignment.
	 */
	public Assignment(Date date, String test) {
		this.date = date.copy();
		this.test = test;
		vacation = false;
	}

	/**
	 * This is a set method for the field test.
	 * 
	 * @param test the test of the assignment.
	 */
	public void setTest(String test) {
		this.test = test;
	}

	/**
	 * This is a get method for the field test.
	 * 
	 * @return the test of the assignment, if test is null returns the empty string instead.
	 */
	public String getTest() {
		if(test == null) {
			return "";
		}
		return test;
	}

	/**
	 * This is a set method for the field date.
	 * 
	 * @param date a Date Object giving the day, month and year of the assignment.
	 */
	public void setDate(Date date) {
		this.date = date.copy();
	}

	/**
	 * This is a get method for the field date.
	 * 
	 * @return the date of the assignment.
	 */
	public Date getDate() {
		return date.copy();
	}

	/**
	 * This is a set method for the field vacation.<!-- --> It takes no argument, as
	 * setting this field will permanently set the field to true.
	 */
	public void setVacation() {
		vacation = true;
	}

	/**
	 * This is a get method for the field vacation.
	 * 
	 * @return a Boolean stating whether the assignment is a vacation.
	 */
	public Boolean getVacation() {
		return vacation;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = "";
		s += "Date: " + date + "\n" + "Test: " + test;
		return s;
	}
}