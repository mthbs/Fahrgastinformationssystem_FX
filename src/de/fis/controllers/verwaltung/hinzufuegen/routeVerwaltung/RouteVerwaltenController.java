package de.fis.controllers.verwaltung.hinzufuegen.routeVerwaltung;

import de.fis.controllers.verwaltung.hinzufuegen.FahrtenhinzufuegenController;
import de.fis.controllers.zwischenhalte.ZwischenhalteController;
import de.fis.model.Unterwegshalt;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;


public class RouteVerwaltenController extends FahrtenhinzufuegenController implements Initializable {


    @FXML
    public VBox vbox = new VBox();

    @FXML
    private Label lbl_routeId;

    @FXML
    private Label lbl_zielbf;

    @FXML
    private Button btn_confirm;

    @FXML
    private Button btn_cancel;

    @FXML
    private ScrollPane scrollPane;

    private List<String> alleZiele = new ArrayList<>();

    private int counter = 0;

    private Map<String, TextField> textFieldIdMap = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            alleZiele = dba.getAllUsedZiele();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        renderRow();
    }

    @FXML
    private void btn_confirmTapped() throws SQLException, IOException {
        if (!(lbl_routeId.getText().isBlank() || lbl_zielbf.getText().isBlank())) {
            // Datenbank (RouteId -> Ziel wird erstellt)
            dba.createNewRoute(lbl_routeId.getText(), lbl_zielbf.getText());
            Unterwegshalt zwischenhalte = new Unterwegshalt();

            // StringArray erzeugen:
            List<String> halteList = new ArrayList<>();
            for (int i = 1; i <= counter; i++) {
                TextField temp = textFieldIdMap.get("input_ziel" + i);
                if (!(temp.getText().isBlank() || temp.getText().equals("."))) {
                    dba.createZielIfNotExists(temp.getText());
                    halteList.add(temp.getText());
                }
            }

            zwischenhalte.setValues(lbl_routeId.getText(), lbl_zielbf.getText(), halteList.toArray(new String[0]));
            ZwischenhalteController control = new ZwischenhalteController();
            control.addNewJSONEntry(zwischenhalte);
        }
        closeCurrentStage();

    }

    @FXML
    private void btn_cancelTapped() throws MalformedURLException {
        closeCurrentStage();
    }



    private void btn_plusClicked() {
        renderRow();
    }

    private void renderRow() {
        String newIndex = String.valueOf(++counter);
        HBox tmpHBox = new HBox();
        tmpHBox.setPrefHeight(50);
        tmpHBox.setPadding(new Insets(24, 0, 0, 0));

        Label newLabel = new Label("Haltepunkt" + newIndex);
        newLabel.setPrefWidth(135.0);
        newLabel.setPadding(new Insets(0, 0, 0, 35));
        MenuButton newDropDown = new MenuButton("Eingabe");
        newDropDown.setPrefWidth(150.0);
        TextField newTextField = new TextField(".");
        newTextField.setPrefWidth(300);
        newTextField.setStyle("-fx-padding-left: 50;");
        newTextField.setId("input_ziel" + newIndex);
        textFieldIdMap.put("input_ziel" + newIndex, newTextField);
        Button plusButton = new Button("+");
        plusButton.setPrefWidth(75);
        plusButton.setStyle("-fx-padding-left: 50;");
        plusButton.setOnAction(event -> btn_plusClicked());
        tmpHBox.getChildren().addAll(newLabel, newDropDown, newTextField, plusButton);

        for (String s : alleZiele) {
            MenuItem menuItem = new MenuItem(s);
            menuItem.setOnAction(event -> {
                newTextField.setText(menuItem.getText());
                newDropDown.setText(menuItem.getText());
            });
            newDropDown.getItems().add(menuItem);
        }

        vbox.getChildren().add(tmpHBox);
    }

    public void setLbl_routeId(String routeId) {
        this.lbl_routeId.setText(routeId);
    }

    public void setLbl_zielbf(String zielbf) {
        this.lbl_zielbf.setText(zielbf);
    }

}
