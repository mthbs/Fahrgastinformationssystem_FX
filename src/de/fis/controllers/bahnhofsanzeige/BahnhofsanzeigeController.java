package de.fis.controllers.bahnhofsanzeige;

import de.fis.addon.audio.AnsagenCreator;
import de.fis.addon.time.CurrentTime;
import de.fis.addon.time.Time;
import de.fis.controllers.ParentController;
import de.fis.database.DBConnection;
import de.fis.controllers.zwischenhalte.ZwischenhalteController;
import de.fis.model.Abfahrt;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.Duration;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class BahnhofsanzeigeController extends ParentController implements Initializable {

    private List<Abfahrt> abfahrtList = new ArrayList<>();

    private String bahnhof;

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

        bahnhof = "Frankfurt (Main) Süd";

        time = new Time(new CurrentTime().currentTime());

        labelTime.setText(time.getCurrentTime(true));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            // code every one second:
            time.oneSecondPassed();
            labelTime.setText(time.getCurrentTime(true));
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        labelStation.setText("Abfahrt " + bahnhof);
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
        abfahrtList = dba.getAbfahrten(time,6);
        fillRow(0, lbl_time1, lbl_znr1, lbl_gleis1, lbl_ziel1, txt_route1);
        fillRow(1, lbl_time2, lbl_znr2, lbl_gleis2, lbl_ziel2, txt_route2);
        fillRow(2, lbl_time3, lbl_znr3, lbl_gleis3, lbl_ziel3, txt_route3);
        fillRow(3, lbl_time4, lbl_znr4, lbl_gleis4, lbl_ziel4, txt_route4);
        fillRow(4, lbl_time5, lbl_znr5, lbl_gleis5, lbl_ziel5, txt_route5);
        fillRow(5, lbl_time6, lbl_znr6, lbl_gleis6, lbl_ziel6, txt_route6);

    }

    private String[] includeHalte(int index, String routeId) throws IOException {
        ZwischenhalteController jsa = new ZwischenhalteController();
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
        laufschrift(txt_route,15);
    }

    private void laufschrift(Text txt_route, int seconds){
        TranslateTransition animation = new TranslateTransition();
        animation.setDuration(Duration.seconds(seconds));
        animation.setFromX(0);
        animation.setToX(-(6*txt_route.getText().length()));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.setNode(txt_route);
        animation.play();
    }

    @FXML
    private void playAnsage() throws MaryConfigurationException, SynthesisException {
        List<Abfahrt> festerStand = abfahrtList;
        StringBuilder sb = new StringBuilder("Ihre nächsten Anschlüsse:    ");
        for(Abfahrt a : festerStand) {
            StringBuilder innerBuilder = new StringBuilder();
            innerBuilder.append(a.getZugnr() + " nach " + a.getRoute().getZielbf());
            ZwischenhalteController zwischenhalte = new ZwischenhalteController();
            String[] halte = zwischenhalte.getTripForId(a.getRouteId());
            if(halte.length>0 && halte[0] != ""){
                innerBuilder.append(" über " + halte[0]);
            }
            innerBuilder.append(" um " + a.getAbfahrt().getHour()
                    + " Uhr " + a.getAbfahrt().getMinute() + " von Gleis " + a.getGleis()+ "   ");
            sb.append(innerBuilder);
        }
        AnsagenCreator ace = new AnsagenCreator();
        ace.spieleText(sb.toString());

    }
}
