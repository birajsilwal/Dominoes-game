package dominos;


import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;

import static dominos.Constants.*;

public class DrawDominoRectangle extends Pane {

    MainController mainController = new MainController();

    public Dominos setRectangle(Dominos dominos) {
        String dominoName = String.format("dominoImages/%d-%d.png", dominos.getLeft(), dominos.getRight());
        Image image = new Image(dominoName);
        dominos.setFill(new ImagePattern(image));
        dominos.setHeight(rectangleHeight);
        dominos.setWidth(rectangleWeigth);

        getChildren().add(dominos);

        dominos.setOnMouseClicked(event -> {
            System.out.println("clicked dddd");
            System.out.println(dominos);
            mainController.addPlayedDominoToBoard(dominos);
        });

        return dominos;
    }

}
