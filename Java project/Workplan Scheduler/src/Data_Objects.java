
public class Data_Objects {

	private String name;
	private String initials;
	private String training;	
	
	public Data_Objects(String name, String initials, String training)
	{
		this.name = name;
		this.initials = initials;
		this.training = training;
	}
	
	public static void main(String[] args) {
		
		{
		   Employee Emp1 = new Employee("Bob", "BB2", "Trained");
		   Employee Emp2 = new Employee("Susan", "SN6", "Not Trained");
		   Employee Emp3 = new Employee("Ken", "KN2", "Trained");
		   Employee Emp4 = new Employee("Barbie", "BE7", "Under supervision");
		   Employee Emp5 = new Employee("Sussie", "SE4", "Trained");
		   Employee Emp6 = new Employee("Leo", "LO3", "Trained");
		   Employee Emp7 = new Employee("Alice", "AES", "Not Trained");
		   Employee Emp8 = new Employee("Carol", "CL9", "Trained");
		 }
	}
	// Vi skal også tage højde for: 
	// Dato, fat, Enzymes, Protein
	// Vacation, Pending Vacation, Milk, 
	// Cattle, Starch, Pig, Nitrogen, Chicken
	// Day on/off, Fiber/Sugar, Flex, Team-Number, Identials.
}
