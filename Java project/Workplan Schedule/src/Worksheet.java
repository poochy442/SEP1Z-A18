import java.util.*;

public class Worksheet {

	private Map<String, Integer> tests;

	public Worksheet() {
		tests = new HashMap<>();
	}

	public void addTest(String test, Integer empNeeded) {
		tests.put(test, empNeeded);
	}

	public Map<String, Integer> getTests() {
		return tests;
	}

	public void setTests(Map<String, Integer> tests) {
		this.tests = tests;
	}
	
	public Boolean rightAmountInTest(String test, Integer empOnTest) {
		if(tests.get(test) == empOnTest) {
			return true;
		} else {
			return false;
		}
	}
	
	// For assignedTests see Schedule class
	public Map<String, Integer> empNeeded(Map<String, Integer> assignedTests){
		Map<String, Integer> returnMap = new HashMap<>();
		for(String s : tests.keySet()) {
			if(assignedTests.get(s) != null) {
				returnMap.put(s, tests.get(s) - assignedTests.get(s));
			} else {
				returnMap.put(s, tests.get(s));
			}
		}
		return returnMap;
	}
	
}
