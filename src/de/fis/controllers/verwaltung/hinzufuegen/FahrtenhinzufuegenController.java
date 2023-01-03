package de.fis.controllers.verwaltung.hinzufuegen;

import de.fis.addon.time.Time;
import de.fis.controllers.ParentController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FahrtenhinzufuegenController extends ParentController implements Initializable {

    @FXML
    private Label lbl_title;

    @FXML
    private Button btn_abbrechen;

    @FXML
    private Button btn_add_form;

    @FXML
    private Button btn_free_form;

    @FXML
    private Button btn_new_ziel;

    @FXML
    private Button btn_proof_syntax;

    @FXML
    private MenuButton dropdown_linie;

    @FXML
    private MenuButton dropdown_ziel;

    @FXML
    private TextField input_linie;

    @FXML
    private TextField input_route_id;

    @FXML
    private TextField input_zeit_bis;

    @FXML
    private TextField input_zeit_takt;

    @FXML
    private TextField input_zeit_von;

    @FXML
    private TextField input_ziel;

    @FXML
    private TextField input_gleis;

    private boolean singleTrip = false;

    protected Set<String> allUsedLines = new HashSet<>();
    protected Set<String> allUsedZiele = new HashSet<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
            allUsedLines = dba.getAllUsedLines();
            allUsedZiele = dba.getAllUsedZiele();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // set Dropdown values:

        for (String s : allUsedLines) {
            MenuItem menuItem = new MenuItem(s);
            menuItem.setOnAction(event -> {
                input_linie.setText(menuItem.getText());
                dropdown_linie.setText(menuItem.getText());
            });
            dropdown_linie.getItems().add(menuItem);
        }
        for (String s : allUsedZiele) {
            MenuItem menuItem = new MenuItem(s);
            menuItem.setOnAction(event -> {
                input_ziel.setText(menuItem.getText());
                dropdown_ziel.setText(menuItem.getText());
            });
            dropdown_ziel.getItems().add(menuItem);
        }

        input_zeit_von.setText("12:00:00");
        //        input_zeit_bis.setText("12:30:00");
        //        input_zeit_takt.setText("30");
    }

    @FXML
    private void btnFreeFormClicked() {
        input_linie.setText("");
        input_ziel.setText("");
        input_zeit_von.setText("");
        input_zeit_bis.setText("");
        input_zeit_takt.setText("");
        input_route_id.setText(null);
    }

    @FXML
    private boolean btnProofSyntaxClicked() {
        if (input_linie.getText().length() > 0 && input_ziel.getText().length() > 0 && input_zeit_von.getText()
                .length() > 0 && input_route_id.getText().length() == 8) {

            // Zeit Regex:
            if (!regexIsValid(input_zeit_von.getText(), "\\d{2}:\\d{2}:\\d{2}") || !regexIsValid(input_route_id.getText(),
                    "\\d{8}") || !regexIsValid(input_gleis.getText(), "\\d{1}")) {
                System.out.println("Syntax is not correct");
                return false;
            }
            if (input_zeit_bis.getText().isBlank() || input_zeit_takt.getText().isBlank()) {
                System.out.println("Syntax is correct for single trip");
                singleTrip = true;
            } else {
                if (!regexIsValid(input_zeit_bis.getText(), "\\d{2}:\\d{2}:\\d{2}") || !regexIsValid(input_zeit_takt.getText(),
                        "\\d{0,3}")) {
                    System.out.println("Syntax is not correct");
                    return false;
                }
                System.out.println("Syntax is correct for many trips");
                singleTrip = false;
            }
        } else {
            System.out.println("Syntax is not correct");
            return false;
        }
        return true;
    }

    private boolean regexIsValid(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    @FXML
    private void btnNewZielClicked() throws SQLException {
        String str_new_ziel = input_ziel.getText().strip();
        // erstellt neues Ziel in der DB, falls noch nicht existent
        dba.createZielIfNotExists(str_new_ziel);
    }

    @FXML
    private void btnAddFormClicked() throws SQLException, MalformedURLException {
//        if (btnProofSyntaxClicked()) {
//
//            //             Datenbankabfrage erstellen aus Tabelle Route, if Route vorhanden mache direkt, if not, dann öffne neues Fenster
//            if (dba.routeVorhanden(input_route_id.getText(), input_ziel.getText())) {
//                if (input_zeit_bis.getText().isBlank() || input_zeit_takt.getText().isBlank()) {
//                    dba.createNewAbfahrt(input_zeit_von.getText(), input_linie.getText(), input_gleis.getText(), input_route_id.getText());
//                } else {
//                    Time timeVon = new Time(input_zeit_von.getText());
//                    Time timeBis = new Time(input_zeit_bis.getText());
//                    List<Time> timeList = timeVon.incrementList(timeVon, timeBis, Integer.parseInt(input_zeit_takt.getText()));
//                    for (Time t : timeList) {
//                        System.out.println("Neue Abfahrt (" + input_linie.getText() + "): " + t);
//                        dba.createNewAbfahrt(t.toString(), input_linie.getText(), input_gleis.getText(), input_route_id.getText());
//                    }
//                }
//            } else { // Route ist in Tabelle route nicht vorhanden
                oeffneZuordnungBestaetigen(input_route_id.getText(), input_ziel.getText());
//            }
//        } else {
//            lbl_title.setText(lbl_title.getText() + "(!)");
//        }
    }

    @FXML
    private void btnCancelClicked() throws MalformedURLException {
        oeffneBahnhofsanzeige();
    }
}
