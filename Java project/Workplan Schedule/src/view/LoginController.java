package view;

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

	Model model = new Model();

	MainController mainController = new MainController();
	
	@FXML
	public void login(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/mainview.fxml"));
			Parent root = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setTitle("Schedule");
			stage.setScene(new Scene(root));
			stage.show();
			Stage thisStage = (Stage) loginButton.getScene().getWindow();
			thisStage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
