package functionality;

public class TestClass {

	public static void main(String[] args) {

		Schedule schedule = new Schedule(new Date(17, 12, 2018), new Date(23, 12, 2018));

		Worksheet worksheet = new Worksheet();
		worksheet.addTest("Food", 4);
		worksheet.addTest("Feed", 6);
		worksheet.addTest("Dairy", 5);
		worksheet.addTest("Protein", 5);

		EmployeeList empList = new EmployeeList();

		Employee kenneth = new Employee("Kenneth Jensen", "KJ");
		empList.add(kenneth);
		Employee teakosheen = new Employee("Teakosheen Joulak", "TJ");
		empList.add(teakosheen);
		Employee jimmi = new Employee("Jimmi C.B.", "JB");
		empList.add(jimmi);
		Employee florin = new Employee("Florin Bordei", "FB");
		empList.add(florin);

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
		
		HTMLGenerator.saveToHTML(schedule, "NewSchedule");

	}
}
