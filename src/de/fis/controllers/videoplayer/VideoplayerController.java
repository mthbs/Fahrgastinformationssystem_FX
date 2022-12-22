package de.fis.controllers.videoplayer;

import de.fis.controllers.ParentController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class VideoplayerController extends ParentController {

    @FXML
    private Button openButton;

    @FXML
    private Button pauseButton;

    @FXML
    private Button playButton;

    @FXML
    private Button stopButton;

    @FXML
    private MediaView mediaView;

    // Musik
    private MediaPlayer mediaPlayer;

    private Media media;

    private File file;

    private String filePath;


    @FXML
    void openButtonTapped(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters()
                .addAll(new FileChooser.ExtensionFilter("mp4", "*.mp4"), new FileChooser.ExtensionFilter("mp3", "*.mp3"));
        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            filePath = file.toURI().toString();
        }
        if (filePath != null) {
            media = new Media(filePath);
            mediaPlayer = new MediaPlayer(media);

            mediaView.setMediaPlayer(mediaPlayer);

            // Binding
            DoubleProperty width = mediaView.fitWidthProperty();
            DoubleProperty height = mediaView.fitHeightProperty();
            width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
            height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

            mediaPlayer.play();
        }
    }

    @FXML
    void pauseButtonTapped(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @FXML
    void playButtonTapped(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    @FXML
    void stopButtonTapped(ActionEvent event) {
        // Neuer Controller: ExitVideoplayerController
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../../fxml/videoplayer/stop/ExitVideoplayer.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Exit");
        stage.show();

    }


}

