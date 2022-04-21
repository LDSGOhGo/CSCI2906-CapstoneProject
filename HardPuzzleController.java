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

public class HardPuzzleController {
	@FXML
	Pane aaa, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, aa, bb, cc, dd, ee, ff, gg, hh, ii, jj, kk, ll, mm, nn, oo, pp, qq, rr, ss, tt, uu, vv, ww, xx, yy, zz;
	@FXML
	List<Pane> blocks;
	@FXML
	Button start;
	String[] colors = {"black; ", "green; ", "blue; ", "red; ", "yellow; ", "orange; "};
	Random random = new Random();
	int redCount = 0;
	List<Pane> redBlocks;
	
	@FXML
	protected void onStart() {
		for(int i = 0; i < blocks.size(); i++) {
			int color = random.nextInt(5);
			if(colors[color].equals("red; ")) {
				redCount++;
				//redBlocks.add(blocks.get(i));
			}
			String style = "-fx-background-color: " + colors[color] + "-fx-border-color: black;";
			blocks.get(i).setStyle(style);
			start.setDisable(true);
		}
		System.out.println(redCount);
	}
	@FXML
	protected void onClick(MouseEvent event) {
		Pane pane = (Pane) event.getTarget();
		if(redBlocks.contains(pane)) {
			Line one = new Line(10, 10, pane.getWidth() - 10, pane.getHeight() - 10);
			one.endXProperty().bind(pane.widthProperty().subtract(10));
			one.endYProperty().bind(pane.heightProperty().subtract(10));
			Line two = new Line(10, pane.getHeight() - 10, pane.getWidth() - 10, 10);
			two.startYProperty().bind(pane.heightProperty().subtract(10));
			two.endXProperty().bind(pane.widthProperty().subtract(10));
			pane.getChildren().addAll(one, two);
			redCount--;
			pane.setDisable(true);
		}
		else {
			return;
		}
	}
}