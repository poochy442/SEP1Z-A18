import java.util.*;

public class Schedule {
	
	// Fields
	private Map<Person, List<Assignment>> assignments;
	private int counter;
	
	// Constructor
	public Schedule() {
		assignments = new HashMap<Person, List<Assignment>>();
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
	
	// DEBUG: returns the counter
	public Integer getCounter() {
		return counter;
	}
	
	// main() method for testing
	public static void main(String[] args) {
		Schedule schedule = new Schedule();
		Employee e1 = new Employee("Kenneth", "KJ", 12, 11, 1997);
		Employee e2 = new Employee("Jimmi", "JB", 15, 16, 1892);
		
		Date today = new Date(9, 12, 2018);
		
		Assignment a1 = new Assignment(today);
		Assignment a2 = new Assignment(today);
		Assignment v1 = new Assignment(today);
		v1.setVacation();
		
		schedule.addAssignment(a1, e1);
		schedule.addAssignment(a2, e2);
		schedule.addAssignment(v1, e2);
		
		Map<Person, Map<Boolean, List<Assignment>>> result = schedule.sortAssignments();
		
		for(Person p : schedule.getAssignments().keySet()) {
			System.out.println(p.getName());
			System.out.println("Work: ");
			for(Assignment a : result.get(p).get(true)) {
				System.out.println(a);
			}
			System.out.println("Vacations: ");
			for(Assignment a : result.get(p).get(false)) {
				System.out.println(a);
			}
		}
	}
	
}