import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.collections.*;

public class AlarmController {
	@FXML
	ChoiceBox hour, minute, ampm;
	@FXML
	ToggleButton militaryToggleButton;
	String military[] = {"1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10" , "11" , "12" , "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20" , "21" , "22" , "23" , "24"};
	String standard[] = { "1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10" , "11" , "12"};
	
	@FXML
	protected void militaryToggle(MouseEvent event) {
		if(militaryToggleButton.isSelected()) {
			hour.setItems(FXCollections.observableArrayList(military));
			ampm.setDisable(true);
		}
		else {
			hour.setItems(FXCollections.observableArrayList(standard));
			ampm.setDisable(false);
		}
	}
}