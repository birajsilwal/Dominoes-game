package dominos;


import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import static dominos.Constants.*;

public class DrawDominoRectangle extends Pane {

    Rectangle rectangle = new Rectangle();
    MainController mainController = new MainController();

    public Rectangle setRectangle(Dominos dominos) {
        String dominoName = String.format("dominoImages/%d-%d.png", dominos.getLeft(), dominos.getRight());
        Image image = new Image(dominoName);
        rectangle.setFill(new ImagePattern(image));
        rectangle.setHeight(rectangleHeight);
        rectangle.setWidth(rectangleWeigth);

        getChildren().add(rectangle);

        rectangle.setOnMouseClicked(event -> {
            System.out.println("clicked dddd");
            mainController.addPlayedDominoToBoard(dominos);
            System.out.println(dominos);
            rectangle.setVisible(false);
        });

        return rectangle;
    }

}
