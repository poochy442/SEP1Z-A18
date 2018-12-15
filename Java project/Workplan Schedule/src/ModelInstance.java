import java.util.AbstractMap.SimpleEntry;
import java.io.Serializable;
import java.util.*;

public class ModelInstance implements Model, Serializable {
	
	List<Schedule> scheduleList;
	EmployeeList employeeList;
	List<Worksheet> worksheetList;
	TeamLeader teamLeader;

	@Override
	public boolean isBetween(Date date, Date lowerBound, Date upperBound) {
		return date.isBetween(lowerBound, upperBound);
	}

	@Override
	public void setPreferences(Employee employee, List<SimpleEntry<String, Integer>> preferences) {
		employee.setPreferences(preferences);
		
	}

	@Override
	public void addPreference(Employee employee, String test, int preference) {
		employee.addPreference(test, preference);
	}

	@Override
	public List<SimpleEntry<String, Integer>> getTraining(Employee employee) {
		return employee.getTraining();
	}

	@Override
	public void setTraining(Employee employee, List<SimpleEntry<String, Integer>> training) {
		employee.setTraining(training);
		
	}

	@Override
	public void addTraining(Employee employee, String test, int level) {
		employee.addTraining(test, level);
	}

	@Override
	public Boolean getHiddenStatus(Employee employee) {
		return employee.getHiddenStatus();
	}

	@Override
	public void setHiddenStatus(Employee employee, Boolean status) {
		employee.setHiddenStatus(status);
	}

	@Override
	public int checkForPreference(Employee employee, String test) {
		return employee.checkForPreference(test);
	}

	@Override
	public int checkForTraining(Employee employee, String test) {
		return employee.checkForTraining(test);
	}

	@Override
	public int size() {
		return employeeList.size();
	}

	@Override
	public void addEmployee(Employee person) {
		employeeList.add(person);
	}

	@Override
	public void removeEmployee(int index) {
		employeeList.remove(index);
	}

	@Override
	public void removePerson(Employee person) {
		employeeList.removePerson(person);
	}

	@Override
	public void hidePerson(Employee person) {
		employeeList.hidePerson(person);
	}

	@Override
	public void hidePerson(int index) {
		employeeList.hidePerson(index);
	}

	@Override
	public void showPerson(Employee person) {
		employeeList.showPerson(person);
	}

	@Override
	public void showPerson(int index) {
		employeeList.showPerson(index);
	}

	@Override
	public Person getPerson(int index) {
		return employeeList.getPerson(index);
	}

	@Override
	public Map<Person, List<Assignment>> getAssignments(int index) {
		return scheduleList.get(index).getAssignments();
	}

	@Override
	public void setAssignments(int index, Map<Person, List<Assignment>> assignments) {
		scheduleList.get(index).setAssignments(assignments);
	}

	@Override
	public void addAssignment(int index, Assignment assignment, Person employee) {
		scheduleList.get(index).addAssignment(assignment, employee);
	}

	@Override
	public Map<Person, Map<Boolean, List<Assignment>>> sortAssignments(int index) {
		return scheduleList.get(index).sortAssignments();
	}

	@Override
	public Date getStartDate(int index) {
		return scheduleList.get(index).getStartDate();
	}

	@Override
	public Date getEndDate(int index) {
		return scheduleList.get(index).getEndDate();
	}

	@Override
	public Boolean login(String userName, String password) {
		return teamLeader.login(userName, password);
	}

	@Override
	public void setPassword(String currPassword, String newPassword) {
		try {
			teamLeader.setPassword(currPassword, newPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getTeamName() {
		return teamLeader.getTeamName();
	}

	@Override
	public void setTeamName(String teamName) {
		teamLeader.setTeamName(teamName);
	}

}
