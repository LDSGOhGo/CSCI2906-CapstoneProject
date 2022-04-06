import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.collections.*;
import java.util.*;
import java.time.LocalTime;
import java.text.*;
import java.util.TimerTask;
import javafx.application.*;
import javafx.scene.layout.Pane;

public class PuzzleController {
	@FXML
	Pane red, yellow, green, blue;
	Pane[] ref = new Pane[] {red, yellow, green, blue};
	Pane[] colors = new Pane[4];
	char[][] puzzles = new char[][] {
		{'R', 'Y', 'G', 'B'},
		{'B', 'G', 'Y', 'R'},
		{'G', 'Y', 'B', 'R'},
		{'Y', 'G', 'R', 'B'}
	};
	
	@FXML
	protected void onStart() {
		Random rand = new Random();
		int puzzleInt = rand.nextInt((3 - 0) + 1) + 0;
		for(int i = 0; i < 4; i++) {
			if(puzzles[puzzleInt][i] == 'R') {
				Thread t = new Thread(() -> {
					Platform.runLater(() -> red.setStyle("-fx-border-color: red; -fx-border-width: 5px; -fx-background-color: red;"));
					try {
						Thread.sleep(2500);
					} catch(InterruptedException ex) {
						System.out.println(ex.toString());
					}
				});
			} else if(puzzles[puzzleInt][i] == 'Y') {
				Thread t = new Thread(() -> {
					Platform.runLater(() -> yellow.setStyle("-fx-border-color: yellow; -fx-border-width: 5px; -fx-background-color: yellow;"));
					try {
						Thread.sleep(2500);
					} catch(InterruptedException ex) {
						System.out.println(ex.toString());
					}
				});
			} else if(puzzles[puzzleInt][i] == 'G') {
				Thread t = new Thread(() -> {
					Platform.runLater(() -> green.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: green;"));
					try {
						Thread.sleep(2500);
					} catch(InterruptedException ex) {
						System.out.println(ex.toString());
					}
				});
			} else {
				Thread t = new Thread(() -> {
					Platform.runLater(() -> blue.setStyle("-fx-border-color: blue; -fx-border-width: 5px; -fx-background-color: blue;"));
					try {
						Thread.sleep(2500);
					} catch(InterruptedException ex) {
						System.out.println(ex.toString());
					}
				});
			}
		}
	}
}