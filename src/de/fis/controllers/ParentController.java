package de.fis.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class ParentController {


    @FXML
    protected Label lbl_signature;


    @FXML
    void oeffneBahnhofsanzeige(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../../fxml/bahnhofsanzeige/Bahnhofsanzeige.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../../style/root.css").toExternalForm());
        Stage openStage = new Stage();
        Stage closeStage = (Stage) lbl_signature.getScene().getWindow();
        closeStage.close();
        openStage.setScene(scene);
        openStage.show();
    }

    @FXML
    private void oeffneVideoplayer() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../../fxml/videoplayer/Videoplayer.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../../style/root.css").toExternalForm());
        Stage openStage = new Stage();
        Stage closeStage = (Stage) lbl_signature.getScene().getWindow();
        closeStage.close();
        openStage.setScene(scene);
        openStage.show();
    }

    @FXML
    public void oeffneFahrplanverwaltung() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../../fxml/fahrplanverwaltung/Fahrplanverwaltung.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../../style/root.css").toExternalForm());
        Stage openStage = new Stage();
        Stage closeStage = (Stage) lbl_signature.getScene().getWindow();
        closeStage.close();
        openStage.setScene(scene);
        openStage.show();
    }

}
