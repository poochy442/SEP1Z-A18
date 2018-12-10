public class Assignment
{
	/*
Important:
- Store 2 types of information   Date 
                                 Test 
- be flagged as vacation
- priority notes class- exercise)
*/

// Fields 
private Date date;
private String test;
private int numberOfNotes;
private Date[] assignment;

//Constructor
public Assignment(int day, int month, int year, String test)(int maxNumberOfNotes)
{
this.date = new date(day, month, year);
this.test = test;
this.numberOfAssignments = 0;
this.dates = new Test[maxNumberOfAssignments];
}
   
// Methods
// setters / getters

public Date setDate(Date date)
{
   this.date = date;
}

public Date getDate()
{
   return date[index];
}

public String setTest(String test)
{
this.test = test;   
}

public String getTest()
{
   return test;
}

// En ny dato tilføjes.
public void addDate(Date date)
{
   date[numberOfAssignments] = assignment.copy();
   numberOfAssignments++;
}

// En ny test tilføjes.
public void addTest(String test)
{
   notes[numberOfTests] = new Test(assignment);
   numberOfTests++;
}

// Test gives priotering 
public void addHighPriorityAssignment(String assignment)
{
   test[numberOfTests] = new test(test);
   test[numberOfTest].setToHighPriority();
   numberOfTest++;
}

// En opgave fjernes igen.
public void removeAssignment(int index)
{
   for (int i = index; i < numberOfAssignments; i++)
   {
      test[i] = tests[i + 1];
   }
   numberOfTests--;
}

// Samle alle opgaver med høj priotering.
public Date[] getAllAssignments()
{
   return Assignments;
}

public int getNumberOfPriorityAssignments()
{
   int k = 0;

   for (int i = 0; i < numberOfTests; i++)
   {
      if (test[i].isHighPriority())
         k ++; 
   }
   
   return k;
}

// Samle alle datoer med høj priotering.
public Test[] getAllHighPriorityAssignments()
{
Date[] hpAssign = new Date[getNumberOfPriorityAssignments()];
int k = 0;
for (int i = 0 ;i < numberOfAssignments; i++)
{
   if (Date[i].isHighPriority())
   {
      hpAssignment[k] = Assignment[i];
      k++;
   }
}
return hpassignment;
   
}


// Her oprettes og testes oogaverne og om de er sat til høj eller lav priotet.
public static void main (String [] args)
{
   Date Assignment = new test("Diary and Feed");
   System.out.println(Assignment.getAssignment());
   
   Assingnment.setAssignment("Fat and protein");
   System.out.println(Assignment.getAssignment());
   
   System.out.println(Assignment.isHighPriority());
   
   // Går ned til lav priotet igen.
   Assignment.setToLowPriority();
   
   // Nu vil vi se om opgaven faktisk blev sat til LowPriority.
   System.out.println(Assignment.isHighPriority());
   
   // Vi saetter prioteten op igen og tjekker.
   Assignment.setToHighPriority();
   
   // Vi tjekker ser det paa skaermen. 
   System.out.println(Assignment.isHighPriority());
}   
}

