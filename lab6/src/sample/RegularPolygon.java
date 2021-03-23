package sample;


import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegularPolygon extends Node {

    private Polygon polygon;

    public RegularPolygon(MouseEvent me, ConfigPanel configPanel){

        polygon = new Polygon();

        List<Double> aux = new ArrayList<>();

        double alpha = 2 * Math.PI / configPanel.getV_inputSides();
        for (int i = 0; i < configPanel.getV_inputSides(); i++) {
            double x = me.getX() + configPanel.getV_inputSize() * Math.cos(alpha * i);
            double y = me.getY() + configPanel.getV_inputSize()  * Math.sin(alpha * i);
            aux.add(x);
            aux.add(y);
        }

        for(Double index: aux){
            polygon.getPoints().add(index);
        }
        polygon.setFill(Color.rgb((int)me.getX()%255,(int)me.getY()%255,((int)me.getX()+(int)me.getY())%255,0.4));
    }

    public Polygon getPolygon() {
        return polygon;
    }



    public void addEventHandler(EventType<MouseEvent> mouseClicked, Object o) {
    }

    @Override
    public Node getStyleableNode() {
        return polygon;
    }
}
