package sample;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ConfigPanel {

    private HBox box = new HBox();
    private int v_inputSize = 10;
    private int v_inputSides = 0;
    public static int type; // 0 - free drawing; 1 - drawing shapes


    // Config Panel va contine butoane si input uri in functie de modul selectat
    // Exista modul shape si free si la cel shape putem alege forme generale in care poti alege
    // numarul de laturi ale formei si marimea unei laturi, dar si modul particular in care poti
    // creea spre exemplu triunghiuri cu laturi variabile
    public ConfigPanel() {

        Label labelForSides = new Label("Number of sides: ");
        TextField inputSides = new TextField();

        Label sizeforSide = new Label("Size of a side: ");
        TextField inputSize = new TextField();

        Button submit = new Button("Submit");

        ComboBox comboBox = new ComboBox();

        comboBox.setPromptText("Choose mode");
        comboBox.getItems().add("Shape mode");
        comboBox.getItems().add("Free drawing mode");

        Label textLabel = new Label("Free drawing mode");
        textLabel.setStyle("-fx-font-size: 16;");

        ComboBox comboBox1 = new ComboBox();
        comboBox1.setPromptText("Choose a specific shape");
        comboBox1.getItems().add("By #sides");
        comboBox1.getItems().add("Triangle");
        comboBox1.getItems().add("Square");
        comboBox1.getItems().add("Pentagon");

        box.getChildren().addAll(textLabel, comboBox, submit);

        submit.setOnAction(e -> {
            boolean ok = false;
            String value = (String) comboBox.getValue();
            String value1 = (String) comboBox1.getValue();
            if (value1 == null || value1.equals("By #sides")) {
                textLabel.setText("Free drawing mode");
                if (inputSides.getText() != "")
                    v_inputSides = Integer.parseInt(inputSides.getText());
                else v_inputSides = 0;
                if (inputSize.getText() != "")
                    v_inputSize = Integer.parseInt(inputSize.getText());
                else v_inputSize = 10;
                box.getChildren().clear();
                box.getChildren().addAll(textLabel, labelForSides, inputSides, sizeforSide, inputSize, comboBox1, comboBox, submit);
            } else {
                if (value1.equals("Triangle")) {
                    v_inputSides = 3;
                    if (inputSize.getText() != "")
                        v_inputSize = Integer.parseInt(inputSize.getText());
                    else v_inputSize = 10;
                    textLabel.setText("Drawing TRIANGLES");
                    box.getChildren().clear();
                    box.getChildren().addAll(textLabel, sizeforSide, inputSize, comboBox1, comboBox, submit);
                    if(value.equals("Shape mode")) ok=true;
                }
                if (value1.equals("Square")) {
                    v_inputSides = 4;
                    if (inputSize.getText() != "")
                        v_inputSize = Integer.parseInt(inputSize.getText());
                    else v_inputSize = 10;
                    textLabel.setText("Drawing SQUARES");
                    box.getChildren().clear();
                    box.getChildren().addAll(textLabel, sizeforSide, inputSize, comboBox1, comboBox, submit);
                    if(value.equals("Shape mode")) ok=true;
                }
                if (value1.equals("Pentagon")) {
                    v_inputSides = 5;
                    if (inputSize.getText() != "")
                        v_inputSize = Integer.parseInt(inputSize.getText());
                    else v_inputSize = 10;
                    textLabel.setText("Drawing PENTAGONS");
                    box.getChildren().clear();
                    box.getChildren().addAll(textLabel, sizeforSide, inputSize, comboBox1, comboBox, submit);
                    if(value.equals("Shape mode")) ok=true;
                }
            }
            if(ok == false)
            if (value == null || value.equals("Shape mode")) {
                type = 1;
                textLabel.setText("Shape mode");
                box.getChildren().clear();
                box.getChildren().addAll(textLabel, labelForSides, inputSides, sizeforSide, inputSize, comboBox1, comboBox, submit);
            } else {
                textLabel.setText("Free drawing mode");
                type = 0;
                box.getChildren().clear();
                box.getChildren().addAll(textLabel, comboBox, submit);
            }

        });

        inputSides.setMaxWidth(30);
        inputSize.setMaxWidth(60);
        box.setSpacing(10);
        box.setPadding(new Insets(15));

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

    public int getType() {
        return type;
    }
}
