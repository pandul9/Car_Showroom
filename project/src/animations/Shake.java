package animations;

import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;

public class Shake {
	private TranslateTransition TT;
	
	public Shake(Node node) {
		TT = new TranslateTransition(Duration.millis(70), node);
		TT.setFromX(-10f);
		TT.setByX(10f);
		TT.setCycleCount(3);
		TT.setAutoReverse(true);
	}
	
	public void playAnim() {
		TT.playFromStart();
	}
}
