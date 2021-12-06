package edu.isu.cs2263.proj.JavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FX extends Application {

    /**
     * Meat and potatoes of JavaFX UI
     * @param primaryStage Stage for this UI's main screen
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Stage Settings
        primaryStage.setTitle("Acquire");

        // Scenes
        Pane titleStuff = new Pane();
        Scene titleScreen = new Scene(titleStuff);

        Pane setupStuff = new Pane();
        Scene setupScene = new Scene(setupStuff);

        Pane gameStuff = new Pane();
        Scene gameScene = new Scene(gameStuff);

        // ------------ Title Scene -------------
        // Pane to hold things
        titleStuff.setLayoutY(0);
        titleStuff.setLayoutX(20);
        titleStuff.setPrefSize(50, 100);

        // Vbox for items
        VBox titleOptions = new VBox();
        titleOptions.setAlignment(Pos.TOP_CENTER);
        titleOptions.setLayoutY(0);
        titleOptions.setLayoutX(0);
        titleStuff.getChildren().add(titleOptions);

        // Game Title
        Label title = new Label("Acquire");
        titleOptions.getChildren().add(title);

        // Title elements
        Button newGame = new Button("New Game");
        newGame.setOnAction(event -> {
            primaryStage.setScene(setupScene);
        });

        Button loadGame = new Button("Load Game");

        Button exitGame = new Button("Exit");
        exitGame.setOnAction(event -> {
            System.exit(0);
        });

        titleOptions.getChildren().addAll(newGame, loadGame,exitGame);


        // ---------- New Game Setup Scene -------------
        setupStuff.setLayoutY(0);
        setupStuff.setLayoutX(10);
        setupStuff.setPrefSize(100, 100);

        // Vbox for items
        VBox setupOptions = new VBox();
        setupOptions.setLayoutY(0);
        setupOptions.setLayoutX(0);
        setupStuff.getChildren().add(setupOptions);

        // Setup Elements
        Label setupHeading = new Label("Setup");
        setupOptions.getChildren().add(setupHeading);

        // Number of Players
        ChoiceBox choosePlayerNum = new ChoiceBox();

        AtomicInteger numPlayers = new AtomicInteger(2);
        choosePlayerNum.getItems().add(0,"2 Players");
        choosePlayerNum.getItems().add(1,"3 Players");
        choosePlayerNum.getItems().add(2,"4 Players");

        setupOptions.getChildren().add(choosePlayerNum);
        choosePlayerNum.setOnAction(event -> {
            numPlayers.set(choosePlayerNum.getSelectionModel().getSelectedIndex());
        });

        // Button options
        HBox startGameOrNot = new HBox();
        setupOptions.getChildren().add(startGameOrNot);

        Button back = new Button("Back");
        back.setOnAction(event -> primaryStage.setScene(titleScreen));
        startGameOrNot.getChildren().add(back);

        Button start = new Button("Start");
        start.setOnAction(event ->
                primaryStage.setScene(gameScene));
        startGameOrNot.getChildren().add(start);


        // ---------- Game Scene ------------
        gameStuff.setLayoutY(0);
        gameStuff.setLayoutX(0);
        gameStuff.setPrefSize(500, 600);

        // Vbox for items
        VBox gameOptions = new VBox();
        gameOptions.setLayoutY(0);
        gameOptions.setLayoutX(0);
        gameStuff.getChildren().add(gameOptions);

        // Game Elements
//        HBox rowOne = new HBox();
//        List<Button> tileButtons = new ArrayList<>();
//        int tileNum = 1;
//        char tileLet = 'A';
//        for (int i = 0; i <= 9; i++) {
//            for (int j = 0; j <= 9; j++) {
//                String let = Character.toString(tileLet);
//                String name = let + tileNum;
//                Button button = new Button(name);
//                tileButtons.add(button);
//                System.out.print(let + tileNum + " ");
//                tileNum++;
//            }
//            System.out.println();
//            tileLet++;
//            tileNum = 1;
//        }
//
//        for(Button button: tileButtons){
//            rowOne.getChildren().add(tileButtons.remove(0));
//        }
//        gameOptions.getChildren().addAll(rowOne);


        // Set Scene
        primaryStage.setScene(titleScreen);

        primaryStage.show();
    }

    public static void classApp(String[] args) {
        launch(args);
    }
}
