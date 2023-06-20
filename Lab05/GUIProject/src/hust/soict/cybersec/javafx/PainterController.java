package hust.soict.cybersec.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PainterController {

    Paint color = Color.BLACK;

    @FXML
    private RadioButton btnEraser;

    @FXML
    private RadioButton btnPen;

    @FXML
    private ToggleGroup a;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void colorChangeEventHandler(ActionEvent event) {
        if (btnEraser.isSelected())
        {
            color = Color.WHITE;
        }
        else
        {
            color = Color.BLACK;
        }
    }

}

