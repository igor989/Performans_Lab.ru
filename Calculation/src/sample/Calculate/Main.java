package sample.Calculate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label laNumber1 = new Label("Number1: ");

        TextField txt1 = new TextField();
        Label laNumber2 = new Label("Number2: ");

        TextField txt2 = new TextField();
        Label laNumber3 = new Label("Result: ");
        Label laResults = new Label();
        Button btn = new Button("=");
        btn.setOnAction((ActionEvent event) -> {
            try{
                double a = Double.parseDouble(txt1.getText().toString());
                double b = Double.parseDouble(txt2.getText().toString());
                while (b == 0) {
                    laResults.setText("Делить на 0 нельзя,\n" + "попробуйте снова");
                    return;
                    }
                double del = a / b;
                laResults.setText(String.format("%.5f",del));
                }catch (NumberFormatException e){
                laResults.setText("Вы ввели некорректное значение,\n" + "попробуйте снова");
                return;
                }
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setPadding(new Insets(25,25,25,25));
        grid.add(laNumber1,0,0);
        grid.add(txt1,1,0);

        grid.add(laNumber2,0,1);
        grid.add(txt2,1,1);

        grid.add(laNumber3,0,2);
        grid.add(laResults,1,2);
        grid.add(btn,2,3);

        Scene scene = new Scene(grid,400,275);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
