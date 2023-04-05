package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import controleur.ControlModifierParametre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class SceneModifierParametreController implements Initializable {
	@FXML
	private MenuItem buttonDescirpteurSon;

	@FXML
	private MenuItem buttonDescripteurImage;

	@FXML
	private MenuItem buttonDescripteurTexte;
	@FXML
	private ComboBox<Integer> nbrEchant;
	@FXML
	private Button buttonAnnulerModification;

	@FXML
	private Button buttonEnregistrerModification;

	@FXML
	private ToggleButton buttonRechercheFerme;

	@FXML
	private ToggleButton buttonRechercheOuvert;

	@FXML
	private Button buttonRetourner;

	@FXML
	private Spinner<Integer> spinnerBItQuantification;

	@FXML
	private Spinner<Integer> spinnerNbrIntervalle;

	@FXML
	private Spinner<Integer> spinnerNbrOcc;
	private ControlModifierParametre controlModifierParametre = new ControlModifierParametre();
	private int currentValueBit = controlModifierParametre.getNbrBit();
	private int currentValueOcc = controlModifierParametre.getNbrOcc();
	private int currentValueInter = controlModifierParametre.getIntervalle();
	private int currentValueEch = controlModifierParametre.getNbrEch();
	private int currentmodeRecherche = controlModifierParametre.getMode();
	private int newValueBit;
	private int newValueOcc;
	private int newValueInter;
	private int newValueEch;
	private int newmodeRecherche;

	@FXML
	void clickAnnulerModification(ActionEvent event) {
		initial();
	}

	@FXML
	void clickButtonEnregistrerModification(ActionEvent event) {
		newValueBit = spinnerBItQuantification.getValue();
		newValueOcc = spinnerNbrOcc.getValue();
		newValueInter = spinnerNbrIntervalle.getValue();
		newValueEch = nbrEchant.getValue();
		if (newValueInter != currentValueInter) {
			controlModifierParametre.modifierIntervalle(newValueInter);
		}
		if (newmodeRecherche != currentmodeRecherche) {
			controlModifierParametre.modifierModeRecherche(newmodeRecherche);
		}
		if (newValueBit != currentValueBit) {
			controlModifierParametre.modifierNbrBit(newValueBit);
		}
		if (newValueOcc != currentValueOcc) {
			controlModifierParametre.modifierNbrOcc(newValueOcc);
		}
		if (newValueEch != currentValueEch) {
			controlModifierParametre.modifierNbrEch(newValueEch);
		}

	}

	@FXML
	void clickButtonDescripteurImage(ActionEvent event) {
		String filePath = "/home/souma/Bureau/ProjetFilRouge/image.txt";
        File file = new File(filePath);
        if (file.exists()) {
            try {
                Runtime.getRuntime().exec("gedit " + file.getAbsolutePath());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Le fichier n'existe pas."); 
        } 
	}

	@FXML
	void clickButtonDescripteurSon(ActionEvent event) {
		String filePath = "/home/souma/Bureau/ProjetFilRouge/image.txt";
        File file = new File(filePath);
        if (file.exists()) {
            try {
                Runtime.getRuntime().exec("gedit " + file.getAbsolutePath());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Le fichier n'existe pas."); 
        } 

	}

	@FXML
	void clickButtonDescripteurTexte(ActionEvent event) {
		String filePath = "/home/souma/Bureau/ProjetFilRouge/image.txt";
        File file = new File(filePath);
        if (file.exists()) {
            try {
                Runtime.getRuntime().exec("gedit " + file.getAbsolutePath());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Le fichier n'existe pas."); 
        } 

	}

	@FXML
	void clickButtonRechercheFerme(ActionEvent event) {
		newmodeRecherche = 2;
		buttonRechercheFerme.setStyle("-fx-border-color :  #6eb97e; -fx-border-width : 3  ");
		buttonRechercheOuvert.setStyle(" -fx-border-width : none ");
	}

	@FXML
	void clickButtonRechercheOuvert(ActionEvent event) {
		newmodeRecherche = 1;
		buttonRechercheOuvert.setStyle("-fx-border-color :  #6eb97e; -fx-border-width : 3  ");
		buttonRechercheFerme.setStyle(" -fx-border-width : none");

	}

	@FXML
	void clickButtonRetourner(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initial();

	}

	public void initial() {
		SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 3);
		valueFactory1.setValue(currentValueBit);
		spinnerBItQuantification.setValueFactory(valueFactory1);

		SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 10);
		valueFactory2.setValue(currentValueOcc);
		spinnerNbrOcc.setValueFactory(valueFactory2);

		SpinnerValueFactory<Integer> valueFactory4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 10);
		valueFactory4.setValue(currentValueInter);
		spinnerNbrIntervalle.setValueFactory(valueFactory4);

		ObservableList<Integer> liste = FXCollections.observableArrayList(1024, 2048, 4096);
		nbrEchant.setItems(liste);
		nbrEchant.setValue(currentValueEch);

		if (currentmodeRecherche == 2) {
			buttonRechercheFerme.setStyle("-fx-border-color :  #6eb97e; -fx-border-width : 3  ");
			buttonRechercheOuvert.setStyle(" -fx-border-width : none ");

		} else {
			buttonRechercheOuvert.setStyle("-fx-border-color :  #6eb97e; -fx-border-width : 3  ");
			buttonRechercheFerme.setStyle(" -fx-border-width : none");
		}

	}

}