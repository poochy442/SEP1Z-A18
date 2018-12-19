import functionality.*;

public class TestClass {

	public static void main(String[] args) {

		// Creating the schedule
		Schedule schedule = new Schedule(new Date(17, 12, 2018), new Date(23, 12, 2018));

		// Creating the worksheet and adding tests with required employees to it
		Worksheet worksheet = new Worksheet();
		worksheet.addTest("Food", 4);
		worksheet.addTest("Feed", 6);
		worksheet.addTest("Dairy", 6);
		worksheet.addTest("Protein", 6);

		EmployeeList empList = new EmployeeList();

		// Creating employees and adding them to the EmployeeList
		Employee kenneth = new Employee("Kenneth Jensen", "KJ");
		kenneth.addPreference("Food", 1);
		kenneth.addTraining("Food", 1);
		empList.add(kenneth);
		Employee teakosheen = new Employee("Teakosheen Joulak", "TJ");
		teakosheen.addTraining("Dairy", 1);
		teakosheen.addPreference("Dairy", 0);
		empList.add(teakosheen);
		Employee jimmi = new Employee("Jimmi C.B.", "JB");
		jimmi.addTraining("Feed", 1);
		jimmi.addPreference("Food", -1);
		empList.add(jimmi);
		Employee florin = new Employee("Florin Bordei", "FB");
		florin.addTraining("Protein", 1);
		empList.add(florin);

		// Add assignments to employees
		for (Employee e : empList.getEmployees()) {
			Date workingDate = schedule.getStartDate();
			for (int i = 0; i < 5; i++) {
				if (!worksheet.rightAmountInTest("Food", schedule.getEmployeesOnTest("Food"))) {
					schedule.addAssignment(new Assignment(workingDate, "Food"), e);
				} else if (!worksheet.rightAmountInTest("Feed", schedule.getEmployeesOnTest("Feed"))) {
					schedule.addAssignment(new Assignment(workingDate, "Feed"), e);
				} else if (!worksheet.rightAmountInTest("Dairy", schedule.getEmployeesOnTest("Dairy"))) {
					schedule.addAssignment(new Assignment(workingDate, "Dairy"), e);
				} else if (!worksheet.rightAmountInTest("Protein", schedule.getEmployeesOnTest("Protein"))) {
					schedule.addAssignment(new Assignment(workingDate, "Protein"), e);
				}
				workingDate.nextDay();
			}
		}

		// Test input validation for employees
		kenneth.addTraining(null, 0);

		// Test vacation
		for (Employee e : empList.getEmployees()) {
			Assignment vacation = new Assignment(schedule.getEndDate());
			vacation.setVacation();
			schedule.addAssignment(vacation, e);
		}

		// Output the HTML of the schedule
		HTMLGenerator.saveToHTML(schedule, "NewSchedule.html");

		// Check the training info is stored.
		for (Employee e : empList.getEmployees()) {
			System.out.println(e.toString() + "\n" + e.getTraining());
		}

	}
}
