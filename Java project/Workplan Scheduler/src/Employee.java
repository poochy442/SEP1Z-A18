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
	// Getters and Setters
	public List<SimpleEntry<String, Integer>> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<SimpleEntry<String, Integer>> preferences) {
		this.preferences = preferences;
	}

	public void addPreference(String test, int preference) {
		preferences.add(new SimpleEntry<String, Integer>(test, preference));
	}

	public int checkForPreference(String test) {
		for (int i = 0; i < preferences.size(); i++) {
			if (preferences.get(i).getKey().equals(test)) {
				return preferences.get(i).getValue();
			}
		}
		return 0;
	}
}
