

public class Tester {
	
	public static void main(String[] args) {
		
		Schedule schedule = new Schedule(new Date(17, 12, 2018), new Date(23, 12, 2018));
		
		Employee jimmi = new Employee("John", "BD");
		Employee kenneth = new Employee("Kenneth", "KJ");
		Employee teako = new Employee("Teakosheen", "TK");
		Employee florin = new Employee("Florin", "FB");
		
		String[] tests = {"Feed", "Food", "Dairy", "Protein"};
		
		for(int i = 0; i < 7; i++) {
			Assignment a1 = new Assignment(new Date(17 + i, 12, 2018), tests[(int) (Math.random() * 3)]);
			Assignment a2 = new Assignment(new Date(17 + i, 12, 2018), tests[(int) (Math.random() * 3)]);
			Assignment a3 = new Assignment(new Date(17 + i, 12, 2018), tests[(int) (Math.random() * 3)]);
			Assignment a4 = new Assignment(new Date(17 + i, 12, 2018), tests[(int) (Math.random() * 3)]);
			
			schedule.addAssignment(a1, jimmi);
			schedule.addAssignment(a2, kenneth);
			schedule.addAssignment(a3, teako);
			schedule.addAssignment(a4, florin);
		}
		
		HTMLGenerator.saveToHTML(schedule);
		
	}
	
}
