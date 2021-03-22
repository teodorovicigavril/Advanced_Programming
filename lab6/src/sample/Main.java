package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public final int height = 475;
    public final int width = 700;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Label label_center = new Label("this is BorderPane center");
        label_center.setMaxSize(width,height*0.8);

        Label label_top = new Label("this is BorderPane top");
        label_top.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        label_top.setMinHeight(height*0.1);
        

        Label label_bottom = new Label("this is BorderPane bottom");
        label_bottom.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        label_bottom.setMinHeight(height*0.1);


        // create a BorderPane
        BorderPane border_pane = new BorderPane(label_center, label_top, null, label_bottom, null);

        // set alignment
       // BorderPane.setAlignment(label_top, Pos.CENTER);
       // BorderPane.setAlignment(label_bottom, Pos.CENTER);
        border_pane.getBottom().setStyle("-fx-background-color: #d65f5f");
        border_pane.setPadding(new Insets(5,5,5,5));
        border_pane.getTop().setStyle(" -fx-background-color: #c15757");
        border_pane.getCenter().setStyle("-fx-background-color: #c1c1db");


        primaryStage.setTitle("Hello World");

        Scene scene = new Scene(border_pane, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
