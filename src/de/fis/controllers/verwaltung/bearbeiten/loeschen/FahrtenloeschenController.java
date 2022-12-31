package de.fis.controllers.verwaltung.bearbeiten.loeschen;

import de.fis.controllers.ParentController;
import de.fis.database.DBConnection;
import de.fis.model.Abfahrt;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


public class FahrtenloeschenController extends ParentController implements Initializable {


    DBConnection dba;

    @FXML
    TextField field_id;

    @FXML
    TextField field_abfahrt;

    @FXML
    TextField field_zugnr;

    @FXML
    TextField field_gleis;

    @FXML
    TextField field_route;

    @FXML
    TableView<Abfahrt> table;

    @FXML
    private TableColumn<Abfahrt, String> tblcol_id;

    @FXML
    private TableColumn<Abfahrt, String> tblcol_abfahrt;

    @FXML
    private TableColumn<Abfahrt, String> tblcol_zugnr;

    @FXML
    private TableColumn<Abfahrt, String> tblcol_gleis;

    @FXML
    private TableColumn<Abfahrt, String> tblcol_route;

    @FXML
    private Button btn_loeschen;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // load Dropdown
        dba = new DBConnection("root", "root");
    }

    @FXML
    private void btn_finden_tapped() {
        int whereCounter = 0;
        StringBuilder query = new StringBuilder("SELECT * FROM activeworkbench.abfahrt");
        if (!(field_id.getText().isBlank() && field_abfahrt.getText().isBlank() && field_zugnr.getText().isBlank() && field_gleis.getText()
                .isBlank() && field_route.getText().isBlank())) {
            System.out.println("Mindestens ein Feld ist nicht blank");
            query.append(" WHERE ");
            if (!field_id.getText().isBlank()) {
                query.append(" abfahrt_id = \'" + field_id.getText() + "\' ");
                whereCounter++;
            }
            if (!field_abfahrt.getText().isBlank()) {
                if (whereCounter > 0) {
                    query.append(" AND ");
                }
                query.append(" abfahrt = \'" + field_abfahrt.getText() + "\' ");
                whereCounter++;
            }
            if (!field_zugnr.getText().isBlank()) {
                if (whereCounter > 0) {
                    query.append(" AND ");
                }
                query.append(" zugnr LIKE \'" + field_zugnr.getText() + "%\' ");
                whereCounter++;
            }
            if (!field_gleis.getText().isBlank()) {
                if (whereCounter > 0) {
                    query.append(" AND ");
                }
                query.append(" gleis = \'" + field_gleis.getText() + "\' ");
                whereCounter++;
            }
            if (!field_route.getText().isBlank()) {
                if (whereCounter > 0) {
                    query.append(" AND ");
                }
                query.append(" route_id = \'" + field_route.getText() + "\' ");
                whereCounter++;
            }

            query.append(" ORDER BY abfahrt ");
            System.out.println(query.toString());
            try {
                tblcol_id.setCellValueFactory(new PropertyValueFactory<Abfahrt, String>("id"));
                tblcol_abfahrt.setCellValueFactory(new PropertyValueFactory<Abfahrt, String>("abfahrt"));
                tblcol_zugnr.setCellValueFactory(new PropertyValueFactory<Abfahrt, String>("zugnr"));
                tblcol_gleis.setCellValueFactory(new PropertyValueFactory<Abfahrt, String>("gleis"));
                tblcol_route.setCellValueFactory(new PropertyValueFactory<Abfahrt, String>("routeId"));
                List<Abfahrt> abfahrtList = dba.getAbfahrten(query.toString());
                table.setItems(FXCollections.observableList(abfahrtList));
                if (abfahrtList.size() > 0) {
                    btn_loeschen.setDisable(false);
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

    }

    @FXML
    private void btn_loeschen_tapped() throws SQLException {
        Abfahrt tmp_abfahrt;
        if (!table.getSelectionModel().isEmpty()) {
            tmp_abfahrt = table.getSelectionModel().getSelectedItem();
            System.out.println(tmp_abfahrt.toString());
            String query = "DELETE FROM activeworkbench.abfahrt WHERE abfahrt_id = '" + tmp_abfahrt.getId() + "' ";
            dba.executeUpdateQuery(query);
        }
    }
}
