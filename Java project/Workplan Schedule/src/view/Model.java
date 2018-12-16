package view;

import Functionality.*;

public class Model {
	
	TeamLeader user = new TeamLeader("name", "admin", "password");
	
	public void setUserName(String userName) {
		user.setName(userName);
	}
	
	public void setUserInitials(String initials) {
		user.setInitials(initials);
	}
	
	public void setPassword(String currPassword, String newPassword) {
		try {
			user.setPassword(currPassword, newPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean login(String username, String password) {
		return user.login(username, password);
	}
	
}
