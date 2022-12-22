package de.fis.controllers.fahrplanverwaltung;

import de.fis.controllers.ParentController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class FahrplanverwaltungController extends ParentController {

    @FXML
    private Button btn_abbrechen;

    @FXML
    private Button btn_add_form;

    @FXML
    private HBox btn_cancel;

    @FXML
    private Button btn_free_form;

    @FXML
    private Button btn_new_linie;

    @FXML
    private Button btn_new_ziel;

    @FXML
    private Button btn_route_proof_syntax;

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



}
