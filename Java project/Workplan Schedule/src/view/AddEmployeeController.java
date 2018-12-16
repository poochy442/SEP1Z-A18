package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddEmployeeController {
	
	@FXML
	Button saveButton;
	
	@FXML
	public void save(ActionEvent event) {
		//TODO Save
		Stage stage = (Stage) saveButton.getScene().getWindow();
		stage.close();
	}
	
}
