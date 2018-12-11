import java.util.*;

public class TeamLeader extends Person {

	private String userName;
	private String password;
	private String teamName;

	// constructor
	public TeamLeader(String name, String initials, int day, int month, int year, String userName, String password) {
		super(name, initials, day, month, year);
		this.userName = userName;
		this.password = password;
	}

	// Methods
	public String getUserName() {
		return userName;
	}

	// set the userName
	public void setUserName(String initials) {
		userName = initials;
	}

	// create the password
	public void setPassword(String password) {
		this.password = password;
	}

	// test userName and Password
	public void checkLogin() {
		Scanner scan = new Scanner(System.in);
		String userName = scan.nextLine();
	    String password1 = scan.nextLine();
		
		if(userName.equals(getInitials()) && password1.equals(password));
		{
			System.out.println("You are logged in ");
		}
		else
		{
		System.out.println("Incorrect user name or password");
		}
		
	}

}
