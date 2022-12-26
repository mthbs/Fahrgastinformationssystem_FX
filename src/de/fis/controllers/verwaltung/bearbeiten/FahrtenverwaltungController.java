package de.fis.controllers.verwaltung.bearbeiten;

import de.fis.controllers.ParentController;
import de.fis.database.DBConnection;
import de.fis.model.Abfahrt;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


public class FahrtenverwaltungController extends ParentController implements Initializable {

    @FXML
    private Label lbl_signature;

    @FXML
    private Label lbl_title;

    @FXML
    private TableView<Abfahrt> table;

    @FXML
    private TableColumn<Abfahrt, String> tblcol_abfahrt;

    @FXML
    private TableColumn<Abfahrt, String> tblcol_gleis;

    @FXML
    private TableColumn<Abfahrt, String> tblcol_id;

    @FXML
    private TableColumn<Abfahrt, String> tblcol_route;

    @FXML
    private TableColumn<Abfahrt, String> tblcol_zugnr;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblcol_id.setCellValueFactory(new PropertyValueFactory<Abfahrt,String>("id"));
        tblcol_abfahrt.setCellValueFactory(new PropertyValueFactory<Abfahrt,String>("abfahrt"));
        tblcol_zugnr.setCellValueFactory(new PropertyValueFactory<Abfahrt,String>("zugnr"));
        tblcol_gleis.setCellValueFactory(new PropertyValueFactory<Abfahrt,String>("gleis"));
        tblcol_route.setCellValueFactory(new PropertyValueFactory<Abfahrt,String>("routeId"));
        // Wir brauchen eine Datenbank-Connection, die alle Fahrplandaten in eine sortierte Liste von Abfahrt-Objekt lädt.
        DBConnection dba = new DBConnection("root","root");
        try {
            List<Abfahrt> abfahrtList = dba.getAbfahrten(null,-1);
            table.setItems(FXCollections.observableList(abfahrtList));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
