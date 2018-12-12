
public class TeamLeader extends Person {

	// Fields
	private String userName;
	private String password;
	private String teamName;

	// constructor
	public TeamLeader(String name, String initials, int day, int month, int year, String userName, String password) {
		super(name, initials, day, month, year);

	}

	// Methods
	public String execute() {
		if (this.userName.equals("admin") && this.password.equals("admin123")) {
			return "success";
		} else {
			return "error";
		}
	}

	// Getters and Setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/*
	 * public static void main(String[] args) { TeamLeader Teako = new
	 * TeamLeader("Teakosheen", "TK", 1, 7, 1983); Teako.setPassword("123");
	 * System.out.println(Teako.getPassword()); }
	 */
}