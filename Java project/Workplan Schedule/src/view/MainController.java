package view;

import java.time.LocalDate;
import java.util.Arrays;

import functionality.Date;
import functionality.Employee;
import functionality.EmployeeList;
import functionality.FileIO;
import functionality.HTMLGenerator;
import functionality.Person;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainController {
	
	@FXML
	ListView<String> testList;
	@FXML
	ListView<String> employeeList;
	
	@FXML
	DatePicker testStartDate;
	
	@FXML
	MenuItem addEmployeeItem;
	@FXML
	MenuItem modifyEmployeeItem;
	@FXML
	MenuItem removeEmployeeItem;
	@FXML
	MenuItem hideEmployeeItem;
	@FXML
	MenuItem vacationItem;
	
	@FXML
	Button saveButton;
	@FXML
	Button generateButton;
	
	static Model model = (Model) FileIO.loadFromBin();
	
	public static void updateModel() {
		model = FileIO.loadFromBin();
	}
	
	@FXML
	public void generateHTML() {
		for(int i = 0; i < model.getScheduleList().size(); i++) {
			HTMLGenerator.saveToHTML(model.getSchedule(i), "Schedule " + (i + 1));
		}
	}
	
	@FXML
	public void addAssignment() {
		String test = testList.getSelectionModel().getSelectedItem();
		LocalDate date = testStartDate.getValue();
		Date startDate = new Date(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
		String empName = employeeList.getSelectionModel().getSelectedItem();
		Employee chosenEmployee = null;
		
		for(Employee e : model.getEmployees()) {
			if(e.getName().equals(empName)) {
				chosenEmployee = e;
				break;
			}
		}
		
		model.addAssignment(startDate, test, chosenEmployee);
		
		FileIO.saveToBin(model);
		updateModel();
	}
	
	@FXML
	public void updateEmployeeList() {
		employeeList.getItems().clear();
		for(Employee e : model.getEmployees()) {
			employeeList.getItems().add(e.getName());
		}
	}
	
	@FXML
	public void updateTestList() {
		testList.getItems().addAll(Arrays.asList("Feed", "Food", "Dairy", "Milk"));
	}
	
	@FXML
	public void addEmployee(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AddEmployee.fxml"));
			Parent root = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setTitle("Add Employee");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void modifyWorksheet(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/manageWorksheet.fxml"));
			Parent root = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setTitle("Manage Worksheets");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void modifyEmployee(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ModifyEmployee.fxml"));
			Parent root = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setTitle("Modify Employee");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void removeEmployee(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/employeeListRemove.fxml"));
			Parent root = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setTitle("Remove Employee");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void hideEmployee(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/employeeListHide.fxml"));
			Parent root = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setTitle("Hide Employee");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void vacation(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/vacationsickdays.fxml"));
			Parent root = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setTitle("Set Vacation and/or Sick days");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void save(ActionEvent event) {
		FileIO.saveToBin(model);
		System.out.println("Saved.");
	}
	
}
