package sample;


import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

public class RegularPolygon extends Node {

    private Polygon polygon;
    private int sides;

    public RegularPolygon(MouseEvent me, ConfigPanel configPanel){

        polygon = new Polygon();
        sides = configPanel.getV_inputSides();

        List<Double> aux = new ArrayList<>();

        // se creeaza shape ul dorit
        double alpha = 2 * Math.PI / configPanel.getV_inputSides();
        for (int i = 0; i < configPanel.getV_inputSides(); i++) {
            double x = me.getX() + configPanel.getV_inputSize() * Math.cos(alpha * i);
            double y = me.getY() + configPanel.getV_inputSize()  * Math.sin(alpha * i);
            aux.add(x);
            aux.add(y);
        }
        // se scrie in polygon care mai apoi este transmis canvasului
        for(Double index: aux){
            polygon.getPoints().add(index);
        }
        polygon.setFill(Color.rgb((int)me.getX()%255,(int)me.getY()%255,((int)me.getX()+(int)me.getY())%255,0.4));
    }

    public Node getPolygon() {
        return polygon;
    }

    public Polygon getPolygonShape(){
        return polygon;
    }

    public int getSides() {
        return sides;
    }

    public void addEventHandler(EventType<MouseEvent> mouseClicked, Object o) {
    }

    @Override
    public Node getStyleableNode() {
        return polygon;
    }
}
