import java.io.Serializable;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public interface Model
{

   //Date
   public boolean isBetween(Date date, Date lowerBound, Date upperBound);
   
   //Employee
   
   public void setPreferences(Employee employee, List<SimpleEntry<String, Integer>> preferences);
   public void addPreference(Employee employee, String test, int preference);
   public List<SimpleEntry<String, Integer>> getTraining(Employee employee);
   public void setTraining(Employee employee, List<SimpleEntry<String, Integer>> training);
   public void addTraining(Employee employee, String test, int level);
   public Boolean getHiddenStatus(Employee employee);
   public void setHiddenStatus(Employee employee, Boolean status);
   public int checkForPreference(Employee employee, String test);
   public int checkForTraining(Employee employee, String test);
   
   //EmployeeList
   
   public int size();
   public void addEmployee(Employee person);
   public void removeEmployee(int index);
   public void removePerson(Employee person);
   public void hidePerson(Employee person);
   public void hidePerson(int index);
   public void showPerson(Employee person);
   public void showPerson(int index);
   public Person getPerson(int index);
   
   //Schedule 
   
   public Map<Person, List<Assignment>> getAssignments(int index);
   public void setAssignments(int index, Map<Person, List<Assignment>> assignments);
   public void addAssignment(int index, Assignment assignment, Person employee);
   public Map<Person, Map<Boolean, List<Assignment>>> sortAssignments(int index);
   public Date getStartDate(int index);
   public Date getEndDate(int index);
   
   //TeamLeader
   
   public Boolean login(String userName, String password);
   public void setPassword(String currPassword, String newPassword);
   public String getTeamName();
   public void setTeamName(String teamName);
   
}