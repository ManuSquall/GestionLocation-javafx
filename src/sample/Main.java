package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.LoadView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        LoadView.showView("Menu", "menuUI.fxml",1);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
