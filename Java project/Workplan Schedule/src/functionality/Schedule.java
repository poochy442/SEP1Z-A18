package functionality;

import java.io.Serializable;
import java.util.*;

/**
 * Schedule is a class that handles the assignment of Assignment objects to Person (or its subclasses) objects.
 * 
 * @author Kenneth Jensen
 * @author Florin Bordei
 * @author Teakosheen Joulak
 * @author Jimmi Børgesen
 * @version 1.0
 */
public class Schedule implements Serializable {

	// Fields
	private Map<Person, List<Assignment>> assignments;
	private Date startDate, endDate;

	/**
	 * This is the class constructor.
	 * 
	 * @param startDate the start date of the Schedule.
	 * 
	 * @param endDate the end date of the Schedule.
	 */
	public Schedule(Date startDate, Date endDate) {
		assignments = new HashMap<Person, List<Assignment>>();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * Method to get the assignments for every person.
	 * 
	 * @return the assignment for every person.
	 */
	public Map<Person, List<Assignment>> getAssignments() {
		for(Person p : assignments.keySet()) {
			for(int i = assignments.get(p).size(); i < 7; i++) {
				Date workingDate = startDate;
				assignments.get(p).add(new Assignment(workingDate.nextDays(7 - i)));
			}
		}
		return assignments;
	}

	/**
	 * Method to put an assignment into a persons list of assigments.
	 * 
	 * @param date the Date of the assignment.
	 * 
	 * @param employee the employee to the assignment to.
	 * 
	 * @param assignment the assignment to add.
	 */
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

	/**
	 * Method to set the assignments to a pre-made Map.
	 * 
	 * @param assignments the assignments to set the class variable to.
	 */
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

	/**
	 * Method to get type of tests assigned.
	 * 
	 * @return Map of strings, which is the different tests with a value that
	 * denotes how many of that test has been assigned.
	 */
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

	/**
	 * Method to add an assignment to a person.
	 * 
	 * @param assignment the assignment to add.
	 * 
	 * @param employee the employee to add the assignment to.
	 */
	public void addAssignment(Assignment assignment, Person employee) {
		if (assignments.containsKey(employee)) {
			assignments.get(employee).add(assignment);
		} else {
			assignments.put(employee, new ArrayList<Assignment>(7));
			assignments.get(employee).add(assignment);
		}
	}

	/**
	 * Method the sort the assignments.<!-- -->The assignments are sorted into a Map
	 * of Person objects, with a value of another map.<!-- -->This map then lists a
	 * boolean, whether the assignment is a vacation or not, and then the list of
	 * that type (vacation / not vacation).
	 * 
	 * @return the sorted map.
	 */
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

	/**
	 * Method to get the start date.
	 * 
	 * @return the start date.
	 */
	public Date getStartDate() {
		return startDate.copy();
	}

	/**
	 * Method to get the end date.
	 * 
	 * @return the end date.
	 */
	public Date getEndDate() {
		return endDate.copy();
	}

}