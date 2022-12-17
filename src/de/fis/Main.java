package de.fis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


import java.sql.SQLException;


public class Main extends Application {

//    private MenuBar menuBar;

    public static void main(String[] args) throws SQLException {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainBoard.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style/root.css").toExternalForm());

//        setMenuBar();

        stage.setScene(scene);
        stage.show();

    }

//    private void setMenuBar() {
//        menuBar = new MenuBar();
//        Menu menu = new Menu("Bahnhofsanzeige");
//        MenuItem menuItem1 = new MenuItem("Setze 12:00 Uhr");
//        MenuItem menuItem2 = new MenuItem("Lade neu");
//        menu.getItems().addAll(menuItem1,menuItem2);
//        menuBar.getMenus().addAll(menu);
//    }

}
