import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class Employee extends Person {
	
	// Fields
	List<SimpleEntry<String, Integer>> preferences;
	
	// Constructor
	public Employee(String name, String initials, int day, int month, int year) {
		super(name, initials, day, month, year);
		preferences = new ArrayList<>();
	}
	
	// Methods
	public void addPreference(String test, int preference) {
		preferences.add(new SimpleEntry<String, Integer>(test, preference));
	}
}
