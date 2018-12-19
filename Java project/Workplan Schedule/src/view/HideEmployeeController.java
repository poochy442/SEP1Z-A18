package view;

import functionality.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HideEmployeeController {

	@FXML
	ListView<Employee> employeeListView;

	@FXML
	Button chooseButton;
	@FXML
	Button cancelButton;

	Model model = FileIO.loadFromBin();

	Employee chosenEmployee;

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
		for (Employee emp : model.getEmployees()) {
			if (emp.equals(chosenEmployee)) {
				if (emp.getHiddenStatus() == true) {
					emp.setHiddenStatus(false);
				} else {
					emp.setHiddenStatus(true);
				}
				break;
			}
		}
		
		FileIO.saveToBin(model);
		MainController.updateModel();
		
		for(Employee emp : model.getEmployees()) {
			if(emp.equals(chosenEmployee)) {
				System.out.println("Hidden: " + emp.getHiddenStatus());
			}
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
