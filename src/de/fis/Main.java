package de.fis;

import de.fis.controllers.ParentController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;


public class Main extends Application {

    @Override
    public void start(final Stage stage) throws MalformedURLException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/bahnhofsanzeige/Bahnhofsanzeige.fxml"));
            //            Parent root = FXMLLoader.load(getClass().getResource("fxml/verwaltung/hinzufuegen/Fahrtenhinzufuegen.fxml"));
            //            Parent root = FXMLLoader.load(getClass().getResource("fxml/verwaltung/bearbeiten/Fahrtenverwaltung.fxml"));
            //            Parent root = FXMLLoader.load(getClass().getResource("fxml/videoplayer/Videoplayer.fxml"));
//            Parent root = FXMLLoader.load(getClass().getResource("src/de/fis/fxml/verwaltung/hinzufuegen/routeVerwaltung" +
//                    "/RouteVerwalten.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("style/root.css").toExternalForm());
            videoplayerAddon(scene, stage);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Message: " + e.getMessage() + "\n-------\n");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        launch(args);
    }

    private void videoplayerAddon(Scene scene, final Stage stage) {
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    stage.setFullScreen(true);
                } else if (mouseEvent.getClickCount() == 4) {
                    stage.setFullScreen(false);
                }
            }
        });
    }

}
