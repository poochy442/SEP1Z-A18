
public class Assignment {

	private Date date;
	private String test;
	private Boolean vacation;
	
	public Assignment(Date date) {
		this.date = date;
		vacation = false;
	}
	
	public void setTest(String test) {
		this.test = test;
	}
	
	public String getTest() {
		return test;
	}
	
	public Boolean getVacation() {
		return vacation;
	}
	
	public void setVacation() {
		vacation = true;
	}
	
	public String toString() {
		String s = "";
		s += "Date: " + date + "\n" + "Test: " + test;
		return s;
	}
}