package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SceneHistoriqueController {

    @FXML
    private Button buttonAdmin;

    @FXML
    private Button buttonRetourner;

    @FXML
    void clickButtonAdmin(ActionEvent event) throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("SceneMot_De_Passe.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.setScene(scene);
    	stage.show();

    }

    @FXML
    void clickButtonRetourner(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

    }

}