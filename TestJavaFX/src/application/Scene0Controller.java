package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Scene0Controller implements Initializable {
    @FXML
    private MediaView videoPremiereScene;
    private MediaPlayer mediaPlayer;
    private Media media;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String path = "VPremiereScene.mp4";
        try {
            media = new Media(new File(path).toString()) ;
            mediaPlayer = new MediaPlayer(media);
            videoPremiereScene.setMediaPlayer(mediaPlayer);
            mediaPlayer.setAutoPlay(true);
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement de la vidéo: " + e.getMessage());
        }
    }
}
