package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneResultatHistoriqueController {

    @FXML
    private Button buttonAdmin;

    @FXML
    private Button buttonRetourner;

    @FXML
    private TextField entrerRecherche;

    @FXML
    void clickButtonAdmin(ActionEvent event) {

    }

    @FXML
    void clickButtonRetourner(ActionEvent event) throws Exception {
		if (!(entrerRecherche.getText().isEmpty() || entrerRecherche.getText().isBlank())) {
			Parent root = FXMLLoader.load(getClass().getResource("SceneHistorique.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();

		}
    }

    @FXML
    void entrerRecherche(ActionEvent event) {

    }

}
