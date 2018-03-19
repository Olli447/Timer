package ui;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import timer.Task_Count;
import timer.Task_Count_Type;

import java.util.Timer;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Controller controller = new Controller();
        loader.setController(controller);
        Parent root = loader.load();
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        controller.setScene(scene);
        primaryStage.show();

        Timer timer = new Timer();
        Task_Count task = new Task_Count(3, Task_Count_Type.DECREASING, controller,timer);
        timer.schedule(task, 1000,1000);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
