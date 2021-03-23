package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;


public class ControlPanel {
    private HBox box = new HBox();

    public ControlPanel(DrawingPanel drawingPanel){
        Button load = new Button("Load");
        Button save = new Button("Save");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");

        save.setOnAction(e ->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.showOpenDialog();
        });

        reset.setOnAction(e ->{
            drawingPanel.getBox().getChildren().clear();
        });

        exit.setOnAction(e ->{
            Window primaryStage = box.getScene().getWindow();
            primaryStage.hide();
        });

        box.setSpacing(10);
        box.setPadding(new Insets(15));

        box.getChildren().addAll(load,save,reset,exit);

    }

    public HBox getBox() {
        return box;
    }
}
