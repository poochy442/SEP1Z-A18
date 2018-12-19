package view;

import functionality.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RemoveEmployeeController {
	
	@FXML
	ListView<Employee> employeeListView;
	
	@FXML
	Button chooseButton;
	@FXML
	Button cancelButton;
	
	Model model = FileIO.loadFromBin();

	Employee chosenEmployee;
	Stage removeStage;
	
	@FXML
	public void chooseEmployee(MouseEvent arg0) {
		chosenEmployee = employeeListView.getSelectionModel().getSelectedItem();
		System.out.println(chosenEmployee);
	}

	@FXML
	public void choose(ActionEvent event) {
		if (chosenEmployee == null) {
			return;
		}
		
		for(int i = 0; i < model.employeeList.size(); i++) {
			if(model.getEmployees().get(i).equals(chosenEmployee)) {
				model.removeEmployee(i);
				break;
			}
		}
		
		FileIO.saveToBin(model);
		MainController.updateModel();
		
		for(Employee emp : model.getEmployees()) {
			System.out.println(emp);
		}
		
		Stage stage = (Stage) chooseButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void updateEmployeeList() {
		employeeListView.getItems().clear();
		for (Employee e : model.getEmployees()) {
			employeeListView.getItems().add(e);
		}
	}
	
}
