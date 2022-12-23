package de.fis.controllers.bahnhofsanzeige;

import de.fis.addon.time.CurrentTime;
import de.fis.addon.time.Time;
import de.fis.controllers.ParentController;
import de.fis.database.DBConnection;
import de.fis.database.JSONConnection;
import de.fis.model.Abfahrt;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class BahnhofsanzeigeController extends ParentController implements Initializable {

    List<Abfahrt> abfahrtList = new ArrayList<>();

    @FXML
    private Label labelTime;

    @FXML
    private Label labelStation;

    @FXML
    private Label lbl_time1;

    @FXML
    private Label lbl_time2;

    @FXML
    private Label lbl_time3;

    @FXML
    private Label lbl_time4;

    @FXML
    private Label lbl_time5;

    @FXML
    private Label lbl_time6;

    @FXML
    private Label lbl_znr1;

    @FXML
    private Label lbl_znr2;

    @FXML
    private Label lbl_znr3;

    @FXML
    private Label lbl_znr4;

    @FXML
    private Label lbl_znr5;

    @FXML
    private Label lbl_znr6;

    @FXML
    private Label lbl_ziel1;

    @FXML
    private Label lbl_ziel2;

    @FXML
    private Label lbl_ziel3;

    @FXML
    private Label lbl_ziel4;

    @FXML
    private Label lbl_ziel5;

    @FXML
    private Label lbl_ziel6;

    @FXML
    private Label lbl_gleis1;

    @FXML
    private Label lbl_gleis2;

    @FXML
    private Label lbl_gleis3;

    @FXML
    private Label lbl_gleis4;

    @FXML
    private Label lbl_gleis5;

    @FXML
    private Label lbl_gleis6;

    @FXML
    private Text txt_route1;

    @FXML
    private Text txt_route2;

    @FXML
    private Text txt_route3;

    @FXML
    private Text txt_route4;

    @FXML
    private Text txt_route5;

    @FXML
    private Text txt_route6;

    @FXML
    private Text txt_infos;

    private Time time;


    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {

        time = new Time(new CurrentTime().currentTime());
//        time = new Time("14:00:00");

        labelTime.setText(time.getCurrentTime(true));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            // code every one second:
            time.oneSecondPassed();
            labelTime.setText(time.getCurrentTime(true));
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        labelStation.setText("Abfahrt Frankfurt(Main) Süd");
        try {
            ladeAbfahrten(time);
        } catch (SQLException e) {
            System.err.println("SQL Exception");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO Exception");
            e.printStackTrace();
        }
        Timeline timelineMinute = new Timeline(new KeyFrame(Duration.seconds(30), ev -> {
            try {
                ladeAbfahrten(time);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
        timelineMinute.setCycleCount(Animation.INDEFINITE);
        timelineMinute.play();

    }

    // Lädt Abfahrten füllt die Inhalte mit der fillRow-Funktion
    private void ladeAbfahrten(Time time) throws SQLException, IOException {
        // DB Connection
        DBConnection dba = new DBConnection("root", "root");
        abfahrtList.clear();
        abfahrtList = dba.getNextSix(time);
        fillRow(0, lbl_time1, lbl_znr1, lbl_gleis1, lbl_ziel1, txt_route1);
        fillRow(1, lbl_time2, lbl_znr2, lbl_gleis2, lbl_ziel2, txt_route2);
        fillRow(2, lbl_time3, lbl_znr3, lbl_gleis3, lbl_ziel3, txt_route3);
        fillRow(3, lbl_time4, lbl_znr4, lbl_gleis4, lbl_ziel4, txt_route4);
        fillRow(4, lbl_time5, lbl_znr5, lbl_gleis5, lbl_ziel5, txt_route5);
        fillRow(5, lbl_time6, lbl_znr6, lbl_gleis6, lbl_ziel6, txt_route6);
        laufschrift(txt_infos);

    }

    private String[] includeHalte(int index, String routeId) throws IOException {
        JSONConnection jsa = new JSONConnection();
        jsa.createList();
        return jsa.getTripForId(routeId);
    }

    private void fillRow(int index, Label lbl_time, Label lbl_znr, Label lbl_gleis, Label lbl_ziel, Text txt_route) throws IOException {
        lbl_time.setText(abfahrtList.get(index).getAbfahrt().getCurrentTime(false));
        lbl_znr.setText(abfahrtList.get(index).getZugnr());
        lbl_gleis.setText(abfahrtList.get(index).getGleis());
        lbl_ziel.setText(abfahrtList.get(index).getRoute().getZielbf());
        String[] routeArr = includeHalte(index, abfahrtList.get(index).getRouteId());
        String route = "";
        for (String s : routeArr) {
            if (route.equals("")) {
                route = "über: " + s;
            } else {
                route = route + ", " + s;
            }
        }
        if (route.equals("über: ")) {
            route = "";
        }
        txt_route.setText(route);
        laufschrift(txt_route);
    }

    private void laufschrift(Text txt_route) {
        int statt500 = 3 * txt_route.toString().length();
        txt_route.setTranslateX(150);
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            txt_route.setTranslateX(txt_route.getTranslateX() - 4);
            if (txt_route.getTranslateX() <= -statt500) {
                txt_route.setTranslateX(150);
            }
        }), new KeyFrame(Duration.millis(25)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

//    @FXML
//    private void oeffneVideoplayer() {
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource("../../fxml/videoplayer/Videoplayer.fxml"));
//        try {
//            fxmlLoader.load();
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//            e.printStackTrace();
//        }
//        Parent root = fxmlLoader.getRoot();
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("../../style/root.css").toExternalForm());
//        Stage openStage = new Stage();
//        Stage closeStage = (Stage) labelStation.getScene().getWindow();
//        closeStage.close();
//        openStage.setScene(scene);
//        openStage.show();
//    }
}
