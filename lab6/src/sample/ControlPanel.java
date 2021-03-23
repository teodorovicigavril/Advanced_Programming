package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ControlPanel {
    private HBox box = new HBox();

    public ControlPanel(){
        Button load = new Button("Load");
        Button save = new Button("Save");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");


        box.setSpacing(10);
        box.setPadding(new Insets(15));

        box.getChildren().addAll(load,save,reset,exit);
    }

    public HBox getBox() {
        return box;
    }
}
