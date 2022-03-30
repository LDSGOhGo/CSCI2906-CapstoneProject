import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.collections.*;
import java.util.*;
import java.time.LocalTime;

public class AlarmController {
	@FXML
	ChoiceBox hour, minute, ampm;
	@FXML
	Button militaryButton;
	String military[] = {"1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10" , "11" , "12" , "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20" , "21" , "22" , "23" , "24"};
	String standard[] = { "1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10" , "11" , "12"};
	
	@FXML
	protected void militaryToggle(MouseEvent event) {
		if(militaryButton.getText().equals("Military Time")) {
			ampm.setDisable(true);
			hour.setItems(FXCollections.observableArrayList(military));
			hour.setValue(military[5]);
			militaryButton.setText("Standard Time");
		} else {
			ampm.setDisable(false);
			hour.setItems(FXCollections.observableArrayList(standard));
			hour.setValue(standard[5]);
			militaryButton.setText("Military Time");
		}
	}
	
	@FXML
	protected void onStart(MouseEvent event) {
		/**try {
			int alarmHour = Integer.parseInt(hour.getValue().toString());
			int alarmMinute = Integer.parseInt(hour.getValue().toString());
			boolean am;
			if(ampm.getValue().toString().equals("AM")) {
				am = true;
			} else {
				am = false;
			}
			boolean pass = false;
			while(true) {
				LocalTime time = LocalTime.now();
				int currentHour = time.getHour();
				int currentMinute = time.getMinute();
				if(alarmHour == currentHour && alarmMinute == currentMinute) {
					System.out.println("Alarm noise here!");
					System.out.println("Alarm noise here!");
					System.out.println("Alarm noise here!");
					break;
				}
				Thread.sleep(30000);
			}
		} catch(InterruptedException ex) {
			System.out.println(ex.toString());
		}**/
	}
}