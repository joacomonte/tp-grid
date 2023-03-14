package com.example.gamep3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the grid pane and set its properties
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(5);

        // Add text fields to each cell
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                TextField tf = new TextField();
                tf.setPrefColumnCount(1);
                grid.add(tf, col, row);
            }
        }

        // Create the scene and show the stage
        Scene scene = new Scene(grid, 250, 250);
        primaryStage.setTitle("Board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
