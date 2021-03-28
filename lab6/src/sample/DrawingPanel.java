package sample;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;


public class DrawingPanel {
    Path path = new Path();
    private BorderPane group = new BorderPane();
    static int isLine = 1;
    static int isCircle = 1;
    static double x1 = -1, y1 = -1;
    static double xMin, yMin;
    static double xMax, yMax;
    static String direction;

    public DrawingPanel(ConfigPanel configPanel) {
        System.out.println("To start press click (default beheviour is free drawing)!");
        // atunci cand facem primul click pe canvas incepem sa desenam
        group.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
            // type = 1 inseamna ca vom fi in modul shape drawing
            if (ConfigPanel.type == 1) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    // atunci cand se apasa click pe canvas vom creea un obiect in functie de
                    // sides si size date in configPanel
                    RegularPolygon regularPolygon = new RegularPolygon(mouseEvent, configPanel);

                    // event pentru modul de stergere
                    addEventHandler(group, regularPolygon.getStyleableNode());
                    group.getChildren().add(regularPolygon.getPolygon());
                }
            } else {
                // ne aflam aici in modul free drawing
                path.setStrokeWidth(1);
                path.setStroke(Color.BLACK);

                // la actiunile mouse ului vom desena rezultatul
                group.setOnMouseClicked(mouseHandler);
                group.setOnMouseDragged(mouseHandler);
                group.setOnMouseEntered(mouseHandler);
                group.setOnMouseExited(mouseHandler);
                group.setOnMouseMoved(mouseHandler);
                group.setOnMousePressed(mouseHandler);
                group.setOnMouseReleased(mouseHandler);
            }
        });
    }

    public BorderPane getBox() {
        return group;
    }

    public void setBox(BorderPane box) {
        this.group = box;
    }

    // delete ul propriu zis care cauta printre elementele canvasului si elimina elementul
    // care a fost selectat cu click dreapta
    public void addEventHandler(BorderPane parent, Node node) {
        node.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
            if (me.getButton().equals(MouseButton.SECONDARY)) {
                parent.getChildren().remove(node);
            }
        });
    }

    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (ConfigPanel.type == 0) {
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    // caluclez centrul cercului
                    double centerY = yMin + (yMax - yMin) / 2;
                    double centerX = xMin + (xMax - xMin) / 2;

                    // distanta de la primul punct al cercului la centrul cercului
                    double distance = Math.sqrt((centerY - ((MoveTo) path.getElements().get(0)).getY()) * (centerY - ((MoveTo) path.getElements().get(0)).getY()) +
                            (centerX - ((MoveTo) path.getElements().get(0)).getX()) * (centerX - ((MoveTo) path.getElements().get(0)).getX()));

                    // daca distanta de la primul element la ultimul este mai mare de 25 atunci inseamna ca nu avem un cerc
                    // teoretic un cerc incepe si se termina in acelasi punct
                    if (Math.sqrt((((LineTo) path.getElements().get(path.getElements().size() - 1)).getY() - ((MoveTo) path.getElements().get(0)).getY()) * (((LineTo) path.getElements().get(path.getElements().size() - 1)).getY() - ((MoveTo) path.getElements().get(0)).getY()) +
                            (((LineTo) path.getElements().get(path.getElements().size() - 1)).getX() - ((MoveTo) path.getElements().get(0)).getX()) * (((LineTo) path.getElements().get((path.getElements().size() - 1))).getX() - ((MoveTo) path.getElements().get(0)).getX())) > 25) {
                        {
                            isCircle = 0;
                        }
                    } else {
                        // se verifica daca distanta de la orice punct la centrul cercului se afla in intervalul 'distance'+-30
                        // cu alte cuvinte, daca exista o raza mai mare decat prima raza gasita, atunci nu avem un cerc
                        for (int index = 1; index < path.getElements().size(); index++) {
                            double distanceCurrent = Math.sqrt((centerY - ((LineTo) (path.getElements().get(index))).getY()) * (centerY - ((LineTo) (path.getElements().get(index))).getY()) +
                                    (centerX - ((LineTo) (path.getElements().get(index))).getX()) * (centerX - ((LineTo) (path.getElements().get(index))).getX()));
                            System.out.println("Distance current: " + distanceCurrent);
                            System.out.println("Distance: " + distance);
                            if (Math.abs(distanceCurrent - distance) > 30) {
                                isCircle = 0;
                            }
                        }

                    }
                    if(isCircle == 1) {
                        System.out.println("Circle!!!");
                    }else
                    if (isLine == 1) {
                        System.out.println("It's a linie, maybe!");
                    } else {
                        System.out.println("Unkown shape");
                    }
                }
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    // initializari la apasarea mouseului
                    isLine = 1;
                    isCircle = 1;

                    // se creeaza path ul (desenul freeDrawing)
                    path = new Path();
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mouseEvent.getX(), mouseEvent.getY()));
                    x1 = mouseEvent.getX();
                    y1 = mouseEvent.getY();
                    xMax = x1;
                    xMin = x1;
                    yMin = y1;
                    yMax = y1;
                }
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    // calculez min/max X/Y folosite la calculcarea centrului cercului
                    if (xMax < mouseEvent.getX())
                        xMax = mouseEvent.getX();
                    if (xMin > mouseEvent.getX())
                        xMin = mouseEvent.getX();
                    if (yMin > mouseEvent.getY())
                        yMin = mouseEvent.getY();
                    if (yMax < mouseEvent.getX())
                        yMax = mouseEvent.getY();

                    // aflu directia in care punctele liniei ar trebui sa mearga
                    // EX: daca primele 2 puncte merg urca (sper NV) si al 3-lea merge in directia opusa atunci nu este o linie
                    if (x1 == -1 && y1 == -1) {
                        if (x1 - mouseEvent.getX() < 0) {
                            if (y1 - mouseEvent.getY() <= 0)
                                direction = "NV";
                            if (y1 - mouseEvent.getY() > 0)
                                direction = "NE";
                        }
                        if (x1 - mouseEvent.getX() > 0) {
                            if (y1 - mouseEvent.getY() <= 0)
                                direction = "SV";
                            if (y1 - mouseEvent.getY() > 0)
                                direction = "SE";
                        }

                    }
                    // "2" este epsilon pentru care accept ca o linie sa nu fie dreapta
                    // adica distanta de la un punct la altul trebuie sa fie maxim 2
                    if (Math.abs(x1 - mouseEvent.getX()) < 2 && Math.abs(y1 - mouseEvent.getY()) < 2) {
                        if (direction == "NV")
                            if (!(x1 - mouseEvent.getX() <= 2 && y1 - mouseEvent.getY() <= 2)) {
                                isLine = 0;
                            }
                        if (direction == "NE")
                            if (!(x1 - mouseEvent.getX() <= 2 && y1 - mouseEvent.getY() >= -2)) {
                                isLine = 0;
                            }
                        if (direction == "SV")
                        if (!(x1 - mouseEvent.getX() >= -2 && y1 - mouseEvent.getY() <= 2)) {
                            isLine = 0;
                        }
                        if (direction == "SE")
                            if (!(x1 - mouseEvent.getX() >= -2 && y1 - mouseEvent.getY() >= -2)) {
                                isLine = 0;
                            }

                    } else {
                        isLine = 0;
                    }
                    x1 = mouseEvent.getX();
                    y1 = mouseEvent.getY();
                    group.getChildren().remove(path);
                    path.getElements().add(new LineTo(x1, y1));
                    group.getChildren().add(path);

                }
            }
        }

    };
}
