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
		try {
			switch(puzzles[puzzleInt][0]) {
				case 'R':
				System.out.println("change red");
				red.setStyle("-fx-border-color: red; -fx-border-width: 5px; -fx-background-color: red; -fx-background-insets: 5;");
				Thread.sleep(2500);
				System.out.println("wake up");
				red.setStyle("-fx-background-color: red; -fx-background-insets: 5;");
				break;
				case 'Y':
				System.out.println("change yellow");
				yellow.setStyle("-fx-border-color: yellow; -fx-border-width: 5px; -fx-background-color: yellow; -fx-background-insets: 5;");
				Thread.sleep(2500);
				System.out.println("wake up");
				yellow.setStyle("-fx-background-color: yellow; -fx-background-insets: 5;");
				break;
				case 'G':
				System.out.println("change green");
				green.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: green; -fx-background-insets: 5;");
				Thread.sleep(2500);
				System.out.println("wake up");
				green.setStyle("-fx-background-color: green; -fx-background-insets: 5;");
				break;
				case 'B':
				System.out.println("change blue");
				blue.setStyle("-fx-border-color: blue; -fx-border-width: 5px; -fx-background-color: blue; -fx-background-insets: 5;");
				Thread.sleep(2500);
				System.out.println("wake up");
				blue.setStyle("-fx-background-color: blue; -fx-background-insets: 5;");
				break;
			}
		} catch(InterruptedException ex) {
			System.out.println(ex.toString());
		}
	}
}