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
			for(int j = 0; j < 4; j++) {
				if(puzzles[puzzleInt][j] == puzzles[0][i]) {
					colors[j] = ref[i];
				}
			}
		}
		try {
			for(int i = 0; i < 4; i++) {
				System.out.println("run");
				if(colors[i] == red) {
					red.setStyle("-fx-border-color: red; -fx-border-width: 5px; -fx-background-color: red; -fx-background-insets: 5;");
					Thread.sleep(2500);
				} else if(colors[i] == yellow) {
					yellow.setStyle("-fx-border-color: yellow; -fx-border-width: 5px; -fx-background-color: yellow; -fx-background-insets: 5;");
					Thread.sleep(2500);
				} else if(colors[i] == green) {
					green.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: green; -fx-background-insets: 5;");
					Thread.sleep(2500);
				} else {
					blue.setStyle("-fx-border-color: blue; -fx-border-width: 5px; -fx-background-color: blue; -fx-background-insets: 5;");
					Thread.sleep(2500);
				}
			}
		} catch(InterruptedException ex) {
			System.out.println(ex.toString());
		}
	}
}