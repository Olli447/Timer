package timer;

import javafx.application.Platform;
import ui.UICounter;

import java.util.Timer;
import java.util.TimerTask;

public class Task_Count extends TimerTask{

    private int start;
    private int end;
    private int current;
    private Task_Count_Type type;
    private UICounter callback;
    private Timer timer;

    public Task_Count(int i, Task_Count_Type type, UICounter callback, Timer timer){
        if (type == Task_Count_Type.DECREASING){
            start = i;
            end = 0;
        } else if (type == Task_Count_Type.INCREASING){
            start = 0;
            end = i;
        } else {
            throw new UnsupportedOperationException("The Requested Operation is not supported;");
        }

        this.current = start;
        this.type = type;
        this.callback = callback;
        this.timer= timer;
        Platform.runLater(() -> callback.setTimerOutput(start));
    }

    @Override
    public void run() {
        if ((type == Task_Count_Type.INCREASING && current >= end) || (type == Task_Count_Type.DECREASING && current<=end)){
            timer.cancel();
            timer.purge();
            Platform.runLater(() -> callback.setTimerIsDone(true));
        }
        else if (type == Task_Count_Type.INCREASING){
            current++;
            Platform.runLater(() -> callback.setTimerOutput(current));
        } else if (type == Task_Count_Type.DECREASING){
            current--;
            Platform.runLater(() -> callback.setTimerOutput(current));
        } else {
            throw new UnsupportedOperationException("The Requested Operation is not supported;");
        }

    }
}
