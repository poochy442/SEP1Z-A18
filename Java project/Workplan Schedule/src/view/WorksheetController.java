package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Functionality.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class WorksheetController {

	@FXML
	ScrollPane scrollPane;

	@FXML
	Button smallWeekButton;
	@FXML
	Button largeWeekButton;
	@FXML
	Button addTestButton;
	@FXML
	Button saveButton;
	@FXML
	Button cancelButton;

	Model model = FileIO.loadFromBin();

	String size;

	@FXML
	public void save() {
		for(String s : testList.getItems()) {
			String[] line = s.split(";");
			String test = line[0].trim();
			int amount = Integer.parseInt(line[1].trim());
			model.worksheetMap.get(size).getTests().put(test, amount);
		}
		FileIO.saveToBin(model);

		Stage stage = (Stage) saveButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void cancel() {
		Stage stage = (Stage) saveButton.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void addTest() {
		//TODO Add
	}

	@FXML
	public void updateTableSmall() {
		size = "S";
		//TODO change the update code
		testList.getItems().clear();
		for (String s : model.worksheetMap.get("S").getTests().keySet()) {
			testList.getItems().add(s + model.worksheetMap.get(size).getTests().get(s));
		}
	}

	@FXML
	public void updateTableLarge() {
		size = "L";
		//TODO change the update code
		testList.getItems().clear();
		for (String s : model.worksheetMap.get("L").getTests().keySet()) {
			testList.getItems().add(s + model.worksheetMap.get(size).getTests().get(s));
		}
	}

}
