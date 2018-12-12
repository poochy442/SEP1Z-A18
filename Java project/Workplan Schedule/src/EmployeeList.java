import java.util.*;

public class EmployeeList {

	int count;
	private Person[] employees;
	private int numberofemployees;

	public EmployeeList(int maxNoEmp, int numberofemployees) {
		this.employees = new Person[maxNoEmp];
		this.numberofemployees = numberofemployees;
	}

	public int size() {
		return numberofemployees;
	}

	public void addPerson(Person person) {
		addPerson(numberofemployees, person);
	}

	public void addPerson(int index, Person person) {
		if (numberofemployees < employees.length) {
			for (int i = numberofemployees - 1; i >= index; i--) {
				employees[i + 1] = employees[i];
			}
			employees[index] = person;
			numberofemployees++;
		}
	}

	public void removePerson(int index) {
		for (int i = index; i < numberofemployees - 1; i++) {
			employees[i] = employees[i + 1];
		}
		numberofemployees--;
	}

	public Person getPerson(int index) {
		return employees[index];
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < numberofemployees; i++) {
			s += employees[i];
			if (i < numberofemployees - 1) {
				s += "\n";
			}
		}
		return s;
	}
}