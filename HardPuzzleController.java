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
	Pane[] blocks = {aaa, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, aa, bb, cc, dd, ee, ff, gg, hh, ii, jj, kk, ll, mm, nn, oo, pp, qq, rr, ss, tt, uu, vv, ww, xx, yy, zz};
	String[] colors = {"black; ", "green; ", "blue; ", "red; ", "yellow; ", "orange; "};
	//Color[] colors = {Color.BLACK, Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW, Color.ORANGE};
	Random random = new Random();
	
	@FXML
	protected void onStart() {
		for(int i = 0; i < blocks.length; i++) {
			int color = random.nextInt(5);
			System.out.println(color);
			String style = "-fx-background-color: " + colors[color] + "-fx-border-color: black;";
			System.out.println(style);
			System.out.println(blocks[i]);
			blocks[i].setStyle(style);
		}
	}
}