package view;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import functionality.*;

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
		LocalDate lcDate = LocalDate.now();
		for(int i = 0; i < 3; i++) {
			if(i == 0) {
				scheduleList.add(new Schedule(new Date(lcDate.getDayOfMonth(), lcDate.getMonthValue(), lcDate.getYear()),
						new Date(lcDate.plusDays(7 - lcDate.getDayOfWeek().getValue()).getDayOfMonth(),
								lcDate.plusDays(7 - lcDate.getDayOfWeek().getValue()).getMonthValue(),
								lcDate.plusDays(7 - lcDate.getDayOfWeek().getValue()).getYear())));
			} else {
				Date oldStartDate, oldEndDate;
				oldStartDate = scheduleList.get(i - 1).getStartDate();
				oldEndDate = scheduleList.get(i - 1).getEndDate();
				
				scheduleList.add(new Schedule(oldStartDate.nextDays(7), oldEndDate.nextDays(7)));
			}
		}
	}

	public void addAssignment(Date chosenDate, String test, Employee employee) {
		for(Schedule schedule : scheduleList) {
			if(chosenDate.isBetween(schedule.getStartDate(), schedule.getEndDate())) {
				Assignment addAssignment = new Assignment(chosenDate);
				addAssignment.setTest(test);
				schedule.putAssignment(chosenDate, employee, addAssignment);
				break;
			}
		}
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
