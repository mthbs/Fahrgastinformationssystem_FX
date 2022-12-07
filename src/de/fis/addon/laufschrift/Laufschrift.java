package de.fis.addon.laufschrift;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Laufschrift extends Application {

    @Override
    public void start(Stage primaryStage) {

        //a vbox to take a picture of
        VBox vbox = new VBox();
        for (int i = 0; i < 30; i++)
            vbox.getChildren().add(new Text(" longer line of text " + i + " "));

        //take a sideways picture to fit the cylinder
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setTransform(new Rotate(90));
        WritableImage snapshot = vbox.snapshot(snapshotParameters, null);

        //make sideways cyl with image
        PhongMaterial material = new PhongMaterial();
        final Cylinder cylinder = new Cylinder(500, snapshot.getWidth(),30);
        material.setDiffuseMap(snapshot);
        cylinder.setMaterial(material);
        cylinder.setRotate(-90);
        cylinder.setTranslateX(snapshot.getWidth());
        cylinder.setTranslateY(500);

        //lights camera show
        final Group root = new Group();
        root.getChildren().add(cylinder);

        final Scene scene = new Scene(root, snapshot.getWidth()*2, cylinder.getRadius()*2, true);
        PointLight pointLight = new PointLight(Color.ALICEBLUE);
        pointLight.setTranslateX(150);
        pointLight.setTranslateY(500);
        pointLight.setTranslateZ(-1000);
        PerspectiveCamera cam = new PerspectiveCamera(false);
        scene.setCamera(cam);
        root.getChildren().addAll(pointLight, cam);

        primaryStage.setScene(scene);
        primaryStage.show();

        //I'll spin bob
        Rotate rx = new Rotate();
        rx.setAxis(Rotate.X_AXIS);
        cylinder.getTransforms().add(rx);
        cam.setRotationAxis(Point3D.ZERO);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        final KeyValue kv = new KeyValue(rx.angleProperty(), -360);
        final KeyFrame kf = new KeyFrame(Duration.millis(10000), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
