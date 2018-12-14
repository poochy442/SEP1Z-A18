
public class Assignment {

	/* Fields */
	private Date date;
	private String test;
	private Boolean vacation;

	/* constructor */
	public Assignment(Date date) {
		this.date = date.copy();
		vacation = false;
	}

	public Assignment(Date date, String test) {
		this.date = date.copy();
		this.test = test;
		vacation = false;
	}

	/* Methods */
	// Setters and Getters
	public void setTest(String test) {
		this.test = test;
	}

	public String getTest() {
		return test;
	}

	public void setDate(Date date) {
		this.date = date.copy();
	}

	public Date getDate() {
		return date.copy();
	}

	public void setVacation() {
		vacation = true;
	}

	public Boolean getVacation() {
		return vacation;
	}

	// other Methods
	public String toString() {
		String s = "";
		s += "Date: " + date + "\n" + "Test: " + test;
		return s;
	}
}