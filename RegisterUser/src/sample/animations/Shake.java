package sample.animations;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.Node;

public class Shake {

    private TranslateTransition tt;

    public Shake(Node node){
        tt = new TranslateTransition(Duration.millis(70), node);
        tt.setFromX(0f);
        tt.setByX(5f);
        tt.setCycleCount(5);
        tt.setAutoReverse(true);
    }

    public void playAnim(){
        tt.playFromStart();
    }
}
