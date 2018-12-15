import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends Person implements Serializable {

	/* Fields */
	private List<SimpleEntry<String, Integer>> preferences;
	private List<SimpleEntry<String, Integer>> training;
	private Boolean hidden;
	private int counter;

	/* Constructor */
	public Employee(String name, String initials) {
		super(name, initials);
		preferences = new ArrayList<>();
		training = new ArrayList<>();
		hidden = false;
		counter = 0;
	}

	/* Methods */
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
	
	public List<SimpleEntry<String, Integer>> getTraining(){
		return training;
	}
	
	public void setTraining(List<SimpleEntry<String, Integer>> training) {
		this.training = training;
	}
	
	public void addTraining(String test, int level) {
		training.add(new SimpleEntry<String, Integer>(test, level));
	}
	
	public Boolean getHiddenStatus() {
		return hidden;
	}
	
	public void setHiddenStatus(Boolean status) {
		hidden = status;
	}

	// Method to check for specific preference
	public int checkForPreference(String test) {
		for (int i = 0; i < preferences.size(); i++) {
			if (preferences.get(i).getKey().equals(test)) {
				return preferences.get(i).getValue();
			}
			counter++;
		}
		return 0;
	}
	
	// Method to check for specific training
	public int checkForTraining(String test) {
		for(SimpleEntry<String, Integer> entry : training) {
			if(entry.getKey().equals(test)) {
				return entry.getValue();
			}
			counter++;
		}
		return -1;
	}
	
	public String toString() {
		return super.toString();
	}
	
	// Debug method
	public Integer getCounter() {
		return counter;
	}
}
