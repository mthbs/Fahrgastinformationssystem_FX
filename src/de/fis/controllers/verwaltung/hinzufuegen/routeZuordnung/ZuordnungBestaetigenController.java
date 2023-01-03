package de.fis.controllers.verwaltung.hinzufuegen.routeZuordnung;

import de.fis.controllers.verwaltung.hinzufuegen.FahrtenhinzufuegenController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;


public class ZuordnungBestaetigenController extends FahrtenhinzufuegenController implements Initializable {


    @FXML
    public Label lbl_halte_title;

    @FXML
    public Label lbl_halte;

    @FXML
    private Label lbl_routeId;

    @FXML
    private Label lbl_zielbf;

    @FXML
    private MenuButton dropdown_ziel;

    @FXML
    private TextField input_ziel;

    @FXML
    private Button btn_confirm;

    @FXML
    private Button btn_cancel;

    @FXML
    private ScrollPane scrollPane;

    private Set<String> alleZiele = new HashSet<>();

    public void setLbl_routeId(String routeId) {
        this.lbl_routeId.setText(routeId);
    }

    public void setLbl_zielbf(String zielbf) {
        this.lbl_zielbf.setText(zielbf);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            alleZiele = dba.getAllUsedZiele();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (String s : alleZiele) {
            MenuItem menuItem = new MenuItem(s);
            menuItem.setOnAction(event -> {
                input_ziel.setText(menuItem.getText());
                dropdown_ziel.setText(menuItem.getText());
            });
            dropdown_ziel.getItems().add(menuItem);
        }

    }

    @FXML
    private void btn_confirmTapped() throws SQLException, MalformedURLException {
        if (!(lbl_routeId.getText().isBlank() || lbl_zielbf.getText().isBlank())) {
            dba.createNewRoute(lbl_routeId.getText(), lbl_zielbf.getText());
        }
        oeffneFahrtenhinzufuegen();
    }

    @FXML
    private void btn_cancelTapped() throws MalformedURLException {
        oeffneFahrtenhinzufuegen();
    }

    @FXML
    private void btn_plusClicked() {
        System.out.println("Button \"+\" Clicked");
    }

}
