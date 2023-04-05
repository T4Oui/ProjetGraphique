package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SceneResultatRechercheController {
	@FXML
	private Button buttonSupprimer;
	@FXML
	private Button buttonHistorique;
	@FXML
	private Button buttonAdmin;

	@FXML
	private Button buttonChoisirFichier;

	@FXML
	private Button buttonRecherche;

	@FXML
	private Button buttonRetourner;

	@FXML
	private Slider choixPourcentageAssemblance;

	@FXML
	private TextField entrerRecherche;

	@FXML
	private Label pourcentage;

	@FXML
	void choisirPourcentageAssemblance(MouseEvent event) {
		// Ajouter un ChangeListener sur la propriété value du Slider
		choixPourcentageAssemblance.valueProperty().addListener((observable, oldValue, newValue) -> {
			// Calculer le pourcentage actuel du Slider
			double percentage = (newValue.doubleValue() / choixPourcentageAssemblance.getMax()) * 100;
			// Mettre à jour le texte du Label avec le pourcentage
			pourcentage.setText(String.format("%.0f%%", percentage));
		});

	}

	@FXML
	void clickButtonAdmin(ActionEvent event) {

	}

	@FXML
	void clickButtonChoisirFichier(ActionEvent event) {
		// Créer une instance de FileChooser
		FileChooser fileChooser = new FileChooser();

		// Définir le titre de la fenêtre de sélection de fichiers
		fileChooser.setTitle("Sélectionner un fichier");

		// Récupérer la référence à la fenêtre principale
		Stage stage = (Stage) buttonChoisirFichier.getScene().getWindow();

		// Vérifier si la référence est valide avant d'ouvrir la boîte de dialogue
		if (stage != null) {
			File selectedFile = fileChooser.showOpenDialog(stage);

			// Vérifier si un fichier a été sélectionné
			if (selectedFile != null) {
				// Extraire le nom du fichier à partir du chemin absolu
				String fileName = selectedFile.getName();
				// Mettre le nom du fichier sélectionné dans le TextField
				entrerRecherche.setText(fileName);
				entrerRecherche.setEditable(false);

			}
		}

	}

	@FXML
	void clickButtonRecherche(ActionEvent event) throws Exception {
		if (!(entrerRecherche.getText().isEmpty() || entrerRecherche.getText().isBlank())) {
			Parent root = FXMLLoader.load(getClass().getResource("SceneResultatRecherche.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();

		}

	}

	@FXML
	void clickButtonRetourner(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	void clickButtonHistorique(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("SceneHistorique.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();


	}

	@FXML
	void entrerRecherche(ActionEvent event) {

	}
	@FXML
	void clickButtonSupprimer(ActionEvent event) {
		entrerRecherche.clear();
		entrerRecherche.setEditable(true);

	}

}
