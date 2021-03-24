package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;


public class DrawingPanel {
    private BorderPane group = new BorderPane();

    public DrawingPanel(ConfigPanel configPanel){


        group.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
            if(me.getButton().equals(MouseButton.PRIMARY)) {
               // Circle circle = new Circle(me.getX(), me.getY(), configPanel.getV_inputSize(), Color.rgb(0,0,0,0.5));

               RegularPolygon regularPolygon = new RegularPolygon(me, configPanel);

                addEventHandler(group, regularPolygon.getStyleableNode());
                group.getChildren().add(regularPolygon.getPolygon());
            }
        });

    }

    public BorderPane getBox() {
        return group;
    }

    public void setBox(BorderPane box) {
        this.group = box;
    }

    public void addEventHandler(BorderPane parent, Node node) {
        node.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
            if(me.getButton().equals(MouseButton.SECONDARY)) {
                parent.getChildren().remove(node);
            }
        });
    }
}
