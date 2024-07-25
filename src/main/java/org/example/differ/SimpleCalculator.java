package org.example.differ;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class SimpleCalculator extends Application {

    private TextField num1Field = new TextField();
    private TextField num2Field = new TextField();
    private Label resultLabel = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calculator");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        // First Number
        grid.add(new Label("Number 1:"), 0, 0);
        grid.add(num1Field, 1, 0);

        // Second Number
        grid.add(new Label("Number 2:"), 0, 1);
        grid.add(num2Field, 1, 1);

        // Buttons
        Button addButton = new Button("Add");
        Button subtractButton = new Button("Subtract");
        Button multiplyButton = new Button("Multiply");
        Button divideButton = new Button("Divide");


        addButton.setOnAction(e -> calculate('+'));
        subtractButton.setOnAction(e -> calculate('-'));
        multiplyButton.setOnAction(e -> calculate('*'));
        divideButton.setOnAction(e -> calculate('/'));

        grid.add(addButton, 0, 2);
        grid.add(subtractButton, 1, 2);
        grid.add(multiplyButton, 0, 3);
        grid.add(divideButton, 1, 3);

        // Result
        grid.add(new Label("Result:"), 0, 4);
        grid.add(resultLabel, 1, 4);

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        resultLabel.setText("Cannot divide by zero");
                        return;
                    }
                    break;
            }
            resultLabel.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }
}