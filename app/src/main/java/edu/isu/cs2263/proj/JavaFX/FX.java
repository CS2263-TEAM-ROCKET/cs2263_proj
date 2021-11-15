package edu.isu.cs2263.proj.JavaFX;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FX extends Application {

    /**
     * Meat and potatoes of JavaFX UI
     * @param primaryStage Stage for this UI's main screen
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Stage Settings
        primaryStage.setTitle("Title");
        primaryStage.setWidth(500); // 500
        primaryStage.setHeight(485); // 485

        // Pane to hold things
        Pane pane = new Pane();
        // pane.getChildren().addAll(listAran, listLabls, listButtons);
        pane.setPrefSize(600, 400);

        Scene newGame = new Scene(pane);
        primaryStage.setScene(newGame);

        primaryStage.show();
    }

    public static void classApp(String[] args) {
        launch(args);
    }
}
