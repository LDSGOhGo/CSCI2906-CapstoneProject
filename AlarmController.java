import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.collections.*;
import java.util.*;
import java.time.LocalTime;
import java.text.*;
import java.util.TimerTask;
import javafx.application.*;

public class AlarmController {
	@FXML
	ChoiceBox hour, minute, ampm, difficulty;
	@FXML
	Button militaryButton, start;
	@FXML
	Label label1, label2, label3, label4, label5;
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
		int alarmHour = Integer.parseInt(hour.getValue().toString());
		int alarmMinute = Integer.parseInt(minute.getValue().toString());
		boolean am;
		if(ampm.getValue().toString().equals("AM")) {
			am = true;
		} else {
			am = false;
		}
		if(!am) {
			alarmMinute = alarmMinute + 12;
		}
		Date currentDate = new Date();
		Date alarmDate = new Date();
		if(alarmHour >= currentDate.getHours() && alarmMinute > currentDate.getMinutes()) {
			alarmDate = new Date(currentDate.getYear(), currentDate.getMonth(), currentDate.getDate(), alarmHour, alarmMinute, 0);
		}
		else {
			alarmDate = new Date(currentDate.getYear(), currentDate.getMonth(), currentDate.getDate() + 1, alarmHour, alarmMinute, 0);
		}
		System.out.println(alarmDate);
		hour.setVisible(false);
		minute.setVisible(false);
		ampm.setVisible(false);
		militaryButton.setVisible(false);
		difficulty.setVisible(false);
		label1.setText("Alarm Set");
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		label5.setVisible(false);
		start.setVisible(false);
		Timer timer = new Timer();
		timer.schedule(new MyTimeTask(), alarmDate);
	}
	
	private class MyTimeTask extends TimerTask {
		public void run() {
			Platform.runLater(() -> {
				label1.setText("Alarm goes off");
			});
		}
	}
}