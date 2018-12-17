package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Functionality.*;

public class Model implements Serializable {

	TeamLeader user;
	Map<String, Worksheet> worksheetMap;
	EmployeeList employeeList;
	List<Schedule> scheduleList;

	public Model() {
		user = new TeamLeader("name", "admin", "password");
		worksheetMap = new HashMap<>();
		worksheetMap.put("S", new Worksheet());
		worksheetMap.put("L", new Worksheet());
		employeeList = new EmployeeList();
		scheduleList = new ArrayList<>();
	}

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

	public List<String> getTests(String size) {
		List<String> returnList = new ArrayList<>();
		for (String s : worksheetMap.get(size).getTests().keySet()) {
			returnList.add(s);
		}
		return returnList;
	}

	public void addTest(String s, int empNeeded, String size) {
		worksheetMap.get(size).addTest(s, empNeeded);
	}

	public void addEmployee(String name, String initials) {
		employeeList.add(new Employee(name, initials));
	}
	
	public Schedule getSchedule(int index) {
		return scheduleList.get(index);
	}
	
	public void addSchedule(Schedule schedule) {
		scheduleList.add(schedule);
	}
	
	public void removeSchedule(int index) {
		scheduleList.remove(index);
	}
	
	public List<Employee> getEmployees(){
		return employeeList.getEmployees();
	}
	
	public List<Schedule> getScheduleList(){
		return scheduleList;
	}
	
	public void removeEmployee(int index) {
		employeeList.remove(index);
	}
}
