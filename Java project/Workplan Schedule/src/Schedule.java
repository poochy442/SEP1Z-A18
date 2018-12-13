import java.util.*;

public class Schedule {
	
	// Fields
	private Map<Person, List<Assignment>> assignments;
	private int counter;
	Date startDate, endDate;
	
	// Constructor
	public Schedule(Date startDate, Date endDate) {
		assignments = new HashMap<Person, List<Assignment>>();
		this.startDate = startDate;
		this.endDate = endDate;
		counter = 0;
	}
	
	// Methods
	// Getters and setters
	public Map<Person, List<Assignment>> getAssignments(){
		return assignments;
	}
	
	public void setAssignments(Map<Person, List<Assignment>> assignments) {
		this.assignments = assignments;
	}
	
	// This adds an assignment to the list of assignments
	public void addAssignment(Assignment assignment, Person employee) {
		if(assignments.containsKey(employee)) {
			assignments.get(employee).add(assignment);
		} else {
			assignments.put(employee, new ArrayList<Assignment>());
			assignments.get(employee).add(assignment);
		}
	}
	
	// This method sorts the assignments first based on person, then by vacation / work
	public Map<Person, Map<Boolean, List<Assignment>>> sortAssignments(){
		Map<Person, Map<Boolean, List<Assignment>>> returnMap = new HashMap<>();
		
		for(Person p : assignments.keySet()) {
			Map<Boolean, List<Assignment>> addMap = new HashMap<>();
			List<Assignment> work = new ArrayList<>(), vacation = new ArrayList<>();
			
			for(Assignment a : assignments.get(p)) {
				if(a.getVacation() == true) {
					vacation.add(a);
				} else {
					work.add(a);
				}
				counter++;
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
	
	// DEBUG: returns the counter
	public Integer getCounter() {
		return counter;
	}
	
}