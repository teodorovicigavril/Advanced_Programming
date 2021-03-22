package sample;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {

        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Work in progress...");
        this.setBounds(100,50,500,600);

        //create the components
        canvas = new DrawingPanel(this);
 //...TODO

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
 //...TODO

        //invoke the layout manager
        // pack();
    }

    private void add(DrawingPanel canvas, String center) {
    }
}
