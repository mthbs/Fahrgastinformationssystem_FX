package de.fis.controllers;

import de.fis.controllers.verwaltung.hinzufuegen.routeVerwaltung.RouteVerwaltenController;
import de.fis.database.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;


public class ParentController {


    @FXML
    protected Label lbl_signature;

    protected File cssFile = new File("src/de/fis/style/root.css");


    protected static DBConnection dba = new DBConnection("root", "root");

    @FXML
    protected void oeffneFahrtenhinzufuegen() throws MalformedURLException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(new File("src/de/fis/fxml/verwaltung/hinzufuegen/Fahrtenhinzufuegen.fxml").toURI().toURL());
        doOpenCloseOperations(fxmlLoader);
    }

    @FXML
    protected void oeffneFahrtenBearbeiten() throws MalformedURLException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(new File("src/de/fis/fxml/verwaltung/bearbeiten/FahrtenBearbeiten.fxml").toURI().toURL());
        doOpenCloseOperations(fxmlLoader);
    }

    @FXML
    protected void oeffneBahnhofsanzeige() throws MalformedURLException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(new File("src/de/fis/fxml/bahnhofsanzeige/Bahnhofsanzeige.fxml").toURI().toURL());
        doOpenCloseOperations(fxmlLoader);
    }

    @FXML
    protected void oeffneVideoplayer() throws MalformedURLException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(new File("src/de/fis/fxml/videoplayer/Videoplayer.fxml").toURI().toURL());
        doOpenCloseOperations(fxmlLoader);
    }

    @FXML
    protected void oeffneFXML(String path) throws MalformedURLException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(new File(path).toURI().toURL());
        doOpenCloseOperations(fxmlLoader);
    }

    public void oeffneZuordnungBestaetigen(String routeId, String zielbf) throws MalformedURLException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(new File("src/de/fis/fxml/verwaltung/hinzufuegen/routeVerwaltung/RouteVerwalten.fxml").toURI().toURL());
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        RouteVerwaltenController new_controller = fxmlLoader.getController();
        new_controller.setLbl_routeId(routeId);
        new_controller.setLbl_zielbf(zielbf);

        Parent root = fxmlLoader.getRoot();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssFile.toURI().toURL().toExternalForm());
        Stage openStage = new Stage();
        openStage.setScene(scene);
        openStage.show();
    }

    protected void doOpenCloseOperations(FXMLLoader fxmlLoader) throws MalformedURLException {
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssFile.toURI().toURL().toExternalForm());
        Stage openStage = new Stage();
        closeCurrentStage();
        openStage.setScene(scene);
        openStage.show();
    }

    protected void closeCurrentStage() {
        Stage closeStage = (Stage) lbl_signature.getScene().getWindow();
        closeStage.close();
    }

}
