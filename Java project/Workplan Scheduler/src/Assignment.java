
public class Assignment {

	private Date date;
	private String test;
	private Boolean vacation;
	
	public Assignment(Date date) {
		this.date = date.copy();
		vacation = false;
	}
	
	public Assignment(Date date, String test) {
		this.date = date.copy();
		this.test = test;
		vacation = false;
	}
	
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
	
	public String toString() {
		String s = "";
		s += "Date: " + date + "\n" + "Test: " + test;
		return s;
	}
}