package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static int height = 600;
    public static int width = 850;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        ConfigPanel configPanel = new ConfigPanel();
        DrawingPanel drawingPanel = new DrawingPanel(configPanel);
        ControlPanel controlPanel = new ControlPanel(drawingPanel);


        // create a BorderPane
        BorderPane border_pane = new BorderPane(drawingPanel.getBox(), configPanel.getBox(), null, controlPanel.getBox(), null);
        border_pane.getBottom().setStyle("-fx-background-color: #d65f5f; -fx-alignment: center");
        border_pane.setPadding(new Insets(5,5,5,5));
        border_pane.getTop().setStyle(" -fx-background-color: #c15757; -fx-alignment: center");
        border_pane.getCenter().setStyle("-fx-background-color: #c1c1db");


        primaryStage.setTitle("Best GeometryDrawing :)");
        Scene scene = new Scene(border_pane, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
