package dominos;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import static dominos.Constants.rectangleHeight;
import static dominos.Constants.rectangleWeigth;

public class DrawPlayedDomino extends Pane {

    Rectangle rectangle1 = new Rectangle();

    public Rectangle setRectangle(Dominos dominoss) {
        String dominoNamee = String.format("dominoImages/%d-%d.png", dominoss.getLeft(), dominoss.getRight());
        Image imagee = new Image(dominoNamee);
        rectangle1.setFill(new ImagePattern(imagee));
        rectangle1.setHeight(rectangleHeight);
        rectangle1.setWidth(rectangleWeigth);
        getChildren().add(rectangle1);
        return rectangle1;
    }
}
