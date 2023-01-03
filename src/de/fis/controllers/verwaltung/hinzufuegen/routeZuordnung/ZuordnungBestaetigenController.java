package de.fis.controllers.verwaltung.hinzufuegen.routeZuordnung;

import de.fis.controllers.ParentController;
import de.fis.database.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ZuordnungBestaetigenController extends ParentController implements Initializable {


    @FXML
    private Label lbl_routeId;

    @FXML
    private Label lbl_zielbf;

    @FXML
    private Button btn_confirm;

    @FXML
    private Button btn_cancel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void btn_confirmTapped() throws SQLException, MalformedURLException {
        if(!(lbl_routeId.getText().isBlank() || lbl_zielbf.getText().isBlank())) {
        DBConnection dba = new DBConnection("root","root");
            dba.createNewRoute(lbl_routeId.getText(), lbl_zielbf.getText());
        }
        oeffneFahrtenhinzufuegen();
    }

    @FXML
    private void btn_cancelTapped() throws MalformedURLException {
        oeffneFahrtenhinzufuegen();
    }

    public void setLbl_routeId(String routeId) {
        this.lbl_routeId.setText(routeId);
    }

    public void setLbl_zielbf(String zielbf) {
        this.lbl_zielbf.setText(zielbf);
    }
}
