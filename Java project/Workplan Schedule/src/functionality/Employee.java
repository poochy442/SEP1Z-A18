package functionality;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Employee is an extension of the Person class.<!-- -->This class extends the Person with functionality to store preferences of work and the training of the employee
 * 
 * @author Kenneth Jensen
 * @author Florin Bordei
 * @author Teakosheen Joulak
 * @author Jimmi Børgesen
 * @version 1.0
 */
public class Employee extends Person implements Serializable {

	/* Fields */
	private List<SimpleEntry<String, Integer>> preferences;
	private List<SimpleEntry<String, Integer>> training;
	private Boolean hidden;
	
	/**
	 * This is the class constructor.
	 * 
	 * @param name the name of the employee.
	 * @param initials the initial code of the employee.
	 */
	public Employee(String name, String initials) {
		super(name, initials);
		preferences = new ArrayList<>();
		training = new ArrayList<>();
		hidden = false;
	}

	/**
	 * Method to get the preferences of the employee.
	 * 
	 * @return the list of preferences.
	 */
	public List<SimpleEntry<String, Integer>> getPreferences() {
		return preferences;
	}

	/**
	 * Method to set the preferences of the employee.
	 * 
	 * @param preferences a list of the preferences of the employee.
	 */
	public void setPreferences(List<SimpleEntry<String, Integer>> preferences) {
		this.preferences = preferences;
	}

	/**
	 * Method to add a preference to the list of the employees preferences.
	 * 
	 * @param test test to add to the list.
	 * @param preference the preference of the employee, -1 for dislike, 0 for no preference, 1 for like.
	 */
	public void addPreference(String test, int preference) {
		if(test == null) {
			return;
		}
		preferences.add(new SimpleEntry<String, Integer>(test, preference));
	}
	
	/**
	 * Method to get the training of the employee.
	 * 
	 * @return the list of training.
	 */
	public List<SimpleEntry<String, Integer>> getTraining(){
		return training;
	}
	
	/**
	 * Method to set the training of the employee.
	 * 
	 * @param training the list of training to set the employee to have.
	 */
	public void setTraining(List<SimpleEntry<String, Integer>> training) {
		this.training = training;
	}
	
	/**
	 * method to add training to the list of the employees training
	 * 
	 * @param test the test to add
	 * @param level an integer denoting the training of the employee: -1 for no training, 0 for under training, 1 for trained
	 */
	public void addTraining(String test, int level) {
		if(test == null) {
			return;
		}
		training.add(new SimpleEntry<String, Integer>(test, level));
	}
	
	/**
	 * Method to get the hidden status of the employee.<!-- -->Being hidden means, that the employee will not show up in searches through the employeeList
	 * 
	 * @return a Boolean value denoting whether the employee is hidden or not
	 */
	public Boolean getHiddenStatus() {
		return hidden;
	}
	
	/**
	 * Method to set the employees hidden status
	 * 
	 * @param status the status to set the employee to
	 */
	public void setHiddenStatus(Boolean status) {
		hidden = status;
	}

	/**
	 * Method to check the employee for a preference
	 * 
	 * @param test the test to search for
	 * @return the int set for the test. Default return value is 0 (no training)
	 */
	public int checkForPreference(String test) {
		for (int i = 0; i < preferences.size(); i++) {
			if (preferences.get(i).getKey().equals(test)) {
				return preferences.get(i).getValue();
			}
		}
		return 0;
	}
	
	/**
	 * Method to check the empoyee for training
	 * 
	 * @param test the test to search for
	 * @return the int set for the test. Default return value is 0 (no training)
	 */
	public int checkForTraining(String test) {
		for(SimpleEntry<String, Integer> entry : training) {
			if(entry.getKey().equals(test)) {
				return entry.getValue();
			}
		}
		return -1;
	}
	
	/**
	 * (non-Javadoc)
	 * @see functionality.Person#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}
