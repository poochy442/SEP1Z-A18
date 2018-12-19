package view;

import functionality.Employee;
import functionality.FileIO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifyEmployeeController {
	
	@FXML
	Button saveButton;
	@FXML
	Button cancelButton;
	
	@FXML
	TextField nameField;
	@FXML
	TextField initialField;
	
	@FXML
	ListView<Employee> employeeListView;
	
	Model model = FileIO.loadFromBin();
	
	Employee chosenEmployee;
	
	@FXML
	public void chooseEmployee() {
		chosenEmployee = employeeListView.getSelectionModel().getSelectedItem();
		nameField.setText(chosenEmployee.getName());
		initialField.setText(chosenEmployee.getInitials());
	}
	
	@FXML
	public void save(ActionEvent event) {
		String name = nameField.getText();
		String initials = initialField.getText();
		
		for(Employee emp : model.getEmployees()) {
			if(emp.equals(chosenEmployee)) {
				emp.setName(name);
				emp.setInitials(initials);
				System.out.println(emp);
			}
		}
		
		FileIO.saveToBin(model);
		MainController.updateModel();
		
		Stage stage = (Stage) saveButton.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void updateList() {
		employeeListView.getItems().clear();
		for (Employee e : model.getEmployees()) {
			employeeListView.getItems().add(e);
		}
	}
	
}