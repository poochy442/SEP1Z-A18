package functionality;
import java.io.Serializable;
import java.util.*;

/**
 * Employeelist is a class that collects Employee objects in a single List, for easy access.
 * 
 * @author Kenneth Jensen
 * @author Florin Bordei
 * @author Teakosheen Joulak
 * @author Jimmi Børgesen
 * @version 1.0
 */
public class EmployeeList implements Serializable {

	List<Employee> employeeList;

	/**
	 * This is the constructor for the class.
	 */
	public EmployeeList() {
		employeeList = new ArrayList<>();
	}

	/**
	 * Method to access the size of the employeeList.
	 * 
	 * @return the size of the employeelist.
	 */
	public int size() {
		return employeeList.size();
	}

	/**
	 * Method to add an employee to the list.
	 * 
	 * @param person the employee to add to the list.
	 */
	public void add(Employee person) {
		employeeList.add(person);
	}

	/**
	 * Method to remove an entry from the list.
	 * 
	 * @param index the index to remove from the list.
	 */
	public void remove(int index) {
		employeeList.remove(index);
	}

	/**
	 * Method to remove a specific person from the list.
	 * 
	 * @param person employee to remove.
	 */
	public void removePerson(Employee person) {
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).equals(person)) {
				employeeList.remove(i);
			}
		}
	}

	/**
	 * Method to hide a specific person, this means that the 'hidden' value of the employee is set to true.
	 * 
	 * @param person person to hide.
	 */
	public void hidePerson(Employee person) {
		for (Employee e : employeeList) {
			if (e.equals(person)) {
				e.setHiddenStatus(true);
			}
		}
	}

	/**
	 * Method to hide a person from the list.
	 * 
	 * @param index the index of the list to hide.
	 */
	public void hidePerson(int index) {
		employeeList.get(index).setHiddenStatus(true);
	}

	/**
	 * Method to show a specific person the list.<!-- -->This mean, that the 'hidden' value of the employee is set to false.
	 * 
	 * @param person person to show.<!-- -->Should the employee already be shown, nothing is changed.
	 */
	public void showPerson(Employee person) {
		for (Employee e : employeeList) {
			if (e.equals(person) && e.getHiddenStatus() == true) {
				e.setHiddenStatus(false);
			}
		}
	}

	/**
	 * Method to show a person from the list
	 * 
	 * @param index the index of the list to show.<!-- -->Should the employee already be shown, nothing is changed.
	 */
	public void showPerson(int index) {
		employeeList.get(index).setHiddenStatus(false);
	}

	/**
	 * Method to get a person from the list.
	 * 
	 * @param index the index of the list to get.
	 * @return the person at the given index.
	 */
	public Person getPerson(int index) {
		return employeeList.get(index);
	}
	
	/**
	 * Method to get the list of employees.
	 * 
	 * @return the list of employees.
	 */
	public List<Employee> getEmployees(){
		return employeeList;
	}

	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < employeeList.size(); i++) {
			s += employeeList.get(i);
			if (i < employeeList.size() - 1) {
				s += "\n";
			}
		}

		return s;
	}

}