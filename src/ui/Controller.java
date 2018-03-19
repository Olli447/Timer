package ui;

import javafx.scene.Scene;
import javafx.scene.control.Label;

public class Controller implements UICounter{

    private Label timer;
    private Scene scene;

    public Controller(){
    }

    @Override
    public void setTimerOutput(int i) {
        if (scene == null){
            throw new NullPointerException("Scene not se yet");
        }
        else if (timer == null){
            timer = (Label) scene.lookup("#timer");
        }

        timer.setText(i+"");
    }

    @Override
    public void setTimerIsDone(boolean b) {
        if (scene == null){
            throw new NullPointerException("Scene not se yet");
        }
        else if (timer == null){
            timer = (Label) scene.lookup("#timer");
        }

        timer.setText("Timer ended!");
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
