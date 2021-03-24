package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ControlPanel {
    private HBox box = new HBox();

    public ControlPanel(DrawingPanel drawingPanel){
        Button load = new Button("Load");
        Button save = new Button("Save");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");

        load.setOnAction(
        new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                final FileChooser fileChooser = new FileChooser();
                final File selectedFile = fileChooser.showOpenDialog(box.getScene().getWindow());
                if (selectedFile != null) {
                    selectedFile.getAbsolutePath();
                }
                //System.out.println(selectedFile);

                Image image = null;
                try {
                    image = new Image(new FileInputStream(selectedFile));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }

                //Setting the image view
                ImageView imageView = new ImageView(image);

                //Setting the position of the image
                imageView.setX(0);
                imageView.setY(0);

                //setting the fit height and width of the image view
                imageView.setFitHeight(drawingPanel.getBox().getHeight());
                imageView.setFitWidth(drawingPanel.getBox().getWidth());

                //Setting the preserve ratio of the image view
                imageView.setPreserveRatio(true);

                BorderPane root = new BorderPane(imageView);
                drawingPanel.getBox().getChildren().add(root);

                }
            }
        );

        save.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    final DirectoryChooser directoryChooser = new DirectoryChooser();
                    final File selectedDirectory = directoryChooser.showDialog(box.getScene().getWindow());
                    if (selectedDirectory != null) {
                        selectedDirectory.getAbsolutePath();
                    }
                    WritableImage image = drawingPanel.getBox().snapshot( new SnapshotParameters(), null);
                    File file = new File(selectedDirectory + "\\yourArt.png");
                    try {
                        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", file);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
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
