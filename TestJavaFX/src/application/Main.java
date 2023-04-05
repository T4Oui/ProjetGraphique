package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    	Parent root = FXMLLoader.load(getClass().getResource("Scene0.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
        //Parent root = loader.load();
        //MainSceneController controller = loader.getController();

        Scene scene = new Scene(root, 900, 700);
        primaryStage.setTitle("Ma fenêtre JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}