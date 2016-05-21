package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;

public class GUIController implements Initializable {

	@FXML
	TextArea wingDingsArea;

	@FXML
	TextArea textArea;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		WingDingsLogic wd = new WingDingsLogic();
		wd.importWingDingsMap();
		wd.toWingDings("DARKDARKERYETDARKER");

	}

	@FXML
	public void onAction(){

		String input = textArea.getText();
		WingDingsLogic wdl = new WingDingsLogic();
		//System.out.println(input);
		String output = wdl.toWingDings(input);
		wingDingsArea.setText(output);
	}

	public void hideScrollBars(){

		//Optional method for eliminating scrollbars, because they are ugly and I cannot change their size without modifying the font-size

		ScrollBar scrollBarV1 = (ScrollBar) wingDingsArea.lookup(".scroll-bar:vertical");
		ScrollBar scrollBarV2 = (ScrollBar) textArea.lookup(".scroll-bar:vertical");
		scrollBarV1.setDisable(true); //THIS DOESN'T WORK FOR SOME REASON? Yields NullPointerException...
		scrollBarV2.setDisable(true);

		wingDingsArea.setWrapText(true);
		textArea.setWrapText(true);

	}

}
