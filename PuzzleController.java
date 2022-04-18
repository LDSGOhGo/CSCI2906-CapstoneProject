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
import javafx.scene.paint.Color;

public class PuzzleController {
	@FXML
	Pane red, yellow, green, blue;
	@FXML
	Button submit, skip;
	@FXML
	ChoiceBox redChoice, yellowChoice, greenChoice, blueChoice;
	@FXML
	Label incorrect;
	Pane[] ref = new Pane[] {red, yellow, green, blue};
	Pane[] colors = new Pane[4];
	String R, Y, G, B;
	char[][] puzzles = new char[][] {
		{'R', 'Y', 'G', 'B'},
		{'B', 'G', 'Y', 'R'},
		{'G', 'Y', 'B', 'R'},
		{'Y', 'G', 'R', 'B'}
	};
	int failCounter = 0;
	
	@FXML
	protected void onStart() {
		submit.setDisable(false);
		Random rand = new Random();
		int puzzleInt = rand.nextInt((3 - 0) + 1) + 0;
		for(int i = 0; i < 4; i++) {
			if(puzzles[puzzleInt][i] == 'R') {
				colors[i] = red;
				if(i == 0) {
					R = "Circle";
				} else if(i == 1) {
					R = "Cross";
				} else if(i == 2) {
					R = "Square";
				} else {
					R = "Triangle";
				}
			}
			else if(puzzles[puzzleInt][i] == 'Y') {
				colors[i] = yellow;
				if(i == 0) {
					Y = "Circle";
				} else if(i == 1) {
					Y = "Cross";
				} else if(i == 2) {
					Y = "Square";
				} else {
					Y = "Triangle";
				}
			}
			else if(puzzles[puzzleInt][i] == 'G') {
				colors[i] = green;
				if(i == 0) {
					G = "Circle";
				} else if(i == 1) {
					G = "Cross";
				} else if(i == 2) {
					G = "Square";
				} else {
					G = "Triangle";
				}
			}
			else {
				colors[i] = blue;
				if(i == 0) {
					B = "Circle";
				} else if(i == 1) {
					B = "Cross";
				} else if(i == 2) {
					B = "Square";
				} else {
					B = "Triangle";
				}
			}
		}
		Ellipse circle = new Ellipse(colors[0].getWidth() / 2 - 10, colors[0].getHeight() / 2 - 10);
		circle.centerXProperty().bind(colors[0].widthProperty().divide(2));
		circle.centerYProperty().bind(colors[0].heightProperty().divide(2));
		circle.radiusXProperty().bind(colors[0].widthProperty().divide(2).subtract(30));
		circle.radiusYProperty().bind(colors[0].heightProperty().divide(2).subtract(10));
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.BLACK);
		colors[0].getChildren().addAll(circle);
		
		Line one = new Line(10, 10, colors[1].getWidth() - 10, colors[1].getHeight() - 10);
		one.endXProperty().bind(colors[1].widthProperty().subtract(10));
		one.endYProperty().bind(colors[1].heightProperty().subtract(10));
		Line two = new Line(10, colors[1].getHeight() - 10, colors[1].getWidth() - 10, 10);
		two.startYProperty().bind(colors[1].heightProperty().subtract(10));
		two.endXProperty().bind(colors[1].widthProperty().subtract(10));
		colors[1].getChildren().addAll(one, two);
		
		Rectangle square = new Rectangle(colors[2].getWidth() / 3, colors[2].getHeight() / 8, 100, 100);
		colors[2].getChildren().addAll(square);
		
		Polygon triangle = new Polygon();
		triangle.getPoints().addAll( new Double[] {
			colors[3].getWidth() / 2, 20.0,
			colors[3].getWidth() / 5, colors[3].getHeight() - 20,
			colors[3].getWidth() - colors[3].getWidth() / 5, colors[3].getHeight() - 20
		});
		colors[3].getChildren().addAll(triangle);
	}
	@FXML
	protected void onSubmit() {
		String fromRed = redChoice.getValue().toString();
		String fromYellow = yellowChoice.getValue().toString();
		String fromGreen = greenChoice.getValue().toString();
		String fromBlue = blueChoice.getValue().toString();
		if(fromRed.equals(R) && fromYellow.equals(Y) && fromGreen.equals(G) && fromBlue.equals(B)) {
			System.exit(0);
		}
		else {
			incorrect.setVisible(true);
			failCounter++;
		}
		if(failCounter > 2) {
			skip.setDisable(false);
		}
	}
	@FXML
	protected void onSkip() {
		System.exit(0);
	}
}