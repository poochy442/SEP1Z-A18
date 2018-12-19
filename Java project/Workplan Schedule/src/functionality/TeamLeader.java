package functionality;

/**
 * TeamLeader is a child class of Person, extending it with functionality to login to the system.
 * 
 * @author Kenneth Jensen
 * @author Florin Bordei
 * @author Teakosheen Joulak
 * @author Jimmi Børgesen
 * @version 1.0
 */
public class TeamLeader extends Person {

	// Fields
	private String userName;
	private String password;
	private String teamName;

	/**
	 * This is the constructor for the class.
	 * 
	 * @param name the name of the team leader.
	 * @param initials the initials of the team leader. This doubles as the user name for logging in.
	 * @param password the password for the team leader.
	 */
	public TeamLeader(String name, String initials, String password) {
		super(name, initials);
		this.userName = initials;
		this.password = password;
	}

	/**
	 * Method to check a username and password against those stored in the object
	 * 
	 * @param userName username to check against.
	 * @param password passwrod to check against.
	 * @return whether or not the information matches.
	 */
	public Boolean login(String userName, String password) {
		if (this.userName.equals(userName) && this.password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method to get the username.
	 * 
	 * @return the username.
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Method to get the password.
	 * 
	 * @return the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Method to set the password. This checks to see, whether the the first password passed to this method is the same as the current password.
	 * 
	 * @param currPassword password to check against the current password.
	 * @param newPassword password to set the password of this to, if currPassword was equal to the current password.
	 * @throws Exception if currPassword is not equal to the current password
	 */
	public void setPassword(String currPassword, String newPassword) throws Exception {
		if(currPassword.equals(this.password)) {
			this.password = newPassword;
		} else {
			throw new Exception("Wrong password!");
		}
	}

	/**
	 * Method to get the team name of the team leader.
	 * 
	 * @return the team name of the team leader.
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * method to set the team name of the team leader.
	 * 
	 * @param teamName the team name to set the team leaders class variable to.
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}