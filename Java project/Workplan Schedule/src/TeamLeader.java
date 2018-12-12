import java.util.Scanner;

public class TeamLeader extends Person {

	// Fields
	private String userName;
	private String password;
	private String teamName;

	// constructor
	public TeamLeader(String name, String initials, String password) {
		super(name, initials);
		this.userName = initials;
		this.password = password;
	}

	// Methods
	public Boolean login(String userName, String password) {
		if (this.userName.equals(userName) && this.password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	// Getters and Setters
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String currPassword, String newPassword) throws Exception {
		if(currPassword.equals(this.password)) {
			this.password = newPassword;
		} else {
			throw new Exception("Wrong password!");
		}
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("What would you like your password to be?");
		String password = input.nextLine();
		
		TeamLeader user = new TeamLeader("Kenneth", "KJ", password);
		
		System.out.println("Now, login:\n" + "Username?");
		String uInput = input.nextLine();
		
		System.out.println("Password?");
		String pInput = input.nextLine();
		
		if(user.login(uInput, pInput)) {
			System.out.println("Succes");
		} else {
			System.out.println("You failed!");
		}
		
		input.close();
	}

}