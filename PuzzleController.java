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
import javafx.scene.shape.*;
import javafx.animation.*;
import javafx.util.Duration;

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
		final Timeline timeline = new Timeline();
		for(int i = 0; i < 4; i++) {
			if(puzzles[puzzleInt][i] == 'R') {
				timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2), event -> {
					red.setStyle("-fx-border-color: red; -fx-border-width: 5px; -fx-background-color: red; -fx-background-insets: 5;");
				}));
			} else if(puzzles[puzzleInt][i] == 'Y') {
				timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2), event -> {
					yellow.setStyle("-fx-border-color: yellow; -fx-border-width: 5px; -fx-background-color: yellow; -fx-background-insets: 5;");
				}));
			} else if(puzzles[puzzleInt][i] == 'G') {
				timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2), event -> {
					green.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: green; -fx-background-insets: 5;");
				}));
			} else {
				timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2), event -> {
					blue.setStyle("-fx-border-color: blue; -fx-border-width: 5px; -fx-background-color: blue; -fx-background-insets: 5;");
				}));
			}
		}
		timeline.play();
	}
}