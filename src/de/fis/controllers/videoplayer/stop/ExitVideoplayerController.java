package de.fis.controllers.videoplayer.stop;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ExitVideoplayerController {

    @FXML
    private Button exitButton;

    @FXML
    private Button closeButton;

    @FXML
    void buttonTapped(ActionEvent event) {
        Button button = (Button) event.getSource();

        switch (button.getId()) {
            case "exitButton":
                Platform.exit();
                break;
            case "closeButton":
                Stage stage = (Stage) button.getScene().getWindow();
                stage.close();
                break;
            default:
                System.err.println("Falscher Button: Bitte überprüfe ExitVideoplayerController.buttonTapped()");

        }

    }

}
