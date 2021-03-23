package sample;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ConfigPanel {

    private HBox box = new HBox();

    public ConfigPanel(){
        Label labelForSides = new Label("Number of sides: ");
        TextField inputSides = new TextField();

        Label sizeforSide = new Label("Size of a side: ");
        TextField inputSize = new TextField();

        inputSides.setMaxWidth(30);
        inputSize.setMaxWidth(60);
        box.setSpacing(10);
        box.setPadding(new Insets(15));

        box.getChildren().addAll(labelForSides, inputSides, sizeforSide, inputSize);
    }

    public HBox getBox() {
        return box;
    }

}
