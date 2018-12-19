package view;

import java.util.Calendar;

import functionality.Date;
import functionality.FileIO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	Button loginButton;
	@FXML
	TextField usernameTextField;
	@FXML
	TextField passwordTextField;

	Model model = FileIO.loadFromBin();
	
	Date today = new Date(Calendar.DAY_OF_MONTH, Calendar.MONTH, Calendar.YEAR);
	
	@FXML
	public void login(ActionEvent event) {
		if(model.getScheduleList().size() != 0) {
			while(!today.isBefore(model.getSchedule(0).getEndDate())) {
				model.removeSchedule(0);
			}
		}
		
		if(!model.login(usernameTextField.getText(), passwordTextField.getText())) {
			passwordTextField.setText("");
			return;
		}
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/mainview.fxml"));
			Parent root = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setTitle("Schedule");
			stage.setScene(new Scene(root));
			stage.onCloseRequestProperty().setValue(e -> Platform.exit());
			stage.show();
			Stage thisStage = (Stage) loginButton.getScene().getWindow();
			thisStage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
