import java.util.List;
import java.util.AbstractMap.SimpleEntry;

public class Model 
{

   //Date
   
   public void setDate(int day, int month, int year)
   public int getDate();
   public int getMonth();
   public int getYear();
   public boolean isLeapYear(int year);
   public int numberOfDaysInMonth();
   public String getMonthName();
   public void nextDay();
   public void nextDays(int days);
   public Date copy();
   public String toString();
   public String toFormalString();
   public boolean equals(Object obj);
   public boolean isBetween(Date lowerBound, Date upperBound);
   
   //Employee
   
   public void setPreferences(List<SimpleEntry<String, Integer>> preferences);
   public void addPreference(String test, int preference);
   public List<SimpleEntry<String, Integer>> getTraining();
   public void setTraining(List<SimpleEntry<String, Integer>> training);
   public void addTraining(String test, int level);
   public Boolean getHiddenStatus();
   public void setHiddenStatus(Boolean status);
   public int checkForPreference(String test);
   public int checkForTraining(String test);
   
   //EmployeeList
   
   public int size();
   public void add(Employee person);
   employeeList.remove(index);
   public void removePerson(Employee person);
   public void hidePerson(Employee person);
   public void hidePerson(int index);
   public void showPerson(Employee person);
   public void showPerson(int index);
   public Person getPerson(int index);
   
   //Person
   
   public String getName();
   public void setName(String name);
   public String getInitials();
   public void setInitials(String initials);
   
   //Schedule 
   
   public Map<Person, List<Assignment>> getAssignments();
   public void setAssignments(Map<Person, List<Assignment>> assignments);
   public void addAssignment(Assignment assignment, Person employee);
   public Map<Person, Map<Boolean, List<Assignment>>> sortAssignments();
   public Date getStartDate();
   public Date getEndDate();
   
   //TeamLeader
   
   public Boolean login(String userName, String password);
   public String getUserName();
   public String getPassword();
   public void setPassword(String currPassword, String newPassword);
   public String getTeamName();
   public void setTeamName(String teamName);
   
   //Assignment
   
   public void setTest(String test);
   public String getTest();
   public void setDate(Date date);
   public Date getDate();
   public void setVacation();
   public Boolean getVacation();
   
   
   
}