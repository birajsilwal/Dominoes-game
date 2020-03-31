package dominos;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;

import java.util.List;

import static dominos.Constants.*;

public class DrawDominoRectangle extends Pane {

    MainController mainController;

    public DrawDominoRectangle(MainController mainController) {
        this.mainController = mainController;
    }

    public Dominos setRectangle(Dominos dominos, List<Dominos> humanHand) {
        String dominoName = String.format("dominoImages/%d-%d.png", dominos.getLeft(), dominos.getRight());
        Image image = new Image(dominoName);
        dominos.setFill(new ImagePattern(image));
        dominos.setHeight(rectangleHeight);
        dominos.setWidth(rectangleWeight);

        getChildren().add(dominos);

        dominos.setOnMouseClicked(event -> {
//            dominos.setVisible(false);
            humanHand.remove(dominos);
            mainController.addPlayedDominoToBoard(dominos);
        });
        return dominos;
    }
}
