package functionality;

import java.io.Serializable;
import java.util.*;

/**
 * Worksheet is a class that stores the amount of people needed for a specific test.
 * 
 * @author Kenneth Jensen
 * @author Florin Bordei
 * @author Teakosheen Joulak
 * @author Jimmi Børgesen
 * @version 1.0
 */
public class Worksheet implements Serializable {

	private Map<String, Integer> tests;

	/**
	 * This is the constructor of the class.
	 */
	public Worksheet() {
		tests = new HashMap<>();
	}

	/**
	 * Method to add a test to the worksheet.
	 * 
	 * @param test the test to add.
	 * 
	 * @param empNeeded employees needed for the test.
	 */
	public void addTest(String test, Integer empNeeded) {
		tests.put(test, empNeeded);
	}

	/**
	 * Method to get the all the test requirements stored in the worksheet.
	 * 
	 * @return the map of tests needed stored in the worksheet.
	 */
	public Map<String, Integer> getTests() {
		return tests;
	}

	/**
	 * method to set the tests to a pre-created Map of requirements.
	 * 
	 * @param tests the tests to set the class variable to.
	 */
	public void setTests(Map<String, Integer> tests) {
		this.tests = tests;
	}

	/**
	 * Method to check whether a team leader has assigned the right amount of
	 * employees to a test.
	 * 
	 * @param test test to check for.
	 * 
	 * @param empOnTest the amount of employees assigned to the test.
	 * 
	 * @return return a boolean value denoting whether or not there are the right
	 * amount on the test.<!-- -->This only return true of it has the exact right
	 * amount of employees.
	 */
	public Boolean rightAmountInTest(String test, Integer empOnTest) {
		if (tests.get(test) == empOnTest) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method to get the amount of employees needed, given the amount already assigned.
	 * 
	 * @param assignedTests a Map of tests and amount of employees assigned to them.
	 * @return a Map of tests and amount of employees needed. If there are too many employees assigned to a test, the values of this can be negative.
	 */
	public Map<String, Integer> empNeeded(Map<String, Integer> assignedTests) {
		Map<String, Integer> returnMap = new HashMap<>();
		for (String s : tests.keySet()) {
			if (assignedTests.get(s) != null) {
				returnMap.put(s, tests.get(s) - assignedTests.get(s));
			} else {
				returnMap.put(s, tests.get(s));
			}
		}
		return returnMap;
	}

}
