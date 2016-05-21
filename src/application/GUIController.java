package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class GUIController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	TextArea wingDingsArea;

	@FXML
	TextArea textArea;

	@FXML
	public void onAction(){

		String input = textArea.getText();
		WingDingsLogic wdl = new WingDingsLogic();
		//System.out.println(input);
		String output = wdl.toWingDings(input);
		wingDingsArea.setText(output);
	}


}
