package com.example.gamep3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

    public class HelloApplication extends Application {

        private TextField[][] matrixFields = new TextField[4][4];
        private Label[] rowLabels = new Label[4];
        private Label[] colLabels = new Label[4];

        @Override
        public void start(Stage primaryStage) {
            GridPane matrixPane = new GridPane();
            matrixPane.setPadding(new Insets(10));
            matrixPane.setHgap(10);
            matrixPane.setVgap(10);

            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    matrixFields[row][col] = new TextField();
                    matrixFields[row][col].setPrefWidth(50);
                    matrixPane.add(matrixFields[row][col], col, row);
                }
            }

            HBox rowSumPane = new HBox();
            rowSumPane.setPadding(new Insets(10));
            rowSumPane.setSpacing(10);
            for (int row = 0; row < 4; row++) {
                rowLabels[row] = new Label("0");
                rowSumPane.getChildren().add(rowLabels[row]);
            }

            VBox colSumPane = new VBox();
            colSumPane.setPadding(new Insets(10));
            colSumPane.setSpacing(10);
            for (int col = 0; col < 4; col++) {
                colLabels[col] = new Label("0");
                colSumPane.getChildren().add(colLabels[col]);
            }

            HBox mainPane = new HBox();
            mainPane.setPadding(new Insets(10));
            mainPane.setSpacing(10);
            mainPane.getChildren().addAll(matrixPane, colSumPane);
            mainPane.getChildren().add(rowSumPane);

            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    int finalRow = row;
                    int finalCol = col;
                    matrixFields[row][col].textProperty().addListener((observable, oldValue, newValue) -> {
                        try {
                            int value = Integer.parseInt(newValue);
                            updateSums(finalRow, finalCol, value);
                        } catch (NumberFormatException e) {
                            // Ignore non-numeric input
                        }
                    });
                }
            }

            Scene scene = new Scene(mainPane);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private void updateSums(int row, int col, int value) {
            // Update row sum
            int rowSum = 0;
            for (int i = 0; i < 4; i++) {
                if (!matrixFields[row][i].getText().isEmpty()) {
                    rowSum += Integer.parseInt(matrixFields[row][i].getText());
                }
            }
            rowLabels[row].setText(Integer.toString(rowSum));

            // Update column sum
            int colSum = 0;
            for (int i = 0; i < 4; i++) {
                if (!matrixFields[i][col].getText().isEmpty()) {
                    colSum += Integer.parseInt(matrixFields[i][col].getText());
                }

                colLabels[col].setText(Integer.toString(colSum));
            }
        }

                public static void main(String[] args) {
        launch();
    }
}








