package view;

import Functionality.FileIO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainController {
	
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
	}
	
}
