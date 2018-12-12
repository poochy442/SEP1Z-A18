import java.util.*;

public class EmployeeList {

List<Employee> employeeList;
	
	public EmployeeList() {
		employeeList = new ArrayList<>();
	}
	
	public int size() {
		return employeeList.size();
	}
	
	public void add(Employee person) {
		employeeList.add(person);
	}
	
	public void remove(int index) {
		employeeList.remove(index);
	}
	
	public void removePerson(Employee person) {
		for(int i = 0; i < employeeList.size(); i++) {
			if(employeeList.get(i).equals(person)) {
				employeeList.remove(i);
			}
		}
	}
	
	public void hidePerson(Employee person) {
		for(Employee e : employeeList) {
			if(e.equals(person)) {
				e.setHiddenStatus(true);
			}
		}
	}
	
	public void hidePerson(int index) {
		employeeList.get(index).setHiddenStatus(true);
	}
	
	public void showPerson(Employee person) {
		for(Employee e : employeeList) {
			if(e.equals(person) && e.getHiddenStatus() == true) {
				e.setHiddenStatus(false);
			}
		}
	}
	
	public void showPerson(int index) {
		employeeList.get(index).setHiddenStatus(false);
	}
	
	public Person getPerson(int index) {
		return employeeList.get(index);
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < employeeList.size(); i++) {
			s += employeeList.get(i);
			if(i < employeeList.size() - 1) {
				s += "\n";
			}
		}
		
		return s;
	}

}