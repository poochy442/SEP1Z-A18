package view;

import functionality.Employee;
import functionality.FileIO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEmployeeController {
	
	@FXML
	Button saveButton;
	
	@FXML
	TextField nameField;
	@FXML
	TextField initialsField;
	
	Model model = FileIO.loadFromBin();
	
	@FXML
	public void save(ActionEvent event) {
		String name = nameField.getText();
		String initials = initialsField.getText();
		model.addEmployee(name, initials);
		
		FileIO.saveToBin(model);
		MainController.updateModel();
		
		for(Employee e : model.getEmployees()) {
			System.out.println(e);
		}
		
		Stage stage = (Stage) saveButton.getScene().getWindow();
		stage.close();
	}
	
}
