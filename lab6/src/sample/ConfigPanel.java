package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ConfigPanel {

    private HBox box = new HBox();
    private int v_inputSize = 10;
    private int v_inputSides = 3;

    public ConfigPanel(){

        Label labelForSides = new Label("Number of sides: ");
        TextField inputSides = new TextField();

        Label sizeforSide = new Label("Size of a side: ");
        TextField inputSize = new TextField();
        Button submit = new Button("Submit");



        submit.setOnAction(e -> {
            if(inputSides.getText() != "")
                v_inputSides = Integer.parseInt(inputSides.getText());
            else    v_inputSides = 3;
            if(inputSize.getText() != "")
                v_inputSize = Integer.parseInt(inputSize.getText());
            else    v_inputSize = 10;
        });

        inputSides.setMaxWidth(30);
        inputSize.setMaxWidth(60);
        box.setSpacing(10);
        box.setPadding(new Insets(15));

        box.getChildren().addAll(labelForSides, inputSides, sizeforSide, inputSize, submit);
    }

    public HBox getBox() {
        return box;
    }

    public int getV_inputSize() {
        return v_inputSize;
    }

    public int getV_inputSides() {
        return v_inputSides;
    }
}
