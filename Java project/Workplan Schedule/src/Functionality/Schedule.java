package Functionality;

import java.io.Serializable;
import java.util.*;

public class Schedule implements Serializable {

	// Fields
	private Map<Person, List<Assignment>> assignments;
	private Date startDate, endDate;

	// Constructor
	public Schedule(Date startDate, Date endDate) {
		assignments = new HashMap<Person, List<Assignment>>();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	// Methods
	// Getters and setters
	public Map<Person, List<Assignment>> getAssignments() {
		return assignments;
	}

	public void putAssignment(Date date, Employee employee, Assignment assignment) {
		Date workingDate = startDate.copy();
		for (int i = 0; i < 7; i++) {
			if (workingDate.equals(date)) {
				if (assignments.containsKey(employee)) {
					// meant to set it to correct index
					assignments.get(employee).add(assignment);
					break;
				} else {
					List<Assignment> addList = new ArrayList<>();
					addList.add(assignment);
					assignments.put(employee, addList);
				}
			} else {
				workingDate.nextDay();
			}
		}
	}

	public void setAssignments(Map<Person, List<Assignment>> assignments) {
		this.assignments = assignments;
	}

	public Integer getEmployeesOnTest(String test) {
		int returnInt = 0;

		for (Person p : assignments.keySet()) {
			for (Assignment a : assignments.get(p)) {
				if (a.getTest().equals(test)) {
					returnInt++;
				}
			}
		}

		return returnInt;
	}

	public Map<String, Integer> getTestsAssigned() {
		Map<String, Integer> returnMap = new HashMap<>();
		for (Person p : assignments.keySet()) {
			for (Assignment a : assignments.get(p)) {
				if (returnMap.containsKey(a.getTest())) {
					returnMap.put(a.getTest(), returnMap.get(a.getTest()) + 1);
				} else {
					returnMap.put(a.getTest(), 1);
				}
			}
		}
		return returnMap;
	}

	// This adds an assignment to the list of assignments
	public void addAssignment(Assignment assignment, Person employee) {
		if (assignments.containsKey(employee)) {
			assignments.get(employee).add(assignment);
		} else {
			assignments.put(employee, new ArrayList<Assignment>(7));
			assignments.get(employee).add(assignment);
		}
	}

	// This method sorts the assignments first based on person, then by vacation /
	// work
	public Map<Person, Map<Boolean, List<Assignment>>> sortAssignments() {
		Map<Person, Map<Boolean, List<Assignment>>> returnMap = new HashMap<>();

		for (Person p : assignments.keySet()) {
			Map<Boolean, List<Assignment>> addMap = new HashMap<>();
			List<Assignment> work = new ArrayList<>(), vacation = new ArrayList<>();

			for (Assignment a : assignments.get(p)) {
				if (a.getVacation() == true) {
					vacation.add(a);
				} else {
					work.add(a);
				}
			}

			addMap.put(true, work);
			addMap.put(false, vacation);

			returnMap.put(p, addMap);
		}

		return returnMap;
	}

	public Date getStartDate() {
		return startDate.copy();
	}

	public Date getEndDate() {
		return endDate.copy();
	}

}